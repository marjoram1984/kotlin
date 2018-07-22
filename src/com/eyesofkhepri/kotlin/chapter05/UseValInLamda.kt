package com.eyesofkhepri.kotlin.chapter05

import kotlin.math.abs

fun main(args: Array<String>) {
    val stringList = listOf<String>("one", "two", "three")
    printMsgWithPrefix(stringList, "World")
}

// 하지만 비동기적 사용에서는 함수 호출이 끝난 이후에 변수가 변경될수 있으니 상황에 따라서 잘 써야 한다.
fun printMsgWithPrefix(msg: Collection<String>, prefix: String) {
    var x: Int = 0

    // forEach는 인자로 '(T) -> Unit' 형태의 람다식을 받는다.
    msg.forEach{
        // 람다식 안에서 파라메터 prefix를 가져와서 사용하고 있다.
        // java와 다르게 final변수가 아닌데 외부 변수들을 사용 할 수 있다. 또한 외부 변수의 값을 변경도 해도 된다.
        x++ // 외부 값을 변경을 하고 있다.
        println("$prefix $it")
    }

    println("x = $x")
}
