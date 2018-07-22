package com.eyesofkhepri.kotlin.chapter04

fun main(args: Array<String>) {
    val lc = LengthCounter()
    lc.addWord("With or without you.")
    println(lc.counter)
//    lc.counter = "fdfd" 에러 발생
}

class LengthCounter {
    var counter: Int = 0
    private set // counter는 외부에서 값을 바꿀 수 없다는 의미이다.

    fun addWord(word: String) {
        counter += word.length
    }
}