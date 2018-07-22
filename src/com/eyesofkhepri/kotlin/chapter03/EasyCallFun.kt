// 코틀린 최상위 함수가 포함되는 클래스 이름을 바꾸고 싶으면 아래 JvmName 어노테이션을 사용한다.
@file:JvmName("Good")

package com.eyesofkhepri.kotlin.chapter03

fun main(args: Array<String>) {
    val list = listOf(1, 2, 3)
    println(list)   // list 컬랙션의 toString호출 됨

    // 인자는 함수의 시그니쳐를 외우던가 해야 할수 있다. 즉 어떤 인자가 어떤인자인지 모르고 갯수도 모르는상태...
    //println(joinToString(list, "; ", "(", ")"))

    // 코틀린은 해당 함수의 인자를 아래와 같이 명시 할 수 있다. 좀더 명확히 어떤 인자를 넘기는지 알수 있다.
    println(joinToString(list, separator = "; ", prefix = "(", postfix = ")"))

    // 함수 실행시 없는 인자는 디폴트 파라메터가 알아서 넣어준다.
    println(joinToString(list))
}

// 컬랙션 받아서 prefix, postfix붙이고 컬랙션 사이사이 separator를 넣는 함수
// joinToString은 Class와 상관없이 선언이 되어 있다. 실제 이것은 파일이름 클래스 안에 선언이 된다. UseJoin.java에서 어떻게 사용하는지 살펴보자
fun <T> joinToString(
        collection: Collection<T>,
        separator: String = ", ", // 함수 선언시 Default파라메터를 지정할 수 있다.
        prefix: String = "", // 만약 함수 실행시 값을 넘겨주지 않는다 하더라도
        postfix: String = "") // Default 파라메터가 알아서 들어가게 된다.
    : String {
    val result = StringBuilder(prefix)

    for((idx, el) in collection.withIndex()) {
        if(idx > 0) {
            result.append(separator)    // 최초에는 separator를 넣으면 안된다.
        }

        result.append(el)
    }

    result.append(postfix)
    return result.toString()
}
