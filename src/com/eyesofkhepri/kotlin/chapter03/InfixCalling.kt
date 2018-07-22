package com.eyesofkhepri.kotlin.chapter03


fun main(args: Array<String>) {
    // 이것은 맵을 만들어 주는 로직이다. 여기서 1 to "one" 같은 형태를 코틀린에선 중위 호출이라고 부른다.
    val map = mapOf(1 to "one", 2 to "second");

    // 중위 호출이란 인자가 하나뿐인 일반메소드나 확장 메소드에서 사용할 수 있는 것인데 위에선 to가 그런 메소드에 속한다.
    // 중위 호출을 사용하기 위해선 함수 앞에 infix라는 변경자를 선언 해야한다.
    // public infix fun <A, B> A.to(that: B): Pair<A, B> = Pair(this, that)

    // to가 하는 역할은 1 to "one"을 예로 들면 1과 "one"을 pair라는  집합으로 만들어 반환하는 역할을 한다. 일반적인 함수와 중위 호출 방식을 비교해보면
    1.to("one") // 일반적인 방식
    1 to "one" // 중위 표현 방식

    "some" sumbody "body"   // some : body

    "zzzz" goto "xxxx"  // zzzz goto xxxx

    // to는 pair라는 집합을 반환해주는 것이라고 했엇다. 그런데 아래와 같은 코드를 보면 x, y 변수를 즉시 초기화 할 수 있다. 이런 기능을 구조분해선언(destructuring declaration)이라고 한다.
    // 예전에 보앗떤 for((index, elem) in col.withIndex()) 형태의 index를 가져오는 구문도 구조분해선언이다.
    // 구조분해선언은 해당 데이터를 나눠서 저장해야 할 경우 유용하게 쓰인다.
    val (x, y) = 100 to 200
    println("x = $x")
    println("y = $y")


}

infix fun <A, B> A.sumbody(body: B) {
    println("$this : $body")
}

// 확장 함수도 중위표현식을 쓸수 있다.
infix fun String.goto(t : String) {
    println("$this goto $t")
}
// 즉 중위 표현식은 편하게 좀더 짧게 쓰고자 만들어진 것이다.
