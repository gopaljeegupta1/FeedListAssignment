package com.example.feedlist.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView

import com.example.feedlist.R
import com.example.feedlist.databinding.MyListBinding
import com.example.feedlist.viewmodel.MyListViewModel

class MyAdapter(private val listViewModels: List<MyListViewModel?>, private val context: Context) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    private var layoutInflater: LayoutInflater? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.context)
        }
        val myListBinding = DataBindingUtil.inflate<MyListBinding>(layoutInflater!!, R.layout.mylist, parent, false)
        return ViewHolder(myListBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val myListViewModel = listViewModels[position]
        holder.bind(myListViewModel)
    }

    override fun getItemCount(): Int {
        return listViewModels.size
    }

    inner class ViewHolder(private val myListBinding: MyListBinding) : RecyclerView.ViewHolder(myListBinding.root) {

        fun bind(myli: MyListViewModel?) {
            this.myListBinding.mylistmodel = myli
            myListBinding.executePendingBindings()
        }


    }
}