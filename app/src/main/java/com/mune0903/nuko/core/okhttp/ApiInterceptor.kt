package com.mune0903.nuko.core.okhttp

import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class ApiInterceptor(
    private val name: String,
    private val value: String
) : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .header(name, value)
            .build()
        return chain.proceed(request)
    }
}