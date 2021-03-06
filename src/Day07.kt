import kotlin.math.abs

fun main() {
    fun part1(input: List<String>): Int {
        val crabPositions = input.first().split(",")
            .map { it.toInt() }
        var currentFuel = Integer.MAX_VALUE

        for (i in 1..crabPositions.size) {
            var sum = 0
            for (j in 1..crabPositions.size) {
                sum += abs(crabPositions[j - 1] - i)
            }

            if (sum < currentFuel) {
                currentFuel = sum
            }
        }
        return currentFuel
    }

    fun part2(input: List<String>): Int {
        val crabPositions = input.first().split(",")
            .map { it.toInt() }
        var currentFuel = Integer.MAX_VALUE

        for (i in 1..crabPositions.size) {
            var sum = 0
            for (j in 1..crabPositions.size) {
                val horizontalMovement = abs(crabPositions[j - 1] - i)
                sum += (1..horizontalMovement).sum()
            }

            if (sum < currentFuel) {
                currentFuel = sum
            }
        }
        return currentFuel
    }

    val input = readInput("Day07")
    val sample = readInput("Day07_test")

    check(part1(sample) == 37)
    check(part2(sample) == 168)
    check(part1(input) == 355592)
    check(part2(input) == 101618069)
}
