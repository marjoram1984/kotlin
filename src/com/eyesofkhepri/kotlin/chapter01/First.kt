package com.eyesofkhepri.kotlin.chapter01

// age는 따로 인자 안받을 경우 디폴트 값으로 null이다.
// ?는 인자가 필수가 아니라는 의미이다.
data class Person(val name: String, val age: Int? = null)

fun main(args: Array<String>) {
    val persons = listOf(Person("영희"), Person("철수", age=29))

    // 엘비스식 ?:는 it.age가 null일 경우 0반환 아닐경우 it.age를 반환한다.
    // it라는 이름을 사용하면 람다식의 유일한 인자를 쓸 수 있다.
    val oldest = persons.maxBy { it.age ?: 0 }
    println("나이가 가장 많은 사람: $oldest")
}