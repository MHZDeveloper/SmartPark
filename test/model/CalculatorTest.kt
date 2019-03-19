package com.example.mhz.smartpark.model

import junit.framework.Assert
import org.junit.Test

//@RunWith(JUnitParamsRunner::class)
class CalculatorTest {

    val calculator = Calculator()

    @Test
    fun calculateTest_normal_Month(){

        //when
        val amount = calculator.calculateAmount(SubscriptionType.fromLabel("Mois"),1000,50)
        //then
        Assert.assertNotNull(amount)
        Assert.assertEquals(1500000,amount)
    }

    @Test
    fun calculateTest_when_carNumber_is_on_the_third_range_Month(){

        //when
        val amount = calculator.calculateAmount(SubscriptionType.fromLabel("Mois"), 1000, 120)
        //then
        Assert.assertNotNull(amount)
        Assert.assertEquals(3465000,amount)
    }

    @Test
    fun calculateTest_when_carNumber_is_on_the_last_range_Month(){

        //when
        val amount = calculator.calculateAmount(SubscriptionType.fromLabel("Mois"), 1000, 210)
        //then
        Assert.assertNotNull(amount)
        Assert.assertEquals(5685000,amount)
    }

    @Test
    fun calculateTest_normal_Trim(){

        //when
        val amount = calculator.calculateAmount(SubscriptionType.fromLabel("Trim"), 1000, 50)
        //then
        Assert.assertNotNull(amount)
        Assert.assertEquals(4275000,amount)
    }

}