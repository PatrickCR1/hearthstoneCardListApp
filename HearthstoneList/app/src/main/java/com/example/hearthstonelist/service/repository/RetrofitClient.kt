package com.example.hearthstonelist.service.repository

import com.example.hearthstonelist.service.constants.HSConstants
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClient private constructor() {

    companion object {
        private lateinit var INSTANCE: Retrofit

        private fun getRetrofitInstance(): Retrofit {

            // Logging
            val logging = HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }

            // Headers
            val httpClient = OkHttpClient.Builder()
            httpClient.addInterceptor(logging)
            httpClient.addInterceptor(object : Interceptor {
                override fun intercept(chain: Interceptor.Chain): Response {
                    val request = chain.request()
                        .newBuilder()
                        .addHeader(HSConstants.HEADER.RAPID_KEY, HSConstants.HEADER.KEY)
                        .addHeader(HSConstants.HEADER.RAPID_HOST, HSConstants.HEADER.HOST)
                        .build()
                    return chain.proceed(request)
                }
            })


            httpClient.readTimeout(60, TimeUnit.SECONDS)
            httpClient.connectTimeout(60, TimeUnit.SECONDS)

            // Singleton
            if (!Companion::INSTANCE.isInitialized) {
                synchronized(RetrofitClient::class) {
                    INSTANCE = Retrofit.Builder()
                        .baseUrl(HSConstants.BUILDER.BASE_URL)
                        .client(httpClient.build())
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                }
            }
            return INSTANCE
        }

        // Service
        fun <T> getService(serviceClass: Class<T>): T {
            return getRetrofitInstance().create(serviceClass)
        }


    }
}