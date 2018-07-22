package com.eyesofkhepri.kotlin.chapter04

fun main(args: Array<String>) {

}

internal open class TalkativeButton : Focusable {
    private fun yell() = println("Hey!")
    protected fun whisper() = println("Let's talk")
}

// TalkativeButton이 internal이기 때문에 오류가 발생한다
// open class TalkativeButton으로 하던가
// TalkativeButton.giveSpeech()을 사용해야 한다.
//fun TalkativeButton.giveSpeech() {
internal fun TalkativeButton.giveSpeech() {
}

