package calculator;

import java.util.ArrayList;

public class Calculator {
    //필드
    // 연산 결과를 저장하는 컬렉션 타입 필드 선언 및 생성 List
    static ArrayList<Integer> numbers2 = new ArrayList<>();


    //메서드
    public static double calculate(int num1, int num2, char operator) throws OutBadException {
        int result = 0;
        if (operator == '+') {
            result = num1 + num2;
        } else if (operator == '-') {
            result = num1 - num2;
        } else if (operator == '*') {
            result = num1 * num2;
        } else if (operator == '/') {
            if (num2 == 0) {
                throw new OutBadException("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
            }
            result = num1 / num2;
        } else {
            throw new OutBadException("잘못된 기호를 입력하셨습니다.");
        }
        return result;
    }

    //numbers2 리스트에 결과 저장하기 위해 메서드 생성
    public static void numbers2(int a) {
        numbers2.add(a);
    }

}


