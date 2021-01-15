package com.lizhiweather.android.logic

import androidx.lifecycle.liveData
import com.lizhiweather.android.logic.model.Place
import com.lizhiweather.android.logic.network.LizhiWeatherNetwork
import kotlinx.coroutines.Dispatchers
import okhttp3.Dispatcher
import java.lang.Exception
import java.lang.RuntimeException


object Repository {
    fun searchPlaces(query: String) = liveData(Dispatchers.IO) {
        val result = try {
            val placeResponse = LizhiWeatherNetwork.searchPlaces(query)
            if(placeResponse.status == "ok"){
                val places = placeResponse.places
                Result.success(places)
            }else{
                Result.failure(RuntimeException("resonse status is ${placeResponse.status}"))
            }
        }catch (e: Exception){
            Result.failure<List<Place>>(e)
        }
        emit(result)
    }

}