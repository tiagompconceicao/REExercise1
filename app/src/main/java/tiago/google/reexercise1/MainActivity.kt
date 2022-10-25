package tiago.google.reexercise1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.squareup.picasso.Picasso
import tiago.google.reexercise1.databinding.ActivityMainBinding
import tiago.google.reexercise1.view.ListAdapter

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val viewModel: MyViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        Picasso.get().load("https://cdn.internationalliving.com/wp-content/uploads/2020/01/Portugal-Feature-580x353.jpg").into(binding.image);

        //TODO: Testing
        /**
         * Inicializar o recycler view
         * Observe do campo do viewmodel
         */

        val mLayoutManager = LinearLayoutManager(this)
        mLayoutManager.reverseLayout = false
        binding.recyclerView.layoutManager = mLayoutManager

        viewModel.items.observe(this){
            val listAdapter = ListAdapter(it)
            binding.recyclerView.adapter = listAdapter
        }

        viewModel.loadItems(this)

    }
}