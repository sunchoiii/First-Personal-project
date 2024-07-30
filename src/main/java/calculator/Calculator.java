package calculator;
//Calculator 클래스를  추상클래스로 구현/  ArithmeticCalculator, CircleCalculator 클래스에 상속
public abstract class Calculator {

    //원의넓이, 사칙연산의 공통된 메서드를 추상메서드로 구현
    //계산 결과 보여줘!
    abstract double getNum();

    //각 리스트에 결과 저장
    abstract void setNum(double a);

    //저장된 연산 결과 내역을 조회
    abstract void inquiryResults();

}