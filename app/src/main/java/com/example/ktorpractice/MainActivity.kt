package com.example.ktorpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ktorpractice.databinding.ActivityMainBinding
import io.ktor.util.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    //https://www.howtodoandroid.com/ktor-android/

    private lateinit var binding: ActivityMainBinding
    lateinit var adapter: RecyclerviewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        adapter = RecyclerviewAdapter()
        binding.recyclerview.adapter = adapter
        fetchAllMovies()
    }

    @KtorExperimentalAPI
    private fun fetchAllMovies()  {
        CoroutineScope(Dispatchers.IO).launch {
            val movieApi = MovieApi()
            val response = movieApi.fetchAllMovies()
            withContext(Dispatchers.Main) {
                adapter.setMovieItems(response)
            }
        }
    }
}