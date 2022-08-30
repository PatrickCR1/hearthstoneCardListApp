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

        fun getHttpClientInstance(): OkHttpClient {
            return OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                })
                .addInterceptor(object : Interceptor {
                    override fun intercept(chain: Interceptor.Chain): Response {
                        val request = chain.request()
                            .newBuilder()
                            .addHeader(HSConstants.HEADER.RAPID_KEY, HSConstants.HEADER.KEY)
                            .addHeader(HSConstants.HEADER.RAPID_HOST, HSConstants.HEADER.HOST)
                            .build()
                        return chain.proceed(request)
                    }
                })
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .build()
        }

        fun getRetrofitInstance(httpClient: OkHttpClient): Retrofit {

            return synchronized(RetrofitClient::class) {
                Retrofit.Builder()
                    .baseUrl(HSConstants.BUILDER.BASE_URL)
                    .client(httpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
        }
    }
}
