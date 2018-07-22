package com.eyesofkhepri.kotlin.chapter04

fun main(args: Array<String>) {
    var test = 0

    // object : XX 형태로 익명 객체로 간단하게 사용 할수 잇다 차후 이것은 람다식으로 변형이 되서 사용할 수 잇다.
    Mouse.mouseListner(object: MouseAdapter {
        override fun mouseClicked(e: String) {
            test++; // java와 다르게 익명클래스 내부에서 상위 변수를 final이 아님에 불구하고 사용이 가능하다.
            println(e);
        }
    })

    println(test)
}

interface MouseAdapter {
    fun mouseClicked(e: String)
}

class Mouse {
    companion object {
        fun mouseListner(m: MouseAdapter) {
            m.mouseClicked("test");
        }
    }
}

