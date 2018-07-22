package com.eyesofkhepri.kotlin.chapter04

fun main(args: Array<String>) {

}

// Animated 클래스는 추상 클래스이다.
abstract class Animated {
    // animate 메소드는 추상 함수며 구현이 엇다. 하위 클래스는 반드시 구현해야 한다.
    abstract fun animate()

    // 추상 클래스 내부에 속해 잇더라도 open을 통해서 override를 허용 할 수 있다.
    open fun stopAnimating() {

    }

    // 기본적으로 final을 가진다
    fun animateTwice() {

    }
}