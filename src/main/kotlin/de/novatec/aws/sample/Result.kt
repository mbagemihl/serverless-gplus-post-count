package de.novatec.aws.sample

data class Result(
        val nextPageToken: String,
        val items: List<Action>
)
