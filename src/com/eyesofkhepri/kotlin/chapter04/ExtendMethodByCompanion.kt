package com.eyesofkhepri.kotlin.chapter04

fun main(args: Array<String>) {
    Computer.fromJSON("json")
}

class Computer(val name: String) {
    companion object {

    }
}
// companion object에 확장함수를 만들어서 사용할 수 있다.
fun Computer.Companion.fromJSON(json: String) {
    println("json");
}