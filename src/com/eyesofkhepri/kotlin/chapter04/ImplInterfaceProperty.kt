package com.eyesofkhepri.kotlin.chapter04

fun main(args: Array<String>) {
    println(PrivateCar("Zcar@Bus").carType);
    println(SubscribingCar("SubCar@Car").carType)
    println(FacebookCar(123).carName)

    val gCar = PrivateCar("gCar@Car");
    gCar.oil = "super oil"
    println(gCar.oil)
}

interface Car {
    // 이것은 Car를 구현하는 곳에서 carName의 값을 얻을 수 잇는 방법을 제공해야 한다는 의미다.
    val carName: String // 추상 속성 선언

    val carType: String // getter가 존재하는 속성 선언 이렇게 되면 반드시 carName을 오버라이드 해야한다. 하지만 carType은 반드시 오버라이드 하지 않아도 된다.
    get() = carName.substringBefore("@")
}

// 주 생성자 안에 carName을 직접 선언하는 방법
class PrivateCar(override val carName : String) : Car {

    // set안에서의 특별한 식별자 field는 해당 필드(예>oil)의 저장공간이다.
    // oil = 값 하는 순간에 set이 호출된다.
    // 참고로 뒷받침 필드는 커스텀 getter/setter에서 field라는 특별한 식별자를 쓰는 경우에만 생성이 된다.
    var oil: String = "unknown"
    set(value: String) {
        println("""
            oil status is
            "$field" -> "$value".
        """.trimIndent())
        field = value
    }
}

// 커스텀 Getter를 사용해서 carName을 선언햇다.
// carname을 사용시 마다 substringBefor를 호출 해서 반환한다.
class SubscribingCar(val email: String) : Car {
    override val carName: String
    get() = email.substringBefore("@")
}

// 클래스 내부에서 초기화식을 이용해서 초기화 했다.
// 딱 한번 초기화 될때 선언이 된다.
class FacebookCar(val accountId: Int) : Car {
    override val carName: String = getFacebookCar(accountId)
    fun getFacebookCar(accountId: Int) : String = "AccountId $accountId"
}