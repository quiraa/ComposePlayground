package com.quiraadev.m3pagingsource.data.remote

import retrofit2.HttpException
import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.quiraadev.m3pagingsource.data.local.BeerDatabase
import com.quiraadev.m3pagingsource.data.local.BeerEntity
import java.io.IOException

@OptIn(ExperimentalPagingApi::class)
class BeerRemoteMediator(
    private val beerDb : BeerDatabase,
    private val beerApi : BeerApi
) : RemoteMediator<Int, BeerEntity>() {
    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, BeerEntity>
    ): MediatorResult {
        return try {
            val loadKey = when(loadType) {
                LoadType.REFRESH -> 1
                LoadType.PREPEND -> return MediatorResult.Success(
                    endOfPaginationReached = true
                )
                LoadType.APPEND -> {
                    val lastItem = state.lastItemOrNull()
                    if (lastItem == null) {
                        1
                    } else {
                        (lastItem.id / state.config.pageSize) + 1
                    }
                }
            }
            val beers = beerApi.getAllBeers(
                page = loadKey,
                pageCount = state.config.pageSize
            )

            beerDb.withTransaction {
                if(loadType == LoadType.REFRESH){
                    beerDb.dao.clearAllBeers()
                }
                val beerEntities = beers.map { it.toBeerEntity() }
                beerDb.dao.upsertAllBeers(beerEntities)
            }

            MediatorResult.Success(
                endOfPaginationReached = beers.isEmpty()
            )
        } catch (err : IOException) {
            MediatorResult.Error(err)
        } catch (httpError : HttpException) {
            MediatorResult.Error(httpError)
        }
    }

}