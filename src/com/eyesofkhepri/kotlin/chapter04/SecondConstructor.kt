package com.eyesofkhepri.kotlin.chapter04

fun main(args: Array<String>) {
    val c = ChildView("test")
}

// 주 생성자가 없다. ParentView()처럼 괄호가 없다.
// 부 생성자는 constructor를 사용해서 선언한다.
open class ParentView {
    // 부생성자
    constructor(name: String) {
        println("Parent View $name")
    }

    // 부생성자
    constructor(name: String, attr: String) {
        println("Parent View $name , $attr")
    }
}

class ChildView : ParentView {
    // 상위 클래스 생성자 호출
    /*constructor(name: String) : super(name) {
        println("Child View $name")
    }*/

    // this를 사용해서 ChildView의 2번째 부생성자를 호출했다.
    constructor(name: String) : this(name, "callThis") {
        println("Child View 1 $name")
    }

    // 상위 클래스 생성자 호출
    constructor(name: String, attr: String) : super(name, attr) {
        println("Child View 2 $name , $attr")
    }
}