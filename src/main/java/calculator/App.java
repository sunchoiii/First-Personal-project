package calculator;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        ////연산 결과가 10개로 고정되지 않고 무한이 저장될 수 있도록 소스 코드를 수정
        // -> ArrayList 사용 (순서가 있어서 인덱스로 첫번째값을 불러올 수 있기 때문)
        ArrayList<Integer> numbers = new ArrayList<>();

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

            // 결과 무한 저장
            numbers.add(result);

            //“remove”라는 문자열을 입력받으면 가장 먼저 저장된 결과가 삭제
            System.out.print("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제) : ");
            String remove = sc.next();
            //인덱스 0번 값 삭제 = 맨 처음 저장된 값
            if (remove.equals("remove")) {
                numbers.remove(0);
            }

            //“inquiry”라는 문자열이 입력되면 저장된 연산 결과 전부를 출력
            //foreach(향상된 for 문) 사용
            System.out.print("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회) : ");
            String show = sc.next();
            if (show.equals("inquiry")) {
                for(int result1 : numbers ) {
                    System.out.println(result1 + " ");
                }
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

