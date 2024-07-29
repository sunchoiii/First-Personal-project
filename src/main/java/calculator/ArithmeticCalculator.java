package calculator;

import java.util.ArrayList;

//사칙연산을 수행하는 계산기 ArithmeticCalculator 클래스
public class ArithmeticCalculator extends Calculator {
    //필드
    static double result;
    public static ArrayList<Double> numbers2 = new ArrayList<>();


    //메서드
    public static double calculate(int num1, int num2, char operator) throws OutBadException {
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
            result = (double) num1 / num2;
        } else {
            throw new OutBadException("잘못된 기호를 입력하셨습니다.");
        }
        return result;
    }

    //2-4 Calculator 클래스에 저장된 연산 결과들 numbers2 중  가장 먼저 저장된 데이터를 삭제하는 기능을 가진 메서드
    public void removeResult() {
        numbers2.remove(0);
    }

    // 사칙연산 결과 보여줘!
    @Override
    public double getNum() {
        return result;
    }

    //numbers2 리스트에 결과 저장
    @Override
    public void setNum(double a) {
        numbers2.add(a);
    }

    // 2-5 Calculator 클래스에 저장된 연산 결과들을 조회하는 기능을 가진 메서드를 구현 -> App 클래스의 main 메서드에 활용
    @Override
    public void inquiryResults() {
        for (double result1 : numbers2) {
            System.out.println(result1 + " ");
        }
    }

}
