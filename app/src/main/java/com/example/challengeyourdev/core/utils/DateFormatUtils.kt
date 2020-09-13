package com.example.challengeyourdev.core.utils

import java.text.SimpleDateFormat
import java.util.*


//criado por arthur rodrigues

class DateFormatUtils {

    operator fun invoke(dateString : String): String {
        val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.US)
        val sdf2 = SimpleDateFormat("MM/dd/yyyy", Locale.US)
        val date = sdf.parse(dateString)
        return sdf2.format(date)
    }
}