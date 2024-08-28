package com.droidcourses.composeui.datetime

import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.LocalTime
import kotlinx.datetime.format
import kotlinx.datetime.format.FormatStringsInDatetimeFormats
import kotlinx.datetime.format.MonthNames
import kotlinx.datetime.format.byUnicodePattern
import kotlinx.datetime.format.char
// refernce
//https://alexzh.com/date-and-time-formatting-in-kotlin-with-the-datetime-library/
// default format
fun play1() {
    val currentDateTime = LocalDateTime(2024, 3, 1, 9, 15, 0, 0)
    val currentDate = currentDateTime.date
    val currentTime = currentDateTime.time

    println("❤️$currentDate❤️$currentTime")

    currentDateTime.format(LocalDateTime.Format {  })
    println(currentDateTime)
    currentDate.format(LocalDate.Format {  })
    println(currentDate)
    currentTime.format(LocalTime.Format {  })
    println(currentTime)
}

// default format
@OptIn(FormatStringsInDatetimeFormats::class)
fun play2() {
    val currentDateTime = LocalDateTime(2024, 3, 1, 9, 15, 0, 0)
    val currentDate = currentDateTime.date
    val currentTime = currentDateTime.time

// Mar 01 2024 - 09:15
    val str = currentDateTime.format(
        LocalDateTime.Format {
            date(
                LocalDate.Format {
                    monthName(MonthNames.ENGLISH_ABBREVIATED)
                    char(' ')
                    dayOfMonth()
                    chars(" ")
                    year()
                }
            )
            chars(" - ")
            time(
                LocalTime.Format {
                    hour(); char(':'); minute()
                }
            )
        }
    )

    println("✅$str")
}

fun play3() {
    val formatedDate = "2024/03/01 - 09:15"
    val date = LocalDateTime.parse(
        input = formatedDate,
        format = LocalDateTime.Format { byUnicodePattern("yyyy/MM/dd - HH:mm") }
    )
    println("🎖$date")
}

