package com.eyesofkhepri.kotlin.chapter04

// 모든 생성자에 Default 값을 지정하면 컴파일러가 자동으로 파아메터가 없는 생성자를 만들어준다.
// 차후 DI 프레임워크 사용시 이런 파라메터가 없는 생성자를 만들어야 하는 경우가 있는데 그때 모든 생성자에 Default값을 넣어줘야 한다.
fun main(args: Array<String>) {
    // User 클래스의 인스턴스 생성 isSubscribed는 Default로 생성됨
    val hyun = User("HYUN");
}

// 간단한 클래스 선언
// Default Value를 선언이 가능하다.
open class User(val nickname: String, val isSubscribed: Boolean = true)

// 만약 부모가 되는 클래스를 초기화 하고 싶으면 부모클래스 뒤에 괄호 치고 생성자 값을 넣는다.
class FacebookUser(nickname: String) : User(nickname) {
}


// 아무런 인자가 없는 Default생성자가 생긴다.
open class Price

// Price는 아무 인자가 없지만 Price를 상속한 하위 클래스는 반드시 Price의 생성자를 호출해줘야 한다.
// 하지만 interface같은 경우 생성자가 없어서 하위 클래스 선언시 ()를 하지 않는다, 부모가 인터페이스인지 클래스인지는 이 ()를 통해서 쉽게 알 수 있다.
class SecondPrice : Price()

// 만약 클래스를 인스턴스화 하지 못하게 하고 싶으면 모든 생성자를 private로 선언하면 된다. 아래와 같이 주 생성자에 private 변경자를 붙여서 사용한다.
// 이럴때의 장점은 유틸리티 함수를 가진 클래스나, 싱글턴을 사용시 쓰인다.
class Secretive private constructor() {

}