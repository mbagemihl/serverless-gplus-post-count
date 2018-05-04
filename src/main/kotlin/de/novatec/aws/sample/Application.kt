package de.novatec.aws.sample

import com.google.gson.Gson
import khttp.get
import java.text.SimpleDateFormat
import java.util.*

class Application {
    fun handler() = getGooglePlus()

    val formatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault())
    fun getGooglePlus():String {
        val asd = get("https://www.googleapis.com/plus/v1/people/+novatecgmbhdeutschland/activities/public?key=")
        val result:Result = Gson().fromJson(asd.text,Result::class.java)
        return result.items.filter { item -> formatter.parse(item.published).after(Date(2018,1,1))}.size.toString()
    }
}

data class Action (
    val id: String,
    val verb: String,
    val published: String
)

data class Result (
        val items: List<Action>
) {
    constructor(items: Array<Action>) : this(items.toList())
}
