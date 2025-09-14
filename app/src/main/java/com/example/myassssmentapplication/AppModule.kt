package com.example.myassssmentapplication

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {

    single<Gson> { GsonBuilder().create() }

    single { OkHttpClient.Builder().build() }

    single {
        Retrofit.Builder()
            .baseUrl("https://nit3213api.onrender.com/")   // ✅ base URL
            .client(get())
            .addConverterFactory(GsonConverterFactory.create(get()))
            .build()
    }

    single<ApiService> { get<Retrofit>().create(ApiService::class.java) }
}
