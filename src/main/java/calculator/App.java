package calculator;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        //연산 결과가 10개를 초과하는 경우 가장 먼저 저장된 결과를 삭제하고 새로운 연산 결과가 저장될 수 있도록 소스 코드를 수정 -> 큐 사용
        Queue<Integer> numbers = new LinkedList<>();

        Scanner sc = new Scanner(System.in);
        /* 반복문 사용해서 연산을 반복 */
        while (true) {
            // Scanner를 사용하여 양의 정수를 입력받고 적합한 타입의 변수에 저장합니다.
            System.out.print("첫 번째 숫자를 입력하세요: ");
            int num1 = sc.nextInt();
            System.out.print("두 번째 숫자를 입력하세요: ");
            int num2 = sc.nextInt();

            // 사칙연산 기호를 적합한 타입으로 선언한 변수에 저장합니다.
            System.out.print("사칙연산 기호를 입력하세요: ");
            // charAt(index) : charAt 메서드는 매개변수로 char 타입으로 반환하고자 하는 문자열의 위치(index)를 받는다
            char operator = sc.next().charAt(0);

            //입력받은 양의 정수 2개와 사칙연산 기호를 사용하여 연산을 진행한 후 결과값을 출력합니다.
            int result = 0;
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 == 0) {
                        System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                        break;
                    }
                    result = num1 / num2;
                    break;
                default:
                    System.out.println("잘못된 기호를 입력하셨습니다.");
            }
            System.out.println("결과: " + result);

            //현재 저장된 index가 마지막(9)라면 가장 먼저 저장된 결과 값이 삭제 되고 새로운 결과 값이 마지막 index에 저장될 수 있도록 구현

            if (numbers.size() > 9) {
                numbers.poll();
                numbers.add(result);
            } else {
                numbers.add(result);
            }

            /* exit을 입력 받으면 반복 종료 */
            System.out.print("더 계산하시겠습니까?(exit 입력 시 종료) : ");
            String answer = sc.next();

            if (answer.equals("exit")) {
                System.out.println("프로그램을 종료하겠습니다.");
                break;
            }
        }
    }
}

