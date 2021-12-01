package day01

import readInput

fun main() {
    fun part1(input: List<Int>): Int {
        var result = 0
        var index = 0
        while (++index < input.size) {
            if (input[index] > input[index - 1]) result++
        }

        return result
    }

    fun part2(input: List<Int>): Int {
        var result = 0
        var index = 1

        while (++index < input.size - 1) {
            val prev = input[index - 2] + input[index - 1] + input[index]
            val current = input[index - 1] + input[index] + input[index + 1]
            if (current > prev) result++
        }

        return result
    }

    fun convertToNumericList(input: List<String>): List<Int> {
        return input.map { s -> s.toInt() }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = convertToNumericList(readInput("Day01"))
    println(part1(testInput))
    println(part2(testInput))
}