package cosmin.rasa.kotlin

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import cosmin.rasa.kotlin.Helpers.ForecastListAdapter
import cosmin.rasa.kotlin.Helpers.ForecastRequest
import cosmin.rasa.kotlin.Helpers.RequestForecastCommand
import cosmin.rasa.kotlin.Models.Forecast
import org.jetbrains.anko.async
import org.jetbrains.anko.find
import org.jetbrains.anko.longToast
import org.jetbrains.anko.uiThread
import java.util.*

class MainActivity : AppCompatActivity() {

    private val items = listOf(
            "Mon 6/23 - Sunny - 31/17",
            "Tue 6/24 - Foggy - 21/8",
            "Wed 6/25 - Cloudy - 22/17",
            "Thurs 6/26 - Rainy - 18/11",
            "Fri 6/27 - Foggy - 21/10",
            "Sat 6/28 - TRAPPED IN WEATHERSTATION - 23/18",
            "Sun 6/29 - Sunny - 20/7"
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val forecastList : RecyclerView = find(R.id.forecast_list)
        forecastList.layoutManager = LinearLayoutManager(this) as RecyclerView.LayoutManager?


       async {
           val result = RequestForecastCommand("94043").execute()
           uiThread {
               forecastList.adapter = ForecastListAdapter(result)
           }
       }
    }

    private fun add(s: Int, y: Int): Int = s + y

    private fun toast(message: String, length: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(this, message, length).show()
    }

    private fun niceToast(message: String,
                          tag: String = MainActivity::class.java.simpleName,
                          length: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(this, "[$tag] $message", length).show()
    }

    fun Context.toast(message: CharSequence, length: Int = Toast.LENGTH_SHORT){
        Toast.makeText(this, message, length).show()
    }
}
