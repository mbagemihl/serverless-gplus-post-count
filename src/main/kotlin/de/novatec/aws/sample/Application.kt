package de.novatec.aws.sample

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import java.io.InputStream
import java.io.OutputStream


data class HandlerInput(val who: String)
data class HandlerOutput(val message: String)

class Application {
    val mapper = jacksonObjectMapper()

    fun handler(input: InputStream, output: OutputStream): Unit {
        val inputObj = mapper.readValue<HandlerInput>(input)
        mapper.writeValue(output, HandlerOutput("Hello ${inputObj.who}"))
    }
}
