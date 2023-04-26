class Solution {
    fun largestRectangleArea(heights: IntArray): Int {
        var res = 0
        val stack = Stack<Histogram>()

        heights.forEachIndexed { currIndex, currHeight ->
            var shorterHistogramCnt = currIndex
            while (stack.isNotEmpty() && stack.peek().height > currHeight) {
                val histogram = stack.pop()
                res = Math.max(res, histogram.height * (currIndex - histogram.shorterHistogramCnt)) //form area with the taller histograms before the current one
                shorterHistogramCnt = histogram.shorterHistogramCnt
            }
            stack.push(Histogram(shorterHistogramCnt, currHeight))
        }
        stack.forEach { histogram ->
            val histogramCnt = heights.size - histogram.shorterHistogramCnt
            res = Math.max(res, histogram.height * histogramCnt) //form area with taller or same height histograms
        }
        return res
    }
}
class Histogram(val shorterHistogramCnt: Int, val height: Int)