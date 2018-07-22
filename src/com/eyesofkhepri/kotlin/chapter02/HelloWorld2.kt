package com.eyesofkhepri.kotlin.chapter02

fun main(args: Array<String>) {
    val name = if(args.size > 0) args[0] else "Kotlin"
    // $name은 문자열 템플릿(String template)라는 것으로 '$변수'형태로 문자열안에 변수를 사용할 수 있다.
    println("Hello, $name!");

    // 만약 $를 넣고 싶으면 '\$' 형태로 넣으면 된다.
    println("Hello \$변수")

    // 참고로 문자열 템플릿은 '${}' 형태를 사용해서 식을 사용 할 수 있다. 또한 ""안에 ""를 사용할 수 있다.
    println("당신의 나이는 ${if (31<21) 35 else "36"}")

    // 만약 "를 넣고 싶으면 \" 형태를 사용한다. 특수기호나 이런 연관된 기호는 모두 앞에 \를 붙여서 표현 할 수 있다.
    println("당신의 나이는 ${if (31<21) 35 else "\"36\""}")

    val foods = arrayListOf<String>("apple", "chiken", "hanbuger")
    println("foods[0] 값은 = ${foods[0]}")

    // 한글을 쓸대 발생하는 실수로 영문도 마찬가지 변수를 띄어쓰지 않는한 해당 변수를 찾으려고 하기 때문이다.
    val koName = "조호영"
    // println("$koName님 안녕하세요"); 에러남 '$koname님' 까지를 변수로 인식 하기 때문이다. koname님 변수가 없음을 확인하고 오류 발생
    // println("$koNameGood"); 에러남
    println("${koName}님 안녕하세요.")    // ${}형태로 사용해야 한다.

    val violet = "바이올렛"


    println("$violet")
    println("$violet,")
    // 변수 이름을 의미할수 있는 그 무엇이라도 오류를 발생한다. 하지만 들어가면 오류가나는 특수기호는 특수기호를 제외한 나머지를 변수로 인식한다.
//    println("$violet강")
//    println("$violet조")
//    println("$violetcho")
    // 그냥 문자로 인식한다.
    println("$1violet")
}
