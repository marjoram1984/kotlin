package com.eyesofkhepri.kotlin.chapter04

fun main(args: Array<String>) {

}

/*
interface Expr
class Num(val v: Int) : Expr
class Sum(val v1: Expr, val v2: Expr): Expr

fun eval(v: Expr) : Int =
    when(v) {
        is Num -> v.v
        is Sum -> eval(v.v1) + eval(v.v2)
        else ->
            throw IllegalArgumentException("UnknownError")
    }*/

// sealed class를 선언했다.
// sealed class의 하위 클래스는 반드시 sealed class내부에 중첩 클래스로 선언해야 한다.
// 또한 sealed class는 자동으로 open이다.
sealed class Expr {
    // Num과 Sum은 중첩 클래스로 선언햇다.
    class Num(val v: Int) : Expr()
    class Sum(val v1: Expr, val v2: Expr): Expr()
    // class mod(val v1: Expr, val v2: Expr): Expr() // 하위 클래스 추가시 Expr을 사용하는 부분에서 Compile Error가 발생한다.
}

// sealed class에서는 이 sealed class를 사용하는 곳에선 하위 클래스 말고는 사용하지 못하게 강제하기에 이전처럼 else문을 쓸 필요가 엇다.
fun eval(v: Expr) : Int =
    when(v) {
        is Expr.Num -> v.v
        is Expr.Sum -> eval(v.v1) + eval(v.v2)
    }
