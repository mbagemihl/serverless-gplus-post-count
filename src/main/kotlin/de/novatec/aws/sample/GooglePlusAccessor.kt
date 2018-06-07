package de.novatec.aws.sample

open class GooglePlusAccessor {
    private val key = System.getenv("apiKey")

    internal fun get(): Result {
        val response = khttp.get("https://www.googleapis.com/plus/v1/people/+novatecgmbhdeutschland/activities/public?key=$key&maxResults=100")
        return Mapper().deserialize(response.jsonObject)
    }
}

