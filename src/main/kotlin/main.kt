const val secondsInMinute = 60
const val minutesInHour = 60
const val hoursInDay = 24

const val minute = secondsInMinute
const val hour = minute * minutesInHour
const val day = hour * hoursInDay

fun main() {
    val timeSec = 35

    println(agoToText(timeSec))

    testJustNow()
}

fun agoToText(timeSec: Int): String {
    return "был(а)" + when (timeSec) {
        in 0 until minute -> "только что"
        in minute until hour -> minutesToText(timeSec / minute) + " назад"
        in hour until day -> hoursToText(timeSec / hour) + " назад"
        in day until 2 * day -> " сегодня"
        in 2 * day until 3 * day -> " вчера"
        else -> " давно"
    }
}

fun minutesToText(timeMin: Int): String {
    return " $timeMin " + when {
        timeMin % 100 in 11..19 -> "минут"
        timeMin % 10 == 1 -> "минуту"
        timeMin % 10 in 2..4 -> "минуты"
        else -> "минут"
    }
}

fun hoursToText(timeHours: Int): String {
    return " $timeHours " + when {
        timeHours % 100 in 11..19 -> "часов"
        timeHours % 10 == 1 -> "час"
        timeHours % 10 in 2..4 -> "часа"
        else -> "часов"
    }
}

fun testJustNow() {
    val testList = listOf(
        1 * minute,
        2 * minute + 7,
        4 * minute,
        5 * minute,
        10 * minute,
        11 * minute,
        13 * minute,
        21 * minute,
        53 * minute,
        1 * hour,
        3 * hour,
        5 * hour,
        12 * hour,
        21 * hour,
        24 * hour,
        2 * day + 5 * hour,
        3 * day,
        10 * day,
    )
    testList.forEach { println(agoToText(it)) }
}