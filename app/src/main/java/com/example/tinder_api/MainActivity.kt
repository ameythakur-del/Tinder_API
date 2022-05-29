package com.example.tinder_api

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.tinder_api.database.repository.Repository

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val application = this.application

        val dataSource = Repository()

        val viewModelFactory = MainViewModelFactory(dataSource, application)

        val viewModel =
            ViewModelProvider(
                this, viewModelFactory
            ).get(MainViewModel::class.java)


        Log.d("Results", viewModel.resultResponse.value.toString())




    }
}