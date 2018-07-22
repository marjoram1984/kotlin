package com.eyesofkhepri.kotlin.chapter02

import java.util.*


fun main(args: Array<String>) {
    // 초기값, 증가값, 최종값 형태를 사용한 Loop를 만들려면 Range라는 것을 사용해야한다.
    // Range는 기본적으로는 2개의 값으로 이루어진 구간이며 보통 정수타입의 값을 사용하며 ..연산자로 시작값과 끝값을 지정한다.
    for(i in 1..100) {  // 1부터 100까지 1씩 증가하는 값
        println(fizzBuzz(i))
    }

    // 100부터 1까지 거꾸로 가되 2씩 down하는 Loop 2는 -2이다
    for(i in 100 downTo 1 step 2) {
        println(fizzBuzz(i))
    }

    mapLoop()
    arrayLoopWithIndex()
    loopwhile1();
}

fun fizzBuzz(i: Int) = when {
    i % 15 == 0 -> "Fizz Buzz"
    i % 3 == 0 -> "Fizz"
    i % 5 == 0 -> "Buzz"
    else -> "$i"
}

fun mapLoop() {
    val binaryReps = TreeMap<Char, String>()    // 키정렬을 위해 TreeMap 사용

    for(c in 'A'..'F') {    // A에서 F까지 문자열을 이터레이션 한다.
        val binary = Integer.toBinaryString(c.toInt())  // 문자를 이진 코드로 변환한다.
        binaryReps[c] = binary  // c를 키로 c의 2진값을 값으로 binaryReps맵에 넣는다.
    }

    // binaryReps맵을 이터레이션 하면서 값을 출력한다.
    for((letter, binary) in binaryReps) {
        println("$letter = $binary")
    }
}

fun arrayLoopWithIndex() {
    val list = arrayListOf("10","11","12")
    for((index, elem) in list.withIndex()) { // withIndex는 index와 value를 프로퍼티로 갖는 Iterable<IndexedValue<T>> 를 반환한다.
        println("$index = $elem")
    }
}

fun loopwhile1() {
    println("while반복")
    var i = 0;
    while(i < 10) {
        println(++i);
    }

    i = 0;
    do{
        println(++i)
    } while(i < 10)
}