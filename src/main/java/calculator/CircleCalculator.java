package calculator;

import java.util.ArrayList;

//원과 관련된 연산을 수행하는 계산기 CircleCalculator 클래스
public class CircleCalculator extends Calculator{

    double areaNumber;
    public static ArrayList<Double> area2 = new ArrayList<>();


    /* 2-7 원의 넓이를 구하는 메서드 선언*/
    // Math.PI:  Math 클래스는, 자바에서 제공하는 클래스로서 수학과 관련된 일들을 도와준다. 자바에서 파이 값 얻기
    public double calculateCircleArea(int b) {
        areaNumber = b * b * Math.PI;
        return areaNumber;
    }

    //넓이 구한거 보여줘
    @Override
    public double getNum() {
        return areaNumber;
    }

    //area2 리스트에 결과 저장
    @Override
    public void setNum(double a) {
        area2.add(a);
    }

    // area2 리스트에 저장된 결과 조회 메서드 생성
    @Override
    public void inquiryResults() {
        for (double result2 : area2) {
            System.out.println(result2 + " ");
        }
    }
}

