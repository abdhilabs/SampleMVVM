package com.abdhilabs.samplemvvm

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.abdhilabs.samplemvvm.adapter.ListPlaceAdapter
import com.abdhilabs.samplemvvm.databinding.ActivityMainBinding
import com.abdhilabs.samplemvvm.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    private lateinit var adapterList:ListPlaceAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        binding.main = viewModel

        setupRecycleView()
        observeLiveData()

        viewModel.getListPlace()
    }

    private fun setupRecycleView() {
        adapterList = ListPlaceAdapter(this)
        binding.recyclerViewPlace.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = adapterList
        }
    }

    private fun observeLiveData() {
        viewModel.listPlace.observe(this, Observer {
            adapterList.setData(it?.data!!)
            adapterList.notifyDataSetChanged()
        })
        viewModel.error.observe(this, Observer {
            Toast.makeText(this,"You got some error : ${it.message}",Toast.LENGTH_LONG).show()
        })
    }
}
