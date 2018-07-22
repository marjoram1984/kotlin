package com.eyesofkhepri.kotlin.chapter03

// 가변인자는 메소드 호출시 원하는 갯수만큼 인자로 넘기면 알아서 그것을 배열로 만들어 넘겨주는 기능이다.
fun main(args: Array<String>) {
    val arrInt = arrayOf(1,2,3)
    // 배열값을 넘길때는 배열앞에 *를 넣어줘야 배열 안에 값을 명시적으로 풀어서 넘겨준다.
    dynamicList("test", *arrInt, 1234) // test, 1, 2, 3, 1234

    // 만약 *를 안넣었을 경우라면 같이 리스트 본연의 참조값이 넘어온다.
    dynamicList(arrInt) // list[~!@~@~!@]
}


// 가변인자를 사용하려면 vararg를 사용한다. 가변인자 사용시 해당 속성은 List형태의 값을 반환한다.
fun <T> dynamicList(vararg elem: T) {
    for(e in elem) {
        println(e)
    }
}
