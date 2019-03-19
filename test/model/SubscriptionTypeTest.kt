package com.example.mhz.smartpark.model

import junitparams.JUnitParamsRunner
import junitparams.Parameters
import org.assertj.core.api.Assertions
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(JUnitParamsRunner::class)
class SubscriptionTypeTest {

    fun data() =
            arrayOf(
                    arrayOf("An", SubscriptionType.YEAR),
                    arrayOf("Sem", SubscriptionType.SEMESTER),
                    arrayOf("Trim", SubscriptionType.QUARTER),
                    arrayOf("Mois", SubscriptionType.MONTH))

    @Test
    @Parameters(method = "data")
    fun test(label:String, subscriptionType:SubscriptionType) {
        Assertions.assertThat(SubscriptionType.fromLabel(label)).isEqualTo(subscriptionType)
    }

}