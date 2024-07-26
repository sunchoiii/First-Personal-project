package calculator;

import java.util.ArrayList;
import java.util.Scanner;

import static calculator.Calculator.*;

public class App {

    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();

        /* Calculator 인스턴스 생성 */
        Calculator calculator = new Calculator();

        Scanner sc = new Scanner(System.in);
        /* 반복문 사용해서 연산을 반복 */
        while (true) {
            System.out.print("첫 번째 숫자를 입력하세요: ");
            int num1 = sc.nextInt();
            System.out.print("두 번째 숫자를 입력하세요: ");
            int num2 = sc.nextInt();
            System.out.print("사칙연산 기호를 입력하세요: ");
            // charAt(index) : charAt 메서드는 매개변수로 char 타입으로 반환하고자 하는 문자열의 위치(index)를 받는다
            char operator = sc.next().charAt(0);

            //연산 수행 역할은 Calculator 클래스가 담당 + try ~ catch 문 사용해 예외 처리
            int result;
            try {
            result = (int) calculate(num1, num2, operator);
            System.out.println(result);
            //이 메인 메소드안의 리스트에 result 추가 (아래 코드들 실행되기 위해서)
            numbers.add(result);
            //연산 결과를 Calculator 클래스의 연산 결과를 저장하는 필드 numbers2에 저장
            setNumbers2(result);
            } catch (OutBadException e) {
                System.out.println(e.getMessage());
            }

            //“remove”라는 문자열을 입력받으면 가장 먼저 저장된 결과가 삭제
            System.out.print("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제) : ");
            String remove = sc.next();
            //인덱스 0번 값 삭제 = 맨 처음 저장된 값
            if (remove.equals("remove")) {
                numbers.remove(0);
                // 삭제 메서드가 활용될 수 있도록 수정
                calculator.removeResult();
            }

            //“inquiry”라는 문자열이 입력되면 저장된 연산 결과 전부를 출력
            //foreach(향상된 for 문) 사용
            System.out.print("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회) : ");
            String show = sc.next();
            if (show.equals("inquiry")) {
                for(int result1 : numbers ) {
                    System.out.println(result1 + " ");
                }
                //Calculator 클래스에 저장된 연산 결과들을 조회
                calculator.inquiryResults();
            }

            /* exit 을 입력 받으면 반복 종료 */
            System.out.print("더 계산하시겠습니까?(exit 입력 시 종료) : ");
            String answer = sc.next();
            if (answer.equals("exit")) {
                System.out.println("프로그램을 종료하겠습니다.");
                break;
            }
        }
    }
}

