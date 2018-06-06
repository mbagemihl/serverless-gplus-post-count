package de.novatec.aws.sample

import com.google.gson.*
import org.json.JSONObject
import java.time.LocalDateTime
import java.time.ZonedDateTime


class Mapper {
    fun deserialize(json: JSONObject): Result {
        val gson = GsonBuilder().registerTypeAdapter(
                LocalDateTime::class.java, JsonDeserializer<LocalDateTime> { json, _, _ ->
                    ZonedDateTime.parse(json.asJsonPrimitive.asString).toLocalDateTime()
                }
        ).create()
        return gson.fromJson(json.toString(), Result::class.java)
    }

}