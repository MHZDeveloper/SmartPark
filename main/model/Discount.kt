package com.example.mhz.smartpark.model

import java.math.BigDecimal

class Discount(var range: LongRange,
               var percent: BigDecimal) {

}

fun LongRange.stepHeight(): Long {
    return last - first + 1
}