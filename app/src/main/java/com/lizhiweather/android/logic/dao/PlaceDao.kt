package com.lizhiweather.android.logic.dao

import android.content.Context
import androidx.core.content.edit
import com.google.gson.Gson
import com.lizhiweather.android.LizhiWeatherApplication
import com.lizhiweather.android.logic.model.Place

object PlaceDao {

    private fun sharedPreferences() =
        LizhiWeatherApplication.context.getSharedPreferences("lizhi_weather", Context.MODE_PRIVATE)

    fun savePlace(place: Place) {
        sharedPreferences().edit {
            putString("place", Gson().toJson(place))
        }
    }

    fun getSavedPlace(): Place {
        val placeJson = sharedPreferences().getString("place","")
        return Gson().fromJson(placeJson,Place::class.java)
    }

    fun isPlaceSaved() = sharedPreferences().contains("place")
}