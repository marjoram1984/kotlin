package com.eyesofkhepri.kotlin.chapter02

fun main(args: Array<String>) {
    println(FreeColor.BLUE.rgb());
    println(getMnemonic(FreeColor.RED));
    println(mix(FreeColor.RED, FreeColor.YELLOW))
    println(maxOptimized(FreeColor.RED, FreeColor.YELLOW))
    println(getMnemonic3())
}

// 일반적인 사용방식
enum class Color {
    RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET
}

// enum 클래스 안에서 프로퍼티를 정의 할수 있고
enum class FreeColor(val r: Int, val g: Int, val b: Int) { // 프로퍼티 정의
    // 각 상수를 생성할 때 그에 대한 프로퍼티를 정의 할 수 있다.
    RED(255,0,0), ORANGE(255,165,0), YELLOW(255,255,0),
    GREEN(0,255,0), BLUE(0,0,255), INDIGO(75,0,130), VIOLET(238,130,238); // 여기선 꼭 마지막에 세미콜론을 해줘야 한다.

    // enum 클래스 안에서 메소드를 정의할 수 있다.
    // enum 클래스 안에서 사용되는 메소드는 해당 상수에 종속된다.
    // 사용법은 FreeColor.RED.rgb() 이런식으로 사용이 된다.
    fun rgb() = (r * 256 + g) * 256 + b
}

interface MouseAdapter {
    fun mouseClicked(e: String)
}

class Mouse {
    companion object {
        fun mouseListner(m: MouseAdapter) {
            m.mouseClicked("test");
        }
    }
}

fun getMnemonic1(color: FreeColor) =
        when(1+1) { // 식이 들어올 수 있다.
            2 -> "숫자2"
            else -> "숫자3"
        }


fun getMnemonic3() =
        when(object: com.eyesofkhepri.kotlin.chapter04.MouseAdapter {   // 무명 객체도 들어올 수 있다.
            override fun mouseClicked(e: String) {
            }
        }) { // 식이 들어올 수 있다.
            else -> "숫자3"
        }

fun getMnemonic2(color: FreeColor) =
        when(if(1>0) 1 else 2) {    // if도 식이기 때문에 사용이 가능하다.
            2 -> "숫자2"
            else -> "숫자3"
        }

fun getMnemonic(color: FreeColor) =
    when(color) {
        // java의 switch의 break 없어도 된다.
        FreeColor.RED -> "Richard"
        FreeColor.ORANGE -> "Of"
        FreeColor.YELLOW -> "York"
        FreeColor.GREEN -> "Gave"
        FreeColor.BLUE -> "Battle"
        FreeColor.INDIGO -> "In"
        FreeColor.VIOLET -> "Vain"
    }

fun getWarmth(color: FreeColor) =
        when(color) {
            // 한분기에서 여러 조건을 주고 싶을땐 ','를 사용한다.
            FreeColor.RED, FreeColor.ORANGE, FreeColor.YELLOW -> "Warm"
            FreeColor.GREEN -> "natural"
            FreeColor.BLUE, FreeColor.VIOLET, FreeColor.INDIGO -> "cold"
        }

fun mix(color1: FreeColor, color2: FreeColor) =
        // switch랑 다르게 when안에는 임의의 객체를 허용한다.
        when(setOf(color1, color2)) {   // setOf는 인자를 포함하는 새로운 집합객체 Set을 반환한다. Set은 값이 모여있는 객체로 값의 순서는 중요하지 않다.
            setOf(FreeColor.RED, FreeColor.YELLOW) -> FreeColor.ORANGE
            setOf(FreeColor.YELLOW, FreeColor.BLUE) -> FreeColor.GREEN
            setOf(FreeColor.BLUE, FreeColor.VIOLET) -> FreeColor.INDIGO
            else -> throw Exception("Dirty Color")  // 위에 매치되는 분기 조건이 없을 경우 해당 문장을 실행한다.
        }

// 인자 없는 when을 사용하는 방법, mix는 setOf객체를 계속 생성하기 때문에 성능상 불리하다, 그래서 비교 없이 조건절을 통해서 아래와 같이 만들 수 있다.
fun maxOptimized(c1: FreeColor, c2: FreeColor) =
    when {  // 인자 없음
        (c1 == FreeColor.RED && c2 == FreeColor.YELLOW) || (c1 == FreeColor.YELLOW && c2 == FreeColor.RED) -> FreeColor.ORANGE
        (c1 == FreeColor.YELLOW && c2 == FreeColor.GREEN) || (c1 == FreeColor.GREEN && c2 == FreeColor.YELLOW) -> FreeColor.ORANGE
        (c1 == FreeColor.BLUE && c2 == FreeColor.VIOLET) || (c1 == FreeColor.VIOLET && c2 == FreeColor.BLUE) -> FreeColor.INDIGO
        else -> throw Exception("Dirty color")
    }
