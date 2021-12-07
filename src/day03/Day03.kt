package day03

import readInput

fun main() {
    fun findMostCommonValue(input: List<String>, index: Int): Char {
        return input.map { x -> x[index] }.sortedByDescending { x -> x }.groupingBy { x -> x }.eachCount().maxByOrNull { x -> x.value }!!.key
    }

    fun findLeastCommonValue(input: List<String>, index: Int): Char {
        return input.map { x -> x[index] }.sortedBy { x -> x }.groupingBy { x -> x }.eachCount().minByOrNull { x -> x.value }!!.key
    }

    fun part1(input: List<String>): Int {
        val gammaRate = input[0].indices.fold("") { acc, index -> acc.plus(if (input.count { x -> x[index] == '1' } > (input.count() / 2)) "1" else "0") }
        val epsilonRate = input[0].indices.fold("") { acc, index -> acc.plus(if (input.count { x -> x[index] == '0' } > (input.count() / 2)) "1" else "0") }
        return gammaRate.toInt(2) * epsilonRate.toInt(2)
    }

    fun part2(input: List<String>): Int {
        val oxygenGeneratorRating = input[0].indices.fold(input) { acc, index -> acc.filter { x -> x[index] == findMostCommonValue(acc, index) } }
        val co2ScrubberRating = input[0].indices.fold(input) { acc, index -> acc.filter { x -> x[index] == findLeastCommonValue(acc, index) } }
        return oxygenGeneratorRating.single().toInt(2) * co2ScrubberRating.single().toInt(2)
    }

    val testInput = readInput("Day03")
    println(part1(testInput))
    println(part2(testInput))
}