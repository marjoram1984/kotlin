package com.eyesofkhepri.kotlin.chapter04

fun main(args: Array<String>) {
    println(Water.fromJSON("minala"))   // 바로 접근해서 사용할 수 잇고
    println(Water.Loader.fromJSON("Good Water"))    // 이름을 통해 접근해서 사용할 수 잇다.

    // outputJsonFactory에 클래스 자체를 넘긴다.
    // Bird 그 자체는 JSONFactory를 구현한 것이므로 JsonFactory를 구현햇다고 할수 잇다.
    outputJsonFactory(Bird)
}

fun <T> outputJsonFactory(jsonFactory: JSONFactory<T>) {
    // Bird안에 JsonFactory를 구현한 코드를 실행 할 수 있다.
    jsonFactory.fromJSON("json")
}

interface JSONFactory<T> {
    fun fromJSON(jsonText: String) : T
}

interface XmlFactory<T> {
    fun fromXml(jsonText: String) : T
}

data class Water(val name: String) {
    companion object Loader {   // companion object에 이름을 붙일 수 있다.
        fun fromJSON(jsonText: String): Water = Water(jsonText)
    }
}

data class Bird(val name: String) {
    // companion object는 인터페이스를 구현 해서 사용할 수 있다. companion object는 1개만 선언 가능하다.
    companion object : JSONFactory<Bird>, XmlFactory<Bird> {
        override fun fromXml(jsonText: String): Bird {
            println("fromXML = $jsonText");
            return Bird(jsonText)
        }

        override fun fromJSON(jsonText: String): Bird {
            println("fromJSON = $jsonText");
            return Bird(jsonText)
        }
    }
}