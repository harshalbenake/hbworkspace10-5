package com.harshalbenake.kotlindatabindinglist.Model

/**
 * Used as a layout variable to provide static properties name, emails and age
 */
data class PersonProfile(
        val name: String,
        val email: String,
        val age: Int
)