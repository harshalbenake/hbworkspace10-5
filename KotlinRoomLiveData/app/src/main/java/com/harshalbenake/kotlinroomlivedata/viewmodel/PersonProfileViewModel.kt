package com.harshalbenake.kotlinroomlivedata.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.os.AsyncTask
import com.harshalbenake.kotlinroomlivedata.data.model.PersonProfile
import com.harshalbenake.kotlinroomlivedata.data.PersonProfileDb

class PersonProfileViewModel(application: Application) : AndroidViewModel(application) {

    var listPersonProfile: LiveData<List<PersonProfile>>
    private val appDb: PersonProfileDb

    init {
        appDb = PersonProfileDb.getDataBase(this.getApplication())
        listPersonProfile = appDb.personProfileDAO().getAllPersonProfiles()
    }

    fun getListPersonProfiles(): LiveData<List<PersonProfile>> {
        return listPersonProfile
    }

    fun addersonProfile(personProfile: PersonProfile) {
        addAsynTask(appDb).execute(personProfile)
    }


    class addAsynTask(db: PersonProfileDb) : AsyncTask<PersonProfile, Void, Void>() {
        private var personProfileDb = db
        override fun doInBackground(vararg params: PersonProfile): Void? {
            personProfileDb.personProfileDAO().insertPersonProfiles(params[0])
            return null
        }

    }

}