package com.eyesofkhepri.kotlin.chapter04

fun main(args: Array<String>) {
    var btn = Button()
    btn.showOff()
    btn.setFocus(true)
    btn.click()
}

// 인터페이스 선언
interface Clickable {
    fun click()

    // Default 구현이 있는 메소드 제공
    fun showOff() = println("I'm clickable!")
}

interface Focusable {
    fun setFocus(b: Boolean) = println("I ${if(b) "got" else "lose"} focus.")

    // Clickable 인터페이스 안에 showOff와 시그니처가 같은 메소드 제공
    fun showOff() = println("I'm focusable!")
}


// 간단한 인터페이스 구현
// 만약 구현하려는 인터페이스가 여러개이며 같은 시그니처를 가진 메소드가 있을경우 구현하려는 클래스에서 오버라이드 하지 않으면 컴파일 에러가 발생한다.
class Button : Clickable, Focusable {
    // 이것을 구현했기에 오류 발생안함.
    override fun showOff() {
        // 상위타입을 <>에 넣어서 super를 지정하면 해당 인터페이스의 디폴트 메소드를 실행 할 수 있다.
        super<Clickable>.showOff()
        super<Focusable>.showOff()
        println("I'm Button!")
    }

    override fun click() {
        println("I was Clicked")
    }



}