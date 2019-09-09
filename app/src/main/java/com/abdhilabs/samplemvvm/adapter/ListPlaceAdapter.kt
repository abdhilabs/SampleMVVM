package com.abdhilabs.samplemvvm.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.abdhilabs.samplemvvm.R
import com.abdhilabs.samplemvvm.databinding.ItemPlaceBinding
import com.abdhilabs.samplemvvm.model.ResponseModel
import com.abdhilabs.samplemvvm.viewmodel.ItemPlaceViewModel

class ListPlaceAdapter(val context: Context):RecyclerView.Adapter<ListPlaceAdapter.ItemPlaceViewHolder>() {

    private var listPlace: MutableList<ResponseModel.PlaceModel> = mutableListOf()

    fun setData(list: MutableList<ResponseModel.PlaceModel>){
        this.listPlace = list
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemPlaceViewHolder {
        return ItemPlaceViewHolder(DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.item_place,parent,false))
    }

    override fun getItemCount(): Int = listPlace.size

    override fun onBindViewHolder(holder: ItemPlaceViewHolder, position: Int) {
        holder.bind(listPlace[holder.adapterPosition])
    }


    //Ngarah ke item_place(bindingnya/itemViewnya)
    class ItemPlaceViewHolder(private val binding:ItemPlaceBinding):RecyclerView.ViewHolder(binding.root) {

        //ngarah ke nama variable
        fun bind(model:ResponseModel.PlaceModel){
            val viewModel = ItemPlaceViewModel(model)
            binding.itemPlace = viewModel
        }
    }
}