package com.eyesofkhepri.kotlin.chapter03

fun main(args: Array<String>) {
    val list = listOf(1, 2, 3)
    println(list.joinToString())

    var strList = listOf("a","b","c")
    println(strList.join())

    // join은 String을 받는 컬랙션이 수신객체타입이기에 Int값을 가지는 컬랙션 list는 사용할 수 없다.
    // println(list.join());
}

// 확장 함수 joinToString을 사용
fun <T> Collection<T>.joinToString(
        separator: String = ", ",
        prefix: String = "",
        postfix: String = "")
    : String {
    val result = StringBuilder(prefix)

    for((idx, el) in this.withIndex()) {
        if(idx > 0) {
            result.append(separator)
        }
        result.append(el)
    }

    result.append(postfix)
    return result.toString()
}

// 확장함수는 해당 대상이 되는 수신객체의타입을 따른다. 아래는 String객체를 가진 Collection만 사용하는 join함수이다.
fun Collection<String>.join(
        separator: String = ", ",
        prefix: String = "",
        postfix: String = ""
) = joinToString(separator, prefix, postfix)