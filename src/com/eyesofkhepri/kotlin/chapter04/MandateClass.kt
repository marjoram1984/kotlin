package com.eyesofkhepri.kotlin.chapter04

fun main(args: Array<String>) {
    val cset = CoutingSet<Int>()
    cset.addAll(listOf(1,2,3))
    println("${cset.objectAdded} objects were added, ${cset.size} remain")
}


// by를 사용해서 내가 직접 구현할 MutableCollection의 add와 addAll을 제외하고 나머지를 모두 HashSet인 innerSet에게 위임햇다.
class CoutingSet<T>(val innerSet: MutableCollection<T> = HashSet<T>())
    : MutableCollection<T> by innerSet {    // MutableCollection의 구현을 innerSet에게 위임한다.

    var objectAdded = 0

    override fun add(element: T): Boolean { // 구현을 위임하지 않고 새롭게 구현했다.
        objectAdded++

        return innerSet.add(element)
    }

    override fun addAll(elements: Collection<T>): Boolean { // 구현을 위임하지 않고 새롭게 구현했다.
        objectAdded += elements.size
        return innerSet.addAll(elements)
    }
}