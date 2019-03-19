package com.example.mhz.smartpark.model

import java.math.BigDecimal

class Calculator {

    fun calculateAmount(subscriptionType: SubscriptionType, price: Long, carNumber: Long): Int {
        val amount: BigDecimal

        amount = subscriptionType.getDiscounts()
                .map { discount -> this.placesPerPercentDiscounts(discount, carNumber) }
                .map { pair -> this.totalPrice(pair, price) }
                .reduce(BigDecimal::add)
                .multiply(BigDecimal.valueOf(subscriptionType.dayNumber.toLong()))

        return amount.toInt()
    }

    private fun totalPrice(pair: Pair<Long, BigDecimal>, price: Long) =
            pair.second.multiply(BigDecimal.valueOf(price * pair.first))

    private fun placesPerPercentDiscounts(discount: Discount, carNumber: Long): Pair<Long, BigDecimal> {
        return when {
            carNumber >= discount.range.last -> Pair(discount.range.stepHeight(), discount.percent)
            carNumber >= discount.range.first -> Pair(carNumber - discount.range.first + 1, discount.percent)
            else -> Pair(0L, discount.percent)
        }
    }

}