// Given 2 clocks, the second clock has 0~4 digits masked, return the closest clock to the first one
// 13:37, 1#:#7 => 13:37
// 13:37, ##:## => 13:37
// 23:57, 1#:#7 => 19:57
// 23:58, #4:5# => 04:50
fun closestClock(time: String, maskedTime: String): String {
    val timeSub = time.split(":")
    val hour = timeSub[0].toInt()
    val min = timeSub[1].toInt()
    val h1 =
}