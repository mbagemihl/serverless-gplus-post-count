package de.novatec.aws.sample

import org.junit.jupiter.api.Test

internal class ApplicationTests {

    @Test fun getGooglePlus() {
        val testee = Application()

        var input = Input()
        input.year = 2017
        input.quarter = 2

        val result = testee.handler(input, null)

        println(result)
    }
}