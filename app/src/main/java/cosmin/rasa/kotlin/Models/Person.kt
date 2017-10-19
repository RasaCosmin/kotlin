package cosmin.rasa.kotlin.Models

/**
 * Created by Rasa Cosmin on 19.10.2017.
 */
class Person(name: String, surname: String) {
    var age: Int = 0
    get() = field + 1
    set(value) {
        field = value
    }
}