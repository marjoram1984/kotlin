package com.eyesofkhepri.kotlin.chapter02

fun main(args: Array<String>) {
    var question = "오늘 저녁 집에서 뭘먹을까?"
    // 타입을 선언 안해도 되고
    var answer = 42
    // 타입을 선언 해도 된다
    var hungry: Int = 100
    // 초기화 하지 않고 쓸 경우는 반드시 타입을 선언해야 한다.
    var coffeeName: String
    coffeeName = "Maxim"

    // immutable 참조를 갖는 변수
    val myname = "Cho Ho Young"
    // myname = "Cho Ho Young 1" 에러

    // mutable 참조를 갖는 변수
    var myage = 35
    myage = 36

    // val이 immutable이 가르키는 참조 값은 불변이지만 참조가 가르키는 객체 값은 변경이 가능하다.
    val languages = arrayListOf("Java") // Immutable 한 변수 languages
    languages.add("Kotlin") // languages 내부 객체의 값은 수정이 가능하다.
    println(languages)

    // 초기화 된 타입안에 다른 타입을 넣을 수 없다. 넣고 싶다면 값을 해당 타입으로 바꾸던가 강제 형변환 해야 한다.
    var jobName = "Developer"
    // jobName = 11 // 에러 발생
}