package calculator;

import java.util.ArrayList;

public class Calculator {
    //필드
    // 연산 결과를 저장하는 컬렉션 타입 필드 선언 및 생성
    ArrayList<Integer> numbers = new ArrayList<Integer>();


    //메서드
    // 양의 정수 2개(0 포함)와 연산 기호를 매개변수로 받아 사칙연산(+,-,*,/) 기능을 수행한 후 결과 값을 반환하는 메서드
    // 나눗셈에서 분모에 0이 들어오거나 연산자 기호가 잘 못 들어온 경우 적합한 Exception 클래스를 생성 throw (매개변수로 해당 오류 내용을 전달합니다.)
    public double calculate(int num1, int num2, char operator) throws OutBadException {
        int result = 0;
        if (operator == '+') {
            result = num1 + num2;
        } else if (operator == '-') {
            result = num1 - num2;
        } else if (operator == '*') {
            result = num1 * num2;
        } else if (operator == '/') {
            if (num2 == 0) {
                throw new OutBadException("분모에 0이 들어왔습니다.");
            }
            result = num1 / num2;
        } else {
            throw new OutBadException("연산자 기호가 잘 못 들어왔습니다.");
        }
        return result;
    }
}
