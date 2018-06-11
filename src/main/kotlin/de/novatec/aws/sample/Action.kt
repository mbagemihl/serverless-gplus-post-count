package de.novatec.aws.sample

import java.time.LocalDateTime

data class Action(
        val id: String,
        val verb: String,
        val published: LocalDateTime
)