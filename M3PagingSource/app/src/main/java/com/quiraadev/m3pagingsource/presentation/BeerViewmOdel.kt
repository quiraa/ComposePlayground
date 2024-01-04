package com.quiraadev.m3pagingsource.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.cachedIn
import androidx.paging.map
import com.quiraadev.m3pagingsource.data.local.BeerEntity
import com.quiraadev.m3pagingsource.data.remote.toBeer
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class BeerViewmOdel @Inject constructor(
    pager: Pager<Int, BeerEntity>
): ViewModel() {

    val beerPagingFlow = pager
        .flow
        .map { pagingData ->
            pagingData.map { it.toBeer() }
        }
        .cachedIn(viewModelScope)
}