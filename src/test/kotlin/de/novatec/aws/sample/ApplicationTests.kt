package de.novatec.aws.sample

import org.junit.jupiter.api.Test

internal class ApplicationTests {

    @Test fun getGooglePlus() {
        val testee = Application()

        val result = testee.handler(2018,1)

        println(result)
    }
}