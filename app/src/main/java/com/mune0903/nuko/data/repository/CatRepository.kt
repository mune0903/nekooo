package com.mune0903.nuko.data.repository

import com.mune0903.nuko.core.entity.Cat

interface CatRepository {

    suspend fun fetchCats(limit: Int, page: Int): Result<List<Cat>>
}