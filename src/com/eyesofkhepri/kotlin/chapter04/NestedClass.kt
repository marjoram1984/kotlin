package com.eyesofkhepri.kotlin.chapter04

import java.io.Serializable

fun main(args: Array<String>) {

}

interface State: Serializable {
    
}

interface View {
    fun getCurrentState(): State
    fun restoreState(state: State)
}

class ViewButton : View {
    // 인터페이스 메소드 구현, 반환 값은 내부 클래스 ButtonState
    override fun getCurrentState(): State = ButtonState()
    override fun restoreState(state: State) {

    }

    // java에서 InnerClass는 직렬화 할수 없는데, InnerClass안에서 컴파일러가 synthetic field를 생성해 사용하는데 이필드는 외각 클래스 즉 ViewButton에 대한 참조값과 지역변수들의 값을 저장하고 있다.
    // 그래서 java에선 이 ButtonState를 static 맴버 클래스로 만들어야 한다.
    // 하지만 코틀린에서 InnerClass는 기본으로 static이다. 그러므로 별도 작없할 필요없이 동작하게 된다.
    class ButtonState : State {
    }
}

// 만약 바깥쪽 클래스의 인스턴스의 참조값을 얻고 싶으면 내부 클래스에 inner를 붙이고 this@Outer를 사용해야 한다.
class Outer {
    inner class Inner {
        fun getOuterReference(): Outer = this@Outer
    }
}
