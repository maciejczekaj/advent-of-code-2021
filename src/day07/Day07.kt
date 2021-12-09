package day07

import readInputAsListOfInt
import java.util.stream.IntStream.range
import kotlin.math.abs
import kotlin.streams.toList

fun main() {
    fun part1(input: List<Int>): Int {
        val min = input.minOf { x -> x }.toInt()
        val max = input.maxOf { x -> x }.toInt()

        return range(min, max).toList().minOf { x -> input.fold(0) { acc, current -> acc + abs(x - current) } }
    }

    fun part2(input: List<Int>): Int {
        val min = input.minOf { x -> x }.toInt()
        val max = input.maxOf { x -> x }.toInt()

        return range(min, max)
                .toList()
                .minOf { x -> input.fold(0.0) { acc, current -> acc + (abs(x - current).toDouble() * ((abs(x - current).toDouble() / 2 + 0.5))) } }
                .toInt()
    }

    val testInput = readInputAsListOfInt("Day07")
    println(part1(testInput))
    println(part2(testInput))
}