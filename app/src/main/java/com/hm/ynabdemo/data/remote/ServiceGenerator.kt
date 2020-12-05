package com.hm.ynabdemo.data.remote

import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import com.hm.ynabdemo.BASE_URL
import com.hm.ynabdemo.BuildConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Singleton


/**
 * Created by HalaAdly
 */

private const val timeoutRead = 30   //In seconds
private const val contentType = "Content-Type"
private const val contentTypeValue = "Content-Type: application/json; charset=utf-8"
private const val timeoutConnect = 30   //In seconds

@Singleton
class ServiceGenerator @Inject constructor() {
    private val okHttpBuilder: OkHttpClient.Builder = OkHttpClient.Builder()
    private val retrofit: Retrofit

    private var headerInterceptor = Interceptor { chain ->
        val original = chain.request()

        val request = original.newBuilder()
                .header("Authorization", "Bearer " + BuildConfig.USER_ACCESS_TOKEN)
                .method(original.method(), original.body())
                .build()

        chain.proceed(request)
    }
    private var headerInterceptorType = Interceptor { chain ->
        val original = chain.request()

        val request = original.newBuilder()
                .header(contentType, contentTypeValue)
                .method(original.method(), original.body())
                .build()

        chain.proceed(request)
    }

    private val logger: HttpLoggingInterceptor
        get() {
            val loggingInterceptor = HttpLoggingInterceptor()
            if (BuildConfig.DEBUG) {
                loggingInterceptor.apply { level = HttpLoggingInterceptor.Level.BODY }
            }
            return loggingInterceptor
        }

    init {

        okHttpBuilder.addInterceptor(headerInterceptor)
        okHttpBuilder.addInterceptor(headerInterceptorType)
        okHttpBuilder.addInterceptor(logger)
        okHttpBuilder.connectTimeout(timeoutConnect.toLong(), TimeUnit.SECONDS)
        okHttpBuilder.readTimeout(timeoutRead.toLong(), TimeUnit.SECONDS)
        val client = okHttpBuilder.build()
        retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(getGsonConverter())
                .baseUrl(BASE_URL).client(client)
                .build()
    }

    fun <S> createService(serviceClass: Class<S>): S {
        return retrofit.create(serviceClass)
    }

    private fun getGsonConverter(): GsonConverterFactory {
//        val gson = GsonBuilder()
//                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_DASHES)
//                .create()
//        return GsonConverterFactory.create(gson)
        return GsonConverterFactory.create()
    }
}
