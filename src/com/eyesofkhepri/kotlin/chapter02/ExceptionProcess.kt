package com.eyesofkhepri.kotlin.chapter02

import java.io.BufferedReader
import java.io.StringReader


fun main(args: Array<String>) {
    val reader = BufferedReader(StringReader("239"))
    println(readNumber2(reader))
}

fun readNumber(reader: BufferedReader): Int? { //함수가 던질수 잇는 예외를 명시할 필요가 없다.
    try {
        val line = reader.readLine()
        return Integer.parseInt(line)
    } catch(e: NumberFormatException) {
        return null;
    } finally {
        reader.close()
    }

}

fun readNumber2(reader: BufferedReader) {
    // try를 식으로써 사용을 할 수 있다.
    var number = try {
        Integer.parseInt(reader.readLine())
    } catch(e: NumberFormatException) {
        return
    }
}