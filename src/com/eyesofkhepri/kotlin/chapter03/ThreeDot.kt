// 패키지 선언
package com.eyesofkhepri.kotlin.chapter03



fun main(args: Array<String>) {
    val v1 = "test"

    // 3중 따옴표를 사용해서 아래와 같이 원하는 문장을 만들어 낼 수 있다.
    val x = """
        1
        2
        3
        4
        5
        6
        7
        8
        9
        $v1
        """.trimIndent()

    println(x)
}