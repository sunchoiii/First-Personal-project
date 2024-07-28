package calculator;

import java.util.ArrayList;

public class Calculator {
    //필드
    double areaNumber;
    // 사칙연산 결과를 저장하는 컬렉션 타입 필드 선언 및 생성 List 캡슐화
    private static ArrayList<Integer> numbers2 = new ArrayList<>();

    /* static, final 활용 */
    //static 을 사용한 이유:  객체 없이 호출이 가능한 static 을 사용함으로써, 클래스 내 메서드에서 바로 사용할 수 있도록 했다.
    //final 을 사용하지 않은 이유: final 을 사용하려면 반드시 초기값을 설정해야하고, 절대 수정이 불가하다. 이 리스트 필드는 생성자를 통해 초기화가 되도록 해야되서 사용할 수 없었다.
    /* 원의 넓이 결과를 저장하는 컬렉션 타입의 필드 선언 및 생성 */
    private static ArrayList<Double> area2 = new ArrayList<>();


    /* 연산 결과를 저장하는 컬렉션 타입 필드가 생성자를 통해 초기화 되도록 변경 */
    /* 생성자 구현 */
    public Calculator(ArrayList<Integer> numbers, ArrayList<Double> area) {
        numbers2 = numbers;
        area2 = area;
    }


    //메서드
    public static double calculate(int num1, int num2, char operator) throws OutBadException {
        int result;
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
    public static void setNumbers2(int a) {
        numbers2.add(a);
    }

    //2-4 Calculator 클래스에 저장된 연산 결과들 numbers2 중  가장 먼저 저장된 데이터를 삭제하는 기능을 가진 메서드
    public void removeResult() {
        numbers2.remove(0);
    }

    // 2-5 Calculator 클래스에 저장된 연산 결과들을 조회하는 기능을 가진 메서드를 구현 -> App 클래스의 main 메서드에 활용
    public void inquiryResults() {
        for (int result1 : numbers2) {
            System.out.println(result1 + " ");
        }
    }

    /* 2-7 원의 넓이를 구하는 메서드 선언*/
    // Math.PI:  Math 클래스는, 자바에서 제공하는 클래스로서 수학과 관련된 일들을 도와준다. 자바에서 파이 값 얻기
    public double calculateCircleArea(int b) {
        areaNumber = b * b * Math.PI;
        return areaNumber;
    }

    /* 원의 넓이 저장 필드 Getter, Setter, 조회 메서드 구현 */
    //넓이 구한거 보여줘
    public double getArea2() {
       return areaNumber;
    }

    //area2 리스트에 결과 저장하기 위해 메서드 생성
    public void setArea2(double c) {
        area2.add(c);
    }

    // area2 리스트에 저장된 결과 조회 메서드 생성
    public void inquiryArea() {
        for (double result2 : area2) {
            System.out.println(result2 + " ");
        }
    }

}



