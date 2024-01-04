@file:OptIn(ExperimentalPagingApi::class)

package com.quiraadev.m3pagingsource.data.remote

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import com.quiraadev.m3pagingsource.data.local.BeerDatabase
import com.quiraadev.m3pagingsource.data.local.BeerEntity

class BeerRemoteMediator(
    private val beerDb : BeerDatabase,
    private val beerApi : BeerApi
) : RemoteMediator<Int, BeerEntity>() {
    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, BeerEntity>
    ): MediatorResult {
        TODO("Not yet implemented")
    }

}