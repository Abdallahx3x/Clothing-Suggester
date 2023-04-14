package com.example.clothing_suggestor

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.clothing_suggestor.data.DataManager
import com.example.clothing_suggestor.data.WeatherData
import com.example.clothing_suggestor.databinding.HomeFragmentBinding
import com.example.clothing_suggestor.util.PrefUtil
import com.google.gson.Gson
import okhttp3.*
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*



class HomeFragment: Fragment() {
    lateinit var binding: HomeFragmentBinding

    private val client=OkHttpClient()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= HomeFragmentBinding.inflate(inflater,container,false)

        makeOKHTTPRequest()

        return binding.root
    }


    private fun makeOKHTTPRequest() {
        val url =HttpUrl.Builder()
            .scheme("https")
            .host("api.tomorrow.io")
            .addPathSegment("v4")
            .addPathSegment("timelines")
            .addQueryParameter("location", "26.549999,31.700001")
            .addQueryParameter("fields", "temperature")
            .addQueryParameter("timesteps", "1h")
            .addQueryParameter("units", "metric")
            .addQueryParameter("apikey", "cTAFl4IspRniZXVeIWCVvCheAI3FrhCA")
            .build()

        val request=Request.Builder().url(url)
            .build()

        client.newCall(request).enqueue(object :Callback{
            override fun onFailure(call: Call, e: IOException){
                throw Exception("Failed to make HTTP request")

            }

            override fun onResponse(call: Call, response: Response) {
                response.body?.string()?.let {jsonString->
                    val weatherData = Gson().fromJson(jsonString, WeatherData::class.java)
                    requireActivity().runOnUiThread {
                        val temperature = weatherData.data.timelines[0].intervals[8].values.temperature
                        binding.textTemperature.text= temperature.toString()

                        setup(temperature,presentDay())

                    }

                }
            }

        })

    }

    private fun presentDay(): String {
        return SimpleDateFormat("EEEE", Locale.ENGLISH).format(Calendar.getInstance().time)
            .toString()
    }

    fun setup(temperature:Double,date:String){
        PrefUtil.initPrefUtil(requireContext())

        val listOfClothe=suggestClothesBasedOnTemperature(temperature,date)

        saveClothes(listOfClothe,date)

        val adapter=ClotheAdapter(listOfClothe)
        binding.recyclerClothe.adapter=adapter


    }


    private fun suggestClothesBasedOnTemperature(temperature: Double, date: String): MutableList<ClotheImage> {
        val isColdWeather = temperature < 20


        val clothesList = if(loadDate() == "null") {
            when {
                isColdWeather -> randomList(DataManager.winterLists)
                else ->randomList(DataManager.summerLists)
            }
        } else
            when {
                loadDate() == date -> loadSaveClothes() as MutableList<ClotheImage>
                isColdWeather -> generateRandomClothesList(DataManager.winterLists, loadSaveClothes(), loadDate(), date)
                else -> generateRandomClothesList(DataManager.summerLists, loadSaveClothes(), loadDate(), date)
            }

        return clothesList
    }

    private fun generateRandomClothesList(
        clothesSource: MutableList<MutableList<ClotheImage>>,
        savedClothes: List<ClotheImage>,
        savedDate: String,
        date: String
    ): MutableList<ClotheImage> {

        val randomListOfClothes= randomList(clothesSource)

        return if (savedClothes == randomListOfClothes && savedDate != date) {
            val filteredClothes = clothesSource.filter { it != randomListOfClothes }
            val randomIndex = Random().nextInt(filteredClothes.size)
            filteredClothes[randomIndex]
        } else {
            randomListOfClothes
        }
    }

    private fun randomList(list:MutableList<MutableList<ClotheImage>>):MutableList<ClotheImage>{
        val random= Random()
        val randomIndex=random.nextInt(list.size)
        return list[randomIndex]
    }

    private fun saveClothes(listOfClothe:MutableList<ClotheImage>,date:String){
        PrefUtil.clotheList=listOfClothe
        PrefUtil.date=date
    }

    private fun loadSaveClothes():List<ClotheImage>{
        return PrefUtil.clotheList
    }

    private fun loadDate():String{
        if(PrefUtil.date==null)
            PrefUtil.date="null"

        return PrefUtil.date!!
    }

}