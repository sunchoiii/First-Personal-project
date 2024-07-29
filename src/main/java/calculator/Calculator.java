package calculator;
//수정한 Calculator 클래스를 활용하여 ArithmeticCalculator, CircleCalculator 클래스를 구현 (상속)

public abstract class Calculator {


    //계산 결과 보여줘!
    abstract double getNum();

    //리스트에 결과 저장
    abstract void setNum(double a);

    //저장된 연산 결과 내역을 조회
    abstract void inquiryResults();


}



