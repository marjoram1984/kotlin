package com.eyesofkhepri.kotlin.chapter02


fun main(args: Array<String>) {
    println(eval(Sum(Sum(Num(1), Num(2)), Num(4))))
    println(eval2(Sum(Sum(Num(1), Num(2)), Num(4))))
    println(eval3(Sum(Sum(Num(1), Num(2)), Num(4))))
}

interface Expr

// value라는 프로퍼티만 존재하는 단순한 클래스이며 Expr인터페이스를 구현한다.
class Num(val value: Int): Expr
// Expr 타입의 객체를 프로퍼티로 받고 있으며 Num이나 Sum을 인자로 사용할 수 있다.
class Sum(val left: Expr, val right: Expr): Expr

// 스마트 캐스트 사용시 참고사항은 클래스 내부로 사용할때 val로 선언한 변수에 커스텀 접근자를 사용하지 않은 프로퍼티에만 사용해야한다. 스마트 캐스트 자체가 무조건 is로 비교한 값으로 리턴하기 때문이다.
fun eval(e: Expr): Int {
    if(e is Num) {  // is는 해당 객체의 타입이 옳은지 찾는다.
//        val n = e as Num    // e를 Num타입으로 변환, 불필요한 작업
        val n = e   // 위에 is를 통해서 원하는 타입인지 알게되면 e as Num처럼 타입을 변환 하지 않아도 알아서 컴파일러가 타입변환을 해준다 이것이 스마트 캐스트라고 하는것이다.
        return n.value
    }

    if(e is Sum) {  // is Sum을 통해서 e가 Sum인지 체크를 했기 때문에
        return eval(e.right) + eval(e.left) // e는 스마트 캐스트를 통해서 자동적으로 Sum으로 형변환 된다.
    }

    throw IllegalArgumentException("Unknown expression")
}

// if 자체가 식이니 리턴문과 중괄호를 없에서 간단히 사용할 수 있다.
fun eval2(e: Expr): Int =
        if(e is Num) {
            e.value // 가장 마지막 행이 결과값이다.
        } else if(e is Sum) {
            eval2(e.right) + eval(e.left)
        } else {
            throw IllegalArgumentException("Unknown expression")
        }

// when을 사용해서 좀더 코드를 다듬을 수 있다.
fun eval3(e: Expr): Int =
        when(e) {
            is Num -> e.value
            is Sum -> eval3(e.right) + eval3(e.left)
            else -> throw IllegalArgumentException("Unknown expression")
        }