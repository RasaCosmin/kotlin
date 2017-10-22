package cosmin.rasa.kotlin.Helpers

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView
import cosmin.rasa.kotlin.Models.ForecastList

/**
 * Created by Rasa Cosmin on 19.10.2017.
 */
class ForecastListAdapter(val weekForecast: ForecastList) : RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {
    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        with(weekForecast.dailyForecast[position]){
            holder?.textView?.text = "$date - $description - $high/$low"
        }
    }

    override fun getItemCount(): Int = weekForecast.dailyForecast.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        return ViewHolder(TextView(parent?.context))
    }

    class ViewHolder (val textView: TextView) : RecyclerView.ViewHolder(textView)
}