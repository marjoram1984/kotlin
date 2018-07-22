package com.eyesofkhepri.kotlin.chapter03;

import java.util.Arrays;
import java.util.List;

public class UseJoin {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("1","2","3");

        // EasyCallFun.kt안의 joinToString은 컴파일시 EasyCallFunKt라는 클래스안에 joinToString를 갖는 형태로 컴파일 된다.
        // System.out.println(EasyCallFunKt.joinToString(list, ",", "", ""));

        // Kotlin에서 @JvnName어노테이션을 통해서 클래스 이름을 변경할 수 있다. EasyCallFun.kt의 최상위 @file:JvmName("Good")
        System.out.println(Good.joinToString(list, ",", "", ""));

        // var로 선언하다보니 setter도 생성이 되어있다.
        TopPropertiesKt.setCounter(5);
        // 최상위 속성 확인, 최상위 속성 couter에 getter가 생성되어 있다.
        System.out.println(TopPropertiesKt.getCounter());

        // const를 이용해 static final 변수를 생성해서 사용할 수 있다.
        System.out.println(TopPropertiesKt.UNIX_LINE_SEPARATOR);

        // 확장함수는 해당 클래스가 아닌 자동 생성된 클래스의 내부에 static으로 생성이 된다.
        // NotOverrideExpendFunKt.cc();
    }
}
