package de.novatec.aws.sample

import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.given
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.willReturn
import org.junit.jupiter.api.Test

internal class ApplicationTests {

    private val mockHttpClient = mock<GooglePlusAccessor>()

    private val testee = Application()

    @Test fun getGooglePlus() {
        given(mockHttpClient.get(any())).willReturn { Result(null, emptyList()) }

        val result = testee.handler(Input(year = 2018, quarter = 1))

        println(result)
    }


//    @Test fun runThisLocally() {
//        val input = Input(2017, 4)
//        val result = testee.handler(input)
//
//        println(result)
//    }
}
