 class Solution {
    fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, color: Int): Array<IntArray> {
        return fill(image, sr, sc, color)
    }

    fun fill(image: Array<IntArray>, sr: Int, sc: Int, color: Int): Array<IntArray> {
        val orig = image[sr][sc]
        image[sr][sc] = color
        if (orig != color) { //check if the color attempted to fill is not the same
            if (sr-1 >= 0 && image[sr-1][sc] == orig) fill(image, sr-1, sc, color)
            if (sc-1 >= 0 && image[sr][sc-1] == orig) fill(image, sr, sc-1, color)
            if (sr+1 < image.size && image[sr+1][sc] == orig) fill(image, sr+1, sc, color)
            if (sc+1 < image[0].size && image[sr][sc+1] == orig) fill(image, sr, sc+1, color)
			//then fill 4 directions if they have the same color as the current one was, until bounds are reached
        }
        return image
    }
}
