package com.quiraadev.m3pagingsource.data.remote

import com.quiraadev.m3pagingsource.data.local.BeerEntity
import com.quiraadev.m3pagingsource.domain.Beer

fun BeerDto.toBeerEntity(): BeerEntity {
    return BeerEntity(
        id = id,
        name = name,
        tagline = tagline,
        description = description,
        imageUrl = imageUrl
    )
}

fun BeerEntity.toBeer(): Beer {
    return Beer(
        id = id,
        name = name,
        tagline = tagline,
        description = description,
        imageUrl = imageUrl
    )
}