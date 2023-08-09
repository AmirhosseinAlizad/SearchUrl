package com.example.searchurl

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.searchurl.data.repository.PostsRepository
import com.example.searchurl.databinding.ActivityMainBinding
import com.example.searchurl.ui.viewmodel.MainViewModelFactory
import com.example.searchurl.ui.viewmodel.PostsViewModel

private lateinit var model: PostsViewModel
lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        bindViews()
    }

    private fun bindViews() {
        val repository = PostsRepository()
        val viewModelFactory = MainViewModelFactory(application, repository)
        model = ViewModelProvider(this, viewModelFactory)[PostsViewModel::class.java]
        binding.button.setOnClickListener {
            val number = binding.editText.text.toString().toInt()
            model.getPostsNumber(number)
            model.PostNumberResponse.observe(this) { response ->
                if (response.isSuccessful) {
                    binding.text.text = response.body()?.toString()

                } else {
                    binding.text.text = response.code().toString()
                }
            }
        }
    }
}
