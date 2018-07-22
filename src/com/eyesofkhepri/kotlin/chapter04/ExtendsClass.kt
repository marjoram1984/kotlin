package com.eyesofkhepri.kotlin.chapter04

fun main(args: Array<String>) {

}

// 상속받을 클래스를 만들려면 open 변경자를 써야한다.
// 왜냐하면 상속을 위한 설계나 문서가 없을 경우 오버라이드 대상이 되는 클래스와 메소드가 아니라면 무조건 final로 만드는 철학을 따르기 위해서 기본적으로 kotlin은 클래스 선언시 클래스 및 메소드들이 final로 잡혀있다.
open class RichButton : Clickable {
    // 만약 하위 클래스에서 Override를 하면 안되는 Override된 메소드는 fianl을 통해서 선언해야한다
    // final override fun click() {}
    override fun click() {  // Clickable에서 override했다. 기본적으로 override한 메소드는 Open이다.

    }


    // disable 함수는 기본적으로 final이다. 하위 클래스에서 Override할수 없다
    fun disable() {

    }

    // 이 함수는 Open이다. 하위 클래스에서 Override할 수 있다.
    open fun animate() {
    }


}