package com.eyesofkhepri.kotlin.chapter05

fun main(args: Array<String>) {

    // ::를 사용하는 식을 맴버참조(Member Reference)라고 한다.
    val getAge = {x: MoonLight -> x.age}
    // 위 문장을 아래와 같이 축소 시킬수 있다.
    val getAge1 = MoonLight::age

    println(getAge(MoonLight("1",1)))
    println(getAge1(MoonLight("2",2)))

    // '::값'은 최상위에 존재하는 함수나 프로퍼티를 사용할 수 잇따.
    run (::getMoon)

    val moon1 = MoonLight("earth", 1000)
    // 1.1부터 바운드 맴버 참조라고 클래스 인스턴스에 대한 맴버 값을 사용 할 수 있게 해주는 기능이 추가되었다.
    println(run(moon1::name))
}

data class MoonLight(val name: String, val age: Int)

fun getMoon() = println("Moon")



