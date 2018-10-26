package com.harshalbenake.kotlinpaging

import android.arch.paging.KeyedDataSource

class DataSource : KeyedDataSource<Int, User>() {

    override fun loadInitial(pageSize: Int): MutableList<User> {
        return MockDataProvider.loadAfter(0, pageSize)
    }

    override fun loadBefore(currentBeginKey: Int, pageSize: Int): MutableList<User> {
        return MockDataProvider.loadBefore(currentBeginKey, pageSize)
    }

    override fun getKey(item: User): Int {
        return item.id
    }

    override fun loadAfter(currentEndKey: Int, pageSize: Int): MutableList<User> {
        return MockDataProvider.loadAfter(currentEndKey, pageSize)
    }
}