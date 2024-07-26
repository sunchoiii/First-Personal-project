package calculator;

import java.util.ArrayList;

public class Calculator {
    //필드
    // 연산 결과를 저장하는 컬렉션 타입 필드 선언 및 생성 List
    //App 클래스의 main 메서드에서 Calculator 클래스의 연산 결과를 저장하고 있는 컬렉션 필드에 직접 접근하지 못하도록 수정합니다. (캡슐화)
    private static final ArrayList<Integer> numbers2 = new ArrayList<>();


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

    /* Getter 메서드 구현 */
    // numbers2 리스트를 보여줘!
    public static String getNumbers2 () {
        return numbers2.toString();
    }


    /* Setter 메서드 구현 */
    //numbers2 리스트에 결과 저장하기 위해 메서드 생성
    public static void setNumbers2 (int a) {
        numbers2.add(a);
    }

    //Calculator 클래스에 저장된 연산 결과들 numbers2 중  가장 먼저 저장된 데이터를 삭제하는 기능을 가진 메서드
    public void removeResult() {
        numbers2.remove(0);
    }

}


