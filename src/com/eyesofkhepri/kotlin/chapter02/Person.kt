package com.eyesofkhepri.kotlin.chapter02

fun main(args: Array<String>) {
    val person = Person("Bob", true);
    println("이름: ${person.name}, 결혼여부: ${person.isMarried}");
}

// 이러한 형태의 클래스를 VO(value object)라고 한다. VO는 값만 저장하는 클래스를 의미한다.
class Person(
    val name: String,   // val 읽기 전용 속성임, 비공개 필드와 getter를 만든다.
    var isMarried: Boolean  // var 읽고 쓰기 전용 속성임, 비공개 필드와 getter, setter를 만든다.
)