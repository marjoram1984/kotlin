package com.eyesofkhepri.kotlin.chapter03

fun main(args: Array<String>) {
//    "test".lastChar = "1"
    println("test".lastChar)
}

// 기본적으로 확장프로퍼티는 backing field가 존재하지 않는다. 즉 저장할 공간이 없다는 의미이기 때문에 필수로 사용시 어떤 값을 넘길지 getter을 선언할 필요가 있다.
val String.lastChar: Char
    get() = get(this.length - 1)

// setter도 선언할 수 잇다 하지만 backing field가 존재하지 않으므로 해당 확장프로퍼티에 값을 저장할 수 없으며 수신객체 타입의 멤버 함수나 수신객체를 수정하는 수준정도 박에 사용할 수 없다.
var StringBuilder.lastChar1: Char
    get() = get(this.length - 1)
    set(v: Char) {
        this.setCharAt(length -1, v)
    }

