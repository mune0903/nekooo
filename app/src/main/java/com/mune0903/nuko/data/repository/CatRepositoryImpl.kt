package com.mune0903.nuko.data.repository

import com.mune0903.nuko.core.entity.Cat
import com.mune0903.nuko.data.api.CatService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CatRepositoryImpl @Inject constructor(
    private val service: CatService
) : CatRepository {

    override suspend fun fetchCats(limit: Int, page: Int): Result<List<Cat>> = withContext(Dispatchers.IO) {
        val response = service.fetchCats(limit, page)
        val body = response.body()
        if (response.isSuccessful && body != null) {
            Result.success(body)
        } else {
            Result.failure(Throwable())
        }
    }
}