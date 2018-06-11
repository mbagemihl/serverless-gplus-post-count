package de.novatec.aws.sample

open class GooglePlusAccessor {
    private val key = System.getenv("apiKey")

    internal fun get(nextPageToken: String?): Result {
        val nextPageStr: String = if (nextPageToken != "") {
            "&pageToken=$nextPageToken"
        } else {
            ""
        }
        val response = khttp.get("https://www.googleapis.com/plus/v1/people/+novatecgmbhdeutschland/activities/public?key=$key&maxResults=100$nextPageStr")
        return Mapper().deserialize(response.jsonObject)
    }
}

