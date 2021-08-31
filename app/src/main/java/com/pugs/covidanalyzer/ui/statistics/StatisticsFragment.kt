package com.pugs.covidanalyzer.ui.statistics

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.gson.JsonObject
import com.pugs.covidanalyzer.R
import com.pugs.covidanalyzer.Retrofit_Instance
import com.pugs.covidanalyzer.Service
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class StatisticsFragment : Fragment(R.layout.fragment_statistics) {

    companion object {
        //fun newInstance() = StatisticsFragment()
    }

    //private late_init var viewModel: StatisticsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_statistics, container, false)
        val service = Retrofit_Instance.getRetrofitInstance().create(
            Service::class.java
        )


        val call: Call<JsonObject>? = service.minData
        call?.enqueue(object : Callback<JsonObject> {
            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                try {
                    val resBody = response.body().toString()
                    val jo = JSONObject(resBody)

                    for (key in jo.keys()) {
                        Log.e("key", key)
                        val tot = (jo.getJSONObject(key) )
                        for (total in tot.keys())
                            Log.e("total", tot.keys().toString())
                        Log.e("val",
                            (jo.get(key)) as String
                        )
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }

            override fun onFailure(call: Call<JsonObject>, t: Throwable) {}
        })

        return view
    }

    /*override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(StatisticsViewModel::class.java)
        // TODO: Use the ViewModel
    }
*/
}