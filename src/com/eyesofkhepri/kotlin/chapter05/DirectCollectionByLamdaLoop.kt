package com.eyesofkhepri.kotlin.chapter05

import kotlin.math.abs

fun main(args: Array<String>) {
    val books: List<Book> = listOf(Book("kbook", 50)
    ,Book("abook", 150)
    ,Book("bbook", 250)
    ,Book("cbook", 1350)
    ,Book("dbook", 450)
    ,Book("ebook", 550))

    findMaxPageBook(books)

    // list에서 제공해주는 maxBy함수에 람다식을 써서 검색하는 방법이다.
    println(books.maxBy({ b:Book -> b.page }))

    // 코틀린은 맨뒤에 있는 파라메터가 람다식이면 파라메터 괄호에서 뺄수 있는 기능을 제공해준다.
    println(books.maxBy() { b:Book -> b.page })

    // 코틀린은 인자가 람다식만 존재할 경우 괄호 마저 뺄수 있는 기능을 제공해준다
    println(books.maxBy { b:Book -> b.page })

    // 파라메터 타입을 추론해서 뺄수 있다.
    println(books.maxBy {b -> b.page})

    // 람다식을 좀더 줄여서 쓸수 있다.
    // it은 반복하는 해당 객체를 의미한다. it은 파라메터가 1개이고 그 타입을 추론 할 수 있는 경우 쓸 수 있다.
    println(books.maxBy { it.page })

    // it이 아닌 맴버참조 형태로 검색이 가능하다.
    println(books.maxBy(Book::page))

    // 람다를 변수에 저장하거나 추론할수 없는 상황이라면 파라메터 타입을 명시 해줘야 한다.
    val getPage = {b: Book -> b.page}

    val sums = {x: Int, y: Int ->
        val c = x + y
        c  // 마지막에 있는 문장이 리턴식이 된다.
    }

    println(sums(1,2))

}

// 람다식을 사용하지 않고 검색하는 함수
fun findMaxPageBook(books: List<Book>) {
    var maxPage = 0 // 가장 많은 페이지를 저장한다. loop 본문의 비교식에서 사용된다.
    var theMaxBook: Book? = null    // 가장 페이지가 많은 책을 저장한다.

    for(book in books) {
        if(book.page > maxPage) {   // 인자 books를 루프돌면서 현재까지 발견된 가장 많은 페이지를 가진 책보다 페이지가 더 많으면 최대값을 변경하고 해당 책을 따로 저장한다.
            maxPage = book.page
            theMaxBook = book
        }
    }

    println(theMaxBook)
}

data class Book(val name: String, val page: Int)

