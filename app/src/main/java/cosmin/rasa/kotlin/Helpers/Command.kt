package cosmin.rasa.kotlin.Helpers

/**
 * Created by cosmi on 22-Oct-17.
 */
public interface Command<T>{
    fun execute(): T
}