package cosmin.rasa.kotlin.Helpers

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import cosmin.rasa.kotlin.Extensions.ctx
import cosmin.rasa.kotlin.Models.Forecast
import cosmin.rasa.kotlin.Models.ForecastList
import cosmin.rasa.kotlin.Models.ModelForecast
import cosmin.rasa.kotlin.R
import kotlinx.android.synthetic.main.item_forecast.view.*
import org.jetbrains.anko.find

/**
 * Created by Rasa Cosmin on 19.10.2017.
 */
class ForecastListAdapter(val weekForecast: ForecastList, val itemClick: (ModelForecast) -> Unit) : RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {
    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.bindForecast(weekForecast[position])
    }

    override fun getItemCount(): Int = weekForecast.size()

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent?.ctx).inflate(R.layout.item_forecast, parent, false)
        return ViewHolder(view, itemClick)
    }

    class ViewHolder(view: View, val itemClick: (ModelForecast) -> Unit) : RecyclerView.ViewHolder(view) {
               fun bindForecast(forecast: ModelForecast) {
            with(forecast) {
                Picasso.with(itemView.ctx).load(iconUrl).into(itemView.icon)
                itemView.date.text = date
                itemView.description.text = description
                itemView.maxTemp.text = high.toString()
                itemView.minTemp.text = low.toString()
                itemView.setOnClickListener { itemClick(this) }
            }
        }
    }
}