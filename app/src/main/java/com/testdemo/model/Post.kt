package com.testdemo.model

import com.google.gson.annotations.SerializedName


data class Post(

    @field:SerializedName("results")
    val results:List<Result> ?= null,

    @field:SerializedName("info")
    val info: Info? = null,
    )
data class Result(

    @field:SerializedName("gender")
    val gender: String? = null,

    @field:SerializedName("name")
    val name: Name? = null,

    @field:SerializedName("location")
    var location: Location? = null,

    @field:SerializedName("email")
    val email: String? = null,

    @field:SerializedName("login")
    val login: Login? = null,

    @field:SerializedName("dob")
    var dob: Dob? = null,

    @field:SerializedName("registered")
    var registered: Registered? = null,

    @field:SerializedName("phone")
    val phone: String? = null,
    @field:SerializedName("cell")
    val cell: String? = null,
    @field:SerializedName("nat")
    val nat: String? = null,
    @field:SerializedName("id")
    val id: Id? = null,
    @field:SerializedName("picture")
    val picture: Picture? = null,

)

data class Info(
    @field:SerializedName("seed")
    val seed: String? = null,
    @field:SerializedName("results")
    val results: Integer? = null,
    @field:SerializedName("page")
    val page: Integer? = null,
    @field:SerializedName("version")
    val version: String? = null,
)
data class Name(
    @field:SerializedName("title")
    val title: String? = null,
    @field:SerializedName("first")
    val first: String? = null,
    @field:SerializedName("last")
    val last: String? = null,
)

data class Location(
    @field:SerializedName("street")
    val street: Street? = null,
    @field:SerializedName("city")
    val city: String? = null,
    @field:SerializedName("state")
    val state: String? = null,
    @field:SerializedName("country")
    val country: String? = null,
    @field:SerializedName("postcode")
    val postcode: String? = null,
    @field:SerializedName("coordinates")
    val coordinates: Coordinates? = null,
    @field:SerializedName("timezone")
    val timezone: Timezone? = null,
)
data class Login(
    @field:SerializedName("uuid")
    val uuid: String? = null,
    @field:SerializedName("username")
    val username: String? = null,
    @field:SerializedName("password")
    val password: String? = null,
    @field:SerializedName("salt")
    val salt: String? = null,
    @field:SerializedName("md5")
    val md5: String? = null,
    @field:SerializedName("sha1")
    val sha1: String? = null,
    @field:SerializedName("sha256")
    val sha256: String? = null,
)
data class Registered(
    @field:SerializedName("date")
    val date: String? = null,
    @field:SerializedName("age")
    val age: Integer? = null,
)
data class Dob(
    @field:SerializedName("date")
    val date: String? = null,
    @field:SerializedName("age")
    val age: Integer? = null,

)
data class Id(
    @field:SerializedName("name")
    val name: String? = null,
    @field:SerializedName("value")
    val value: String? = null,

)

data class Picture(
    @field:SerializedName("large")
    val large: String? = null,
    @field:SerializedName("medium")
    val medium: String? = null,
    @field:SerializedName("thumbnail")
    val thumbnail: String? = null,
)
data class Street(
    @field:SerializedName("number")
    val number: Integer? = null,
    @field:SerializedName("name")
    val name: String? = null
)
data class Coordinates(
    @field:SerializedName("latitude")
    val latitude: String? = null,
    @field:SerializedName("longitude")
    val longitude: String? = null
)

data class Timezone(
    @field:SerializedName("offset")
    val offset: String? = null,
    @field:SerializedName("description")
    val description: String? = null
)