// 패키지 선언
package com.eyesofkhepri.kotlin.chapter03



fun main(args: Array<String>) {
    // 숫자로 이루어진 집합 생성
    val set = hashSetOf<Int>(1, 7, 53)
    // 숫자로 이루어진 리스트 생성
    val list = arrayListOf(1, 7, 53)
    // 맵 생성
    val map = hashMapOf(1 to "one", 7 to "seven", 53 to "fifty-three")

    // javaClass는 자바의 getClass()에 해당하는 코틀린 코드다
    println(set.javaClass)  // java.util.HashSet
    println(list.javaClass) // java.util.ArrayList
    println(map.javaClass)  // java.util.HashMap

    // 위를 보면 코틀린이 자신만의 컬랙션 기능을 제공하지 않고 기존 자바 컬렉션을 사용하는 것을 알 수 있다.
    // 코틀린 만의 컬렉션이 없는 이유는 Java와 호환을 위해서 이다. 각각의 컬랙션이 따로 존재한다면 문제가 상호간의 변화같은게 필요하기 때문이다.

    // 코틀린은 java보다 컬랙션을 사용하는 많은 기능을 제공한다.
    val strings = listOf("first", "second", "fourteenth")
    println(strings.last()) // 마지막 값 가져오기

    val numbers = setOf(1, 14, 2)
    println(numbers.max())  // 가장 큰 값 가져오기

}