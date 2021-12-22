package com.testdemo.base

import android.util.Log
import com.google.gson.Gson
import com.google.gson.JsonArray
import com.google.gson.JsonParser
import com.google.gson.JsonSyntaxException
import java.lang.reflect.Type
import java.text.SimpleDateFormat
import java.util.*


object BaseUtil {

    private val GSON = Gson()
    private val TAG = javaClass.simpleName

    fun <Model> objectFromString(json: String, classOfModel: Class<Model>): Model? {
        Log.d(
            TAG,
            "objectFromString() called with: json = [$json], classOfModel = [$classOfModel]"
        )
        var model: Model? = null
        try {
            model = GSON.fromJson(json, classOfModel)
        } catch (e: JsonSyntaxException) {
            Log.d(TAG, "JsonSyntaxException", e)
        } catch (e: Exception) {
            Log.d(TAG, "Exception", e)
        }
        return model
    }


    fun <Model> jsonFromModel(model: Model): String? {
        var json: String? = null
        try {
            json = GSON.toJson(model)
        } catch (e: JsonSyntaxException) {
            Log.d(TAG, "JsonSyntaxException", e)
        } catch (e: Exception) {
            Log.d(TAG, "Exception", e)
        }
        Log.d(TAG, "jsonFromModel() called with: model = [$model]$json")
        return json
    }
    fun convertDateTime(value: String): String {
        val input = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS")
        val output = SimpleDateFormat("MMM-dd-yyyy")
        var dateFormatted = ""
        try {
            input.timeZone = TimeZone.getDefault()
            val date: Date = input.parse(value)
            output.timeZone = TimeZone.getDefault()
            dateFormatted = output.format(date)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return dateFormatted
    }



}