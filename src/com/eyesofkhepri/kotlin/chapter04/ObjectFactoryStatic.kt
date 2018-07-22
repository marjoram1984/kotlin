package com.eyesofkhepri.kotlin.chapter04

import java.util.*
import kotlin.Comparator

fun main(args: Array<String>) {
    val sFlower = Flower.newSubscribingFlower("test@test.com")
    var gFlower = Flower.newGoodName(1)

    println(sFlower.name)
    println(gFlower.name)
}

// 비공개 주생성자 선언
class Flower(val name: String) {
    // companion object안에 선언된 프로퍼티나 메소드는 상위 클래스이름을 사용해서 접근이 가능하다. 예> Flower.newSubscribingFlower(...)
    companion object {  // companion object를 생성한다.
        fun newSubscribingFlower(small: String) = Flower(small.substringBefore("@"))
        fun newGoodName(no: Int) = Flower(getGoodName(no))
        fun getGoodName(no: Int) : String = no.toString()
    }



}



