package com.micpol.norbsoft_recruitment_task.architecture.di.module

import com.google.gson.Gson
import com.micpol.norbsoft_recruitment_task.BuildConfig
import com.micpol.norbsoft_recruitment_task.data.network.ApiService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

private const val BASE_URL = "http://api.norbsoft.com"
private const val CONNECT_TIMEOUT = 10L
private const val READ_TIMEOUT = 10L
private const val WRITE_TIMEOUT = 10L

@Module(
    includes = [
        NetworkModule.Providers::class
    ]
)
abstract class NetworkModule {

    @Module
    class Providers {

        @Provides
        @Singleton
        fun provideOkHttpClientBuilder(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
            val builder = OkHttpClient.Builder()
                .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
                .retryOnConnectionFailure(false)

            if (BuildConfig.DEBUG) {
                builder.addInterceptor(httpLoggingInterceptor)
            }
            return builder.build()
        }

        @Provides
        @Singleton
        fun provideHttpLoggingInterceptor() = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        @Provides
        @Singleton
        fun provideGsonFactory(gson: Gson): GsonConverterFactory = GsonConverterFactory.create(gson)

        @Provides
        @Singleton
        fun provideUnauthorizedApiService(
            httpClient: OkHttpClient,
            gsonConverterFactory: GsonConverterFactory
        ): ApiService {
            return Retrofit.Builder()
                .client(httpClient)
                .addConverterFactory(gsonConverterFactory)
                .baseUrl(BASE_URL)
                .build()
                .create(ApiService::class.java)
        }
    }
}
