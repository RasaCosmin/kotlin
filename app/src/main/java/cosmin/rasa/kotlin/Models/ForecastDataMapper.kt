package cosmin.rasa.kotlin.Models

import java.text.DateFormat
import java.util.*

/**
 * Created by cosmi on 22-Oct-17.
 */
public class ForecastDataMapper {
    fun convertFromDataModel(forecast: ForecastResult):ForecastList{
        return ForecastList(forecast.city.name, forecast.city.country,
                convertForecastListToDomain(forecast.list))
    }

    fun convertForecastListToDomain(list: List<Forecast>): List<ModelForecast>{
        return list.map { convertForecastItemToDomain(it) }
    }

    private fun convertForecastItemToDomain(it: Forecast): ModelForecast {
        return ModelForecast(convertDate(it.dt), it.weather[0].description,
                it.temp.max.toInt(), it.temp.min.toInt())
    }

    private fun convertDate(dt: Long): String {
        val df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault());
        return df.format(dt * 1000);
    }
}