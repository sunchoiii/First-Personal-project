package calculator;

import java.util.ArrayList;
// 사칙연산을 수행하는 계산기 ArithmeticCalculator 클래스
// 2- 10 Interface & (다형성의 원리) 등을 활용 리팩토링
public class ArithmeticCalculator extends Calculator {
    //필드
    double result;
    public static ArrayList<Double> numbers2 = new ArrayList<>();

    //인터페이스 Aaa 형태로 사칙연산 클래스 인스턴스화 자동 형 변환
    Aaa divide= new DivideOperator();
    Aaa subtract= new SubtractOperator();
    Aaa add= new AddOperator();
    Aaa multiply= new MultiplyOperator();
    Aaa mod= new ModOperator();

    //메서드
    public double calculate(double num1, double num2, char operator) throws OutBadException {
        switch (operator) {
            case '+' :  result = add.bbb(num1, num2);
                        break;
            case '-' :  result = subtract.bbb(num1, num2);
                        break;
            case '*' :  result = multiply.bbb(num1, num2);
                        break;
            case '/' :  result = divide.bbb(num1, num2);
                        break;
            case '%' :  result = mod.bbb(num1, num2);
                        break;
            default :  throw new OutBadException("잘못된 기호를 입력하셨습니다.");
        } return result;
    }

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

    interface Aaa {
        double bbb(double num1, double num2);
    }
