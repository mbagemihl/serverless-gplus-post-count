package de.novatec.aws.sample

import com.amazonaws.Request
import com.amazonaws.Response
import com.amazonaws.services.lambda.runtime.Context

import com.amazonaws.services.lambda.runtime.RequestHandler
import khttp.get
import java.lang.Exception
import java.time.LocalDateTime
import java.time.Month
import java.time.Year

class Application : RequestHandler<Input, List<Action>> {
    override fun handleRequest(input: Input?, context: Context?): List<Action> {
        return handler(input,context)
    }

    fun handler(input:Input?, context:Context?): List<Action> {
        if (input === null)
            throw RuntimeException("no Parameter")
        val key: String = System.getenv("apiKey")
        val response = get("https://www.googleapis.com/plus/v1/people/+novatecgmbhdeutschland/activities/public?key=$key&maxResults=100")
        val result: Result = Mapper().deserialize(response.jsonObject)

        var startDate: LocalDateTime //= LocalDateTime.of(input.year,1,1,0,0,0)
        var endDate: LocalDateTime //= LocalDateTime.of(year.toInt(),3,31,0,0,0)
        when (input.quarter) {
            1 -> {
                startDate = LocalDateTime.of(input.year,1,1,0,0,0)
                endDate = LocalDateTime.of(input.year,4,1,0,0,0).minusDays(1)
            }
            2 -> {
                startDate = LocalDateTime.of(input.year,4,1,0,0,0)
                endDate = LocalDateTime.of(input.year,7,1,0,0,0).minusDays(1)
            }
            3 -> {
                startDate = LocalDateTime.of(input.year,7,1,0,0,0)
                endDate = LocalDateTime.of(input.year,10,1,0,0,0).minusDays(1)
            }
            4 -> {
                startDate = LocalDateTime.of(input.year,10,1,0,0,0)
                endDate = LocalDateTime.of(input.year+1,1,1,0,0,0).minusDays(1)
            }
            else -> {
                throw IndexOutOfBoundsException("Quarter must be between 1 and 4!")
            }
        }
        return result.items.filter {
            it.published.isAfter(startDate) && it.published.isBefore(endDate)
        }
    }
}

data class Action(
        val id: String,
        val verb: String,
        val published: LocalDateTime
)

data class Result(
        val items: List<Action>
)

data class Input(
        val year: Int = LocalDateTime.now().year,
        val quarter: Int = LocalDateTime.now().monthValue / 4
)