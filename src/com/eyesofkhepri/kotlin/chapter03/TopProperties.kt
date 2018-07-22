package com.eyesofkhepri.kotlin.chapter03

fun main(args: Array<String>) {
    counterOp()
    outputCounter()
}

// 최상위 프로퍼티 선언
// 이런 코드는 Java에선 get,set이 생성이 된다. UseJoin에서 확인
var counter = 0;

// 만약 val로 선언하면 어떻게 될까? set은 없지만 get은 있다. java의 final static... 같은 것을 만들고 싶으면 const를 사용한다.
const val UNIX_LINE_SEPARATOR = "\n"

// 최상위 속성 증가
fun counterOp() {
    counter++;
}

// 카운터 값 출력
fun outputCounter() {
    println("현재 카운터 값 $counter")
}