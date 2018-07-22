package com.eyesofkhepri.kotlin.chapter02

import java.util.*


fun main(args: Array<String>) {
    println(isLetter('q'))
    println(isNotDigit('X'))
    println(recognize('5'))
}

// in은 값의 범위가 속하는지 알수 있고
// c in 'a'..'z'는 실제 'a' <= c && c <= 'z' 로 변환이 된다.
fun isLetter(c: Char) = c in 'a'..'z' || c in 'A'..'Z'

// !in은 값의 범위에 속하지 않는지 알수 있다.
fun isNotDigit(c: Char) = c !in '0'..'9'

// in은 when의 비교절로도 사용할 수 있다.
fun recognize(c: Char) = when(c) {
    in '0'..'9' -> "It's a digit"
    in 'a'..'z', in 'A'..'Z' -> "It's a letter"
    else -> "I don't know"
}