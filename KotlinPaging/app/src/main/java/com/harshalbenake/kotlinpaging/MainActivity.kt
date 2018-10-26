package com.harshalbenake.kotlinpaging

import android.arch.paging.PagedList
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.support.v7.app.AppCompatActivity
import android.support.v7.recyclerview.extensions.DiffCallback
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.Executor
import java.util.concurrent.Executors

class MainActivity : AppCompatActivity() {
    private var visibleThreshold = 10
    private var lastVisibleItem: Int = 0
    private var totalItemCount: Int = 0
    private var loading: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_pagination.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        val config = PagedList.Config.Builder()
                .setPageSize(10)
                .setInitialLoadSizeHint(10)
                .setEnablePlaceholders(true)
                .build()
        val pagedList = PagedList.Builder<Int, User>()
                .setConfig(config)
                .setDataSource(DataSource())
                .setMainThreadExecutor(UiThreadExecutor())
                .setBackgroundThreadExecutor(BackgroundThreadExecutor())
                .build()
        val adapter = PagedListAdapter(diffCallback)
        rv_pagination.adapter = adapter

        rv_pagination.setOnScrollChangeListener { view, i1, i2, i3, i4 ->
            totalItemCount = rv_pagination.layoutManager.getItemCount();
            lastVisibleItem = (rv_pagination.layoutManager as LinearLayoutManager).findLastVisibleItemPosition();
            loading = !loading && totalItemCount <= (lastVisibleItem + visibleThreshold)
            if(loading){
                pbar_pagination.visibility=View.GONE
            }else{
                pbar_pagination.visibility=View.VISIBLE
            }
        }
        adapter.setList(pagedList)
    }

    internal inner class UiThreadExecutor : Executor {
        private val mHandler = Handler(Looper.getMainLooper())
        override fun execute(command: Runnable) {
            mHandler.post(command)
            runOnUiThread {
                pbar_pagination.visibility=View.GONE
            }
        }
    }

    internal inner class BackgroundThreadExecutor : Executor {
        private val executorService = Executors.newFixedThreadPool(3)
        override fun execute(command: Runnable) {
            executorService.execute(command)
        }
    }


    private val diffCallback = object : DiffCallback<User>() {
        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem == newItem
        }
    }
}