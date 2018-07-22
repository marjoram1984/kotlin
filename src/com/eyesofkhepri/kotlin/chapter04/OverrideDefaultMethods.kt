package com.eyesofkhepri.kotlin.chapter04

fun main(args: Array<String>) {
    val client = Client("client", 1)
    println(client)

    var client1 = Client("client", 1)
    println(client.equals(client1))
    println(client == client1)

    val processd = hashSetOf(Client("Good", 1))
    println(processd.contains(Client("Good", 1)))

    var master1 = Master("master", 1)

}

class Client(val name:String, val postalCode: Int) {
    // Override tostring
    override fun toString(): String = "Client(name=$name, postalCode=$postalCode)"

    // Override Equals
    override fun equals(other: Any?): Boolean { // Any는 Java의 Object와 비슷한 역할을 한다.
        if(other == null || other !is Client) { // is연산자는 java의 instanceof랑 같다. 값의 타입 비교에 쓰인다.
            return false;
        } else {
            return name == other.name && postalCode == other.postalCode
        }
    }

    // hashSet이나 집합객체에서 원소들을 비교할때 먼저 hashCode를 사용해서 같은지 확인하고 같은 경우에만 실값을 비교하기 때문에 실값이 같더라도 hashcode가 틀리다면 비교시 false가 나올수 있다.
    override fun hashCode(): Int = name.hashCode() * 31 + postalCode
}


// 클래스 앞에 data 변경자를 붙이면 알아서 필요한 메소드를 컴파일러가 만들어준다.
// 이런 클래스를 데이터 클래스라 부른다.
data class Master(val name: String, val postalCode: Int)

