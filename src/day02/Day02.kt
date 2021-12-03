package day02

import readInput

fun main() {
    data class Command(val direction: String, val value: Int)

    fun String.toCommand(): Command {
        return Command(this.split(" ")[0], this.split(" ")[1].toInt())
    }

    fun part1(input: List<String>): Int {
        val commands = input.map { x -> x.toCommand() }

        val horizontalPosition = commands.filter { x -> x.direction == "forward" }.sumOf { x -> x.value }
        val depth = commands.filter { x -> x.direction == "down" }.sumOf { x -> x.value } - commands.filter { x -> x.direction == "up" }.sumOf { x -> x.value }

        return horizontalPosition * depth
    }

    fun part2(input: List<String>): Int {
        val commands = input.map { x -> x.toCommand() }
        var aim = 0
        var depth = 0
        var horizonalPosition = 0

        for (command in commands) {
            when (command.direction) {
                "forward" -> {
                    horizonalPosition += command.value
                    depth += command.value * aim
                }
                "down" -> {
                    aim += command.value
                }
                "up" -> {
                    aim -= command.value
                }
            }
        }

        return depth * horizonalPosition
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02")
    println(part1(testInput))
    println(part2(testInput))
}