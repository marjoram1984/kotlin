package com.eyesofkhepri.kotlin.chapter02


fun main(args: Array<String>) {
    println(max(1,2))
}

// 함수이름 : max
// 인자목록 : (a: Int, b: Int)
// 반환타입 : Int
// 함수본문 : return if(a > b) a else b
fun max(a: Int, b: Int): Int {
    // 코틀린의 if는 문(statement)이 아니라 식(expressions)이다.
    // if는 식이기 때문에 값을 반환 할 수 있다. 참고로 문은 값을 반환 할 수 없다.
    // 코틀린은 loop를 제외한 모든 제어문이 식으로 변경 되었다.
    // 대입문은 자바에선 식이지만 코틀린에선 문으로 변경 되었다.
    return if(a > b) a else b
}


