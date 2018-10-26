package com.harshalbenake.kotlindatabindinglist.Adapters

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.harshalbenake.kotlindatabindinglist.BR
import com.harshalbenake.kotlindatabindinglist.Model.PersonProfile
import com.harshalbenake.kotlindatabindinglist.R
import kotlinx.android.synthetic.main.rowitempersonprofile.view.*

class PersonProfileAdapter(val locallist: List<PersonProfile>) : RecyclerView.Adapter<ViewHolder>() {
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(locallist[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ViewDataBinding = DataBindingUtil.inflate(layoutInflater, R.layout.rowitempersonprofile, parent, false)
        binding.root.tv_email.setTextColor(Color.GRAY)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = locallist.size
}

class ViewHolder(val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(personprofile: PersonProfile) {
        binding.setVariable(BR.personprofile, personprofile)
        binding.executePendingBindings()
    }
}