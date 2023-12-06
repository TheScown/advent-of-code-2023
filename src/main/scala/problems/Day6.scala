package space.scown.advent2023
package problems

import lib.{Files, Problem}

case class Day6(lines: Vector[String]) extends Problem {
  override def solve1(): Unit = {
    val races = parse1(lines)

    val result = races.map { race => race.waysToWin }.product

    println(s"Result 1: $result")
  }

  override def solve2(): Unit = {
    val race = parse2(lines)

    val result = race.waysToWin

    println(s"Result 2: $result")
  }

  private def parse1(lines: Vector[String]) = {
    val partLines = lines.map(line => line.split("\\s+"))

    val transpose = partLines(0).zip(partLines(1))

    transpose.tail.map({
      case (length, distance) => Race(length.toLong, distance.toLong)
    })
  }

  private def parse2(lines: Vector[String]) = {
    val parts = lines.map(line => line.split("\\s+").tail.reduce(_+_).toLong)

    Race(parts(0), parts(1))
  }

}

case class Race(time: Long, distance: Long) {

  lazy val waysToWin: Long = Math.floor(Math.sqrt(time * time - 4 * distance)).toLong

}

object Day6 {
  def main(args: Array[String]): Unit = {
    val value = Files.lines("day6.txt")
    Day6(value).solve1()
    Day6(value).solve2()
  }

}
