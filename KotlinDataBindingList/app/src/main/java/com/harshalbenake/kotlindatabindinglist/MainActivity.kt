package com.harshalbenake.kotlindatabindinglist

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.harshalbenake.kotlindatabindinglist.Adapters.PersonProfileAdapter
import com.harshalbenake.kotlindatabindinglist.Model.PersonProfile

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main)

        //array variable initialized
        var listItems = arrayListOf<PersonProfile>()
        //arraylist item added
        for (i in 0..10) {
            listItems.add(PersonProfile("Harshal Benake " + i, "harshalbenake" + i + "@gmail.com", 28 + i))
        }

        val recyclerView = findViewById<RecyclerView>(R.id.rv_personprofile)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = PersonProfileAdapter(listItems)
    }
}
