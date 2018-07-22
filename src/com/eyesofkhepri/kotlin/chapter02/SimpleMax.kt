package com.eyesofkhepri.kotlin.chapter02


fun main(args: Array<String>) {
    println(simpleMax1(1,2))
    println(simpleMax2(1,2))
}

// 식을 본문으로 사용할 수 있다.
fun simpleMax1(a: Int, b: Int): Int = if(a > b) a else b

// 타입추론을 하기 때문에 반환타입을 쓰지 않고 더 간결히 사용할 수 있다. 식이 본문인 경우만 가능하다.
fun simpleMax2(a: Int, b: Int) = if(a > b) a else b
