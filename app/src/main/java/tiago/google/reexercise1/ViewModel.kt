package tiago.google.reexercise1

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import tiago.google.reexercise1.model.Item
import tiago.google.reexercise1.repo.Repository


class MyViewModel(app: Application) : AndroidViewModel(app) {

    val items: LiveData<List<Item>> = MutableLiveData()

    //TODO: To be implemented
    private val repository by lazy {
        Repository()
    }


    fun loadItems(mContext: Context){
        repository.get(object : Callback<List<Item>> {
            override fun onResponse(
                call: Call<List<Item>>,
                response: Response<List<Item>>
            ) {
                (items as MutableLiveData).value = response.body()
            }

            override fun onFailure(call: Call<List<Item>>, throwable: Throwable) {
                Toast.makeText(mContext, "Could not get list", Toast.LENGTH_LONG).show()
            }
        })


    }

}

