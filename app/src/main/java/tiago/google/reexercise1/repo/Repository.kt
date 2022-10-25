package tiago.google.reexercise1.repo

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import tiago.google.reexercise1.model.Item


class Repository {
    private var myApi: Api? = null

    init {
        val retrofit: Retrofit = Retrofit.Builder().baseUrl(Api.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        myApi = retrofit.create(Api::class.java)
    }

    fun get(callback: Callback<List<Item>>) {
        val call: Call<List<Item>> = myApi!!.get()
        call.enqueue(callback)
    }
}