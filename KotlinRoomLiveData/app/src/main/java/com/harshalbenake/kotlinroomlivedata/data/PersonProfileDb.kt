package com.harshalbenake.kotlinroomlivedata.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.harshalbenake.kotlinroomlivedata.data.model.PersonProfile

@Database(entities = [(PersonProfile::class)], version = 1, exportSchema = false)
abstract class PersonProfileDb : RoomDatabase() {
    companion object {
        private var INSTANCE: PersonProfileDb? = null
        fun getDataBase(context: Context): PersonProfileDb {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context.applicationContext, PersonProfileDb::class.java, "personprofile-db")
                        .allowMainThreadQueries().build()
            }
            return INSTANCE as PersonProfileDb
        }
    }

    abstract fun personProfileDAO(): PersonProfileDAO
}