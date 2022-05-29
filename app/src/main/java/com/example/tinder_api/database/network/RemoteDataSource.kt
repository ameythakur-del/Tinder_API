package com.example.tinder_api.database.network



import androidx.databinding.library.BuildConfig
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit



private const val BASE_URL = "https://randomuser.me/"

/**
 * Build the Moshi object that Retrofit will be using, making sure to add the Kotlin adapter for
 * full Kotlin compatibility.
 */
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val client = OkHttpClient.Builder()
    .connectTimeout(2, TimeUnit.MINUTES)
    .writeTimeout(2, TimeUnit.MINUTES) // write timeout
    .readTimeout(2, TimeUnit.MINUTES) // read timeout
    .also {client ->
        if (com.example.tinder_api.BuildConfig.DEBUG) {
            val logging = HttpLoggingInterceptor()
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)
            client.addInterceptor(logging)
        }
    }
    .build()

/**
 * Use the Retrofit builder to build a retrofit object using a Moshi converter with our Moshi
 * object.
 */
private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .client(client)
    .build()


/**
 * A public Api object that exposes the lazy-initialized Retrofit service
 */
object ResultsApi {
    val RETROFIT_SERVICE: ResultsApiService by lazy { retrofit.create(ResultsApiService::class.java) }
}
