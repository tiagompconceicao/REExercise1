package tiago.google.reexercise1.repo

import retrofit2.Call
import retrofit2.http.GET
import tiago.google.reexercise1.model.Item


interface Api {


    @GET("todos")
    fun get(): Call<List<Item>>

    companion object {
        const val BASE_URL = "https://jsonplaceholder.typicode.com"
    }
}