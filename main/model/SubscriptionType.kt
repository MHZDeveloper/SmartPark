package com.example.mhz.smartpark.model

import java.math.BigDecimal

enum class SubscriptionType(val label: String, val dayNumber: Int) {

    MONTH("Mois", 30) {
        override fun getDiscounts(): List<Discount> {
            return arrayListOf<Discount>(
                    Discount(LongRange(1,50), BigDecimal.ONE),
                    Discount(LongRange(51,100),BigDecimal.valueOf(0.95)),
                    Discount(LongRange(101,150), BigDecimal.valueOf(0.9)),
                    Discount(LongRange(151,200),BigDecimal.valueOf(0.8)),
                    Discount(LongRange(201,10000),BigDecimal.valueOf(0.7)))
        }
    },

    QUARTER("Trim", 90) {
        override fun getDiscounts(): List<Discount> {
            return arrayListOf<Discount>(
                    Discount(LongRange(1,50), BigDecimal.valueOf(0.95)),
                    Discount(LongRange(51,100), BigDecimal.valueOf(0.9)),
                    Discount(LongRange(101,150),BigDecimal.valueOf(0.85)),
                    Discount(LongRange(151,200),BigDecimal.valueOf(0.75)),
                    Discount(LongRange(201,10000),BigDecimal.valueOf(0.65)))

        }
    },

    SEMESTER("Sem", 180) {
        override fun getDiscounts(): List<Discount> {
            return arrayListOf<Discount>(
                    Discount(LongRange(1,50), BigDecimal.valueOf(0.9)),
                    Discount(LongRange(51,100),BigDecimal.valueOf(0.85)),
                    Discount(LongRange(101,150),BigDecimal.valueOf(0.8)),
                    Discount(LongRange(151,200),BigDecimal.valueOf(0.7)),
                    Discount(LongRange(201,10000),BigDecimal.valueOf(0.6)))
        }
    },

    YEAR("An", 365) {
        override fun getDiscounts(): List<Discount> {
            return arrayListOf<Discount>(
                    Discount(LongRange(1,50),BigDecimal.valueOf(0.85)),
                    Discount(LongRange(51,100),BigDecimal.valueOf(0.8)),
                    Discount(LongRange(101,150),BigDecimal.valueOf(0.75)),
                    Discount(LongRange(151,200),BigDecimal.valueOf(0.65)),
                    Discount(LongRange(201,10000),BigDecimal.valueOf(0.55)))
        }
    };

    abstract fun getDiscounts(): List<Discount>

    companion object {
        fun fromLabel(label: String): SubscriptionType {
            return SubscriptionType.values().first { type ->
                type.label.equals(label)
            }
        }
    }

}