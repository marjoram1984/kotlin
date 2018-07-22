package com.eyesofkhepri.kotlin.chapter04

import java.util.*
import kotlin.Comparator

fun main(args: Array<String>) {
    println(CaseInsensitiveFileComparator.compare("test1", "test2"))

    val codes = listOf("test1", "test2")
    println(codes.sortedWith(CaseInsensitiveFileComparator))

    var persons = listOf<Person>(Person("no1", "Honawodo"), Person("no2", "MEsh"))
    println(persons.sortedWith(Person.NameComparator))

}

data class Person(val no: String, val name: String) {
    // 함수 내부에 내부 함수로 선언하고 사용해도 오직 인스턴스는 1개만 생성된다.
    object NameComparator : Comparator<Person> {
        override fun compare(o1: Person, o2: Person): Int = o1.name.compareTo(o2.name)
    }
}

// object를 사용한 CaseInsensitiveFileComparator를 사용하는 곳에선 자동으로 싱글턴 객체를 사용할 수 있다.
object CaseInsensitiveFileComparator : Comparator<String> {
    override fun compare(o1: String, o2: String): Int {
        return o1.compareTo(o2, ignoreCase = true)
    }

}