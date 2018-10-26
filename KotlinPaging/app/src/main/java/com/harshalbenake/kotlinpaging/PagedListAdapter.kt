package com.harshalbenake.kotlinpaging


import android.arch.paging.PagedListAdapter
import android.support.v7.recyclerview.extensions.DiffCallback
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class PagedListAdapter(diffCallback: DiffCallback<User>) : PagedListAdapter<User, com.harshalbenake.kotlinpaging.PagedListAdapter.ViewHolder>(diffCallback) {

    override fun onBindViewHolder(holder: com.harshalbenake.kotlinpaging.PagedListAdapter.ViewHolder?, position: Int) {
        getItem(position)?.let {
            holder?.setData(it)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): com.harshalbenake.kotlinpaging.PagedListAdapter.ViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.rowitem_pagination, parent, false)
        return ViewHolder(view)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val tv_name: TextView = view.findViewById(R.id.tv_name)
        private val tv_email: TextView = view.findViewById(R.id.tv_email)
        fun setData(u: User) {
            tv_name.text = u.firstName
            tv_email.text = u.email
        }

    }
}