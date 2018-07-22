// 패키지 선언
package com.eyesofkhepri.kotlin.chapter02

// import를 통해 표준 자바 라이브러리를 사용한다.
import java.util.*

fun main(args: Array<String>) {
    val random = Random();
    println("random = ${random.nextInt()}")
}