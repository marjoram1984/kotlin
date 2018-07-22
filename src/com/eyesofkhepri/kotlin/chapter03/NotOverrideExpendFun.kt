package com.eyesofkhepri.kotlin.chapter03

fun main(args: Array<String>) {
    val v: View = Button()
    v.click()   // 오버라이드 된 Button의 click이 호출된다.
    v.cc()  // 상속과 전혀 상관없이 view의 cc가 호출된다.
}

open class View {
    open fun click() = println("click view")
}

class Button : View() {
    override fun click() = println("click button")
}

fun View.cc() = println("cc view")
fun Button.cc() = println("cc button")

// 확장함수는 정적(static) 함수로 생성이 된다.
// UseJoin.java를 확인해보면 확장함수는 아래와 같이 해당 클래스가 아닌 자동 생성된 클래스의 내부에 static으로 생성이 된다. 그렇기에 오버라이드를 할수 없다.
// NotOverrideExpendFunKt.cc();
// 참고로 확장함수랑 시그니처가 같은 맴버함수가 있을 경우 해당 함수를 실행시 확장함수가 아닌 무조건 맴버 함수를 실행한다.
