package calculator;
//수정한 Calculator 클래스를 활용하여 ArithmeticCalculator, CircleCalculator 클래스를 구현 (상속)
//Calculator 클래스에 사칙연산 클래스들을 어떻게 활용할 수 있을지 고민 해봅니다. (포함 관계)

public abstract class Calculator {

    //계산 결과 보여줘!
    abstract double getNum();

    //리스트에 결과 저장
    abstract void setNum(double a);

    //저장된 연산 결과 내역을 조회
    abstract void inquiryResults();


}



