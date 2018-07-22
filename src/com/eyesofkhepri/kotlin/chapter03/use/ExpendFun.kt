package com.eyesofkhepri.kotlin.chapter03.use

fun main(args: Array<String>) {
    // 새로 만든 확장 함수 lastChar호출
    // 여기선 Kotlin이 수신객체 이며 String이 수신객체타입이다.
    println("Kotlin".lastChar())

    println("Kotlin".lastChar1())
}

// 확장함수를 만들려면 확장하려는 클래스 뒤에 .확장함수를 넣으면 된다.
// Class = String, 확장함수 = lastChar, 클래스 이름은 수신객체타입(receiver type) 확장 함수가 호출되는 대상 this는 수신객체(reciver object)라 불린다.
fun String.lastChar(): Char = this.get(this.length - 1)

// 일반 메소드처럼 본문에서 this를 생략 할 수 있다.
// 확장함수안에서 수신객체의 속성이나 메소드와 수신객체타입의 내부에만 사용할 수 있는 private나 protected 항목을 제외하고는 다 사용할 수 잇다.
fun String.lastChar1(): Char = get(length - 1)


