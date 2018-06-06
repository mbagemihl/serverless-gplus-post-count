package de.novatec.aws.sample

import org.assertj.core.api.Assertions.assertThat
import org.json.JSONObject
import org.junit.jupiter.api.Test


internal class MapperTests {

    val testee = Mapper()

    @Test fun `deserializes valid JSON object`() {
        val testData = this.javaClass.getResource("/testData.json").readText()
        val testJson = JSONObject(testData)

        val actual = testee.deserialize(testJson)

        assertThat(actual.items.first().id).isEqualTo("z123up4wcpizvtzxe04cg50r0srkgruzemg0k")
        assertThat(actual.items.first().published).isEqualTo("2018-05-17T12:16:43.774")
    }
}