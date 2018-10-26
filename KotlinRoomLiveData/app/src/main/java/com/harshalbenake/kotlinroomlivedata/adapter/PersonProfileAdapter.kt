package com.harshalbenake.kotlinroomlivedata.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.harshalbenake.kotlinroomlivedata.R
import com.harshalbenake.kotlinroomlivedata.data.model.PersonProfile

class PersonProfileAdapter(personProfile: ArrayList<PersonProfile>, listener: OnItemClickListener) : RecyclerView.Adapter<PersonProfileAdapter.RecyclerViewHolder>() {

    private var listPersonProfile: List<PersonProfile> = personProfile

    private var listenerPersonProfile: OnItemClickListener = listener

    interface OnItemClickListener {
        fun onItemClick(personProfile: PersonProfile)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerViewHolder {
        return RecyclerViewHolder(LayoutInflater.from(parent!!.context).inflate(R.layout.rowitem_personprofile, parent, false))
    }

    override fun getItemCount(): Int {
        return listPersonProfile.size
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder?, position: Int) {
        var currentPersonProfile: PersonProfile = listPersonProfile[position]

        holder!!.mName.text = currentPersonProfile.name
        holder!!.mAge.text = currentPersonProfile.age

        holder.bind(currentPersonProfile, listenerPersonProfile)

    }

    fun addContacts(listPersonProfile: List<PersonProfile>) {
        this.listPersonProfile = listPersonProfile
        notifyDataSetChanged()
    }

    class RecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var mName = itemView.findViewById<TextView>(R.id.name_contact)!!
        var mAge = itemView.findViewById<TextView>(R.id.number_contact)!!

        fun bind(personProfile: PersonProfile, listener: OnItemClickListener) {
            itemView.setOnClickListener {
                listener.onItemClick(personProfile)
            }
        }
    }
}