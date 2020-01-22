package com.example.feedlist

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import com.example.feedlist.utils.NetworkConnectionInterceptor

import com.example.feedlist.adapter.MyAdapter
import com.example.feedlist.viewmodel.MyListViewModel

class MainActivity : AppCompatActivity() {

    private var swipeRefresh: SwipeRefreshLayout? = null
    private var mRecyclerView: RecyclerView? = null
    private var mAdapter: MyAdapter? = null
    private var myListViewModel: MyListViewModel? = null
    private var toolbar: Toolbar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        NetworkConnectionInterceptor(this@MainActivity)
        initializationViews()
        myListViewModel = ViewModelProviders.of(this).get(MyListViewModel::class.java)
        getPopularBlog()
        swipeRefresh!!.setOnRefreshListener { getPopularBlog() }


    }

    /*
    initialize the all views
     */
    private fun initializationViews() {
        swipeRefresh = findViewById(R.id.swiperefresh)
        mRecyclerView = findViewById(R.id.recyclerview)

        toolbar = findViewById<View>(R.id.mToolbar) as Toolbar?
        setSupportActionBar(toolbar)
    }

    fun getPopularBlog() {
        swipeRefresh!!.isRefreshing = true
        myListViewModel!!.getMutableLiveData1().observe(this, Observer { mList ->
            swipeRefresh!!.isRefreshing = false
            toolbar!!.title = myListViewModel!!.title
            prepareRecyclerView(mList)
        })
    }


    /*
    prepare recycle view
     */
    private fun prepareRecyclerView(mList: List<MyListViewModel?>) {
        mAdapter = MyAdapter(mList, this@MainActivity)
        if (this.resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            mRecyclerView!!.layoutManager = LinearLayoutManager(this)
        } else {
            mRecyclerView!!.layoutManager = GridLayoutManager(this, 4)
        }
        mRecyclerView!!.itemAnimator = DefaultItemAnimator()
        mRecyclerView!!.adapter = mAdapter
        mAdapter!!.notifyDataSetChanged()
    }


}
