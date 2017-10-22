package cosmin.rasa.kotlin.Helpers

import cosmin.rasa.kotlin.Models.ForecastDataMapper
import cosmin.rasa.kotlin.Models.ForecastList

/**
 * Created by cosmi on 22-Oct-17.
 */
class RequestForecastCommand(val zipCode: String) : Command<ForecastList> {
    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipCode);
        return ForecastDataMapper().convertFromDataModel(forecastRequest.execute())
    }
}