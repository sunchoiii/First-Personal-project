package calculator;

import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        ArrayList<Double> numbers = new ArrayList<>();
        ArrayList<Double> area = new ArrayList<>();

        ArithmeticCalculator arithmeticCalculator = new ArithmeticCalculator();
        CircleCalculator circleCalculator = new CircleCalculator();


        Scanner sc = new Scanner(System.in);

        /* 반복문 시작 */
        /* 사칙연산을 진행할지 원의 너비를 구할지 선택 구현 */
        while (true) {
            //사칙연산을 진행할지 원의 넓이를 구할지 명령어를 입력 받은 후
            System.out.print("무엇을 계산하시겠습니까? (원의넓이 또는 사칙연산 입력) : ");
            String two = sc.nextLine();

            // 원의 넓이를 구하는 것을 선택했을 때 원의 반지름을 입력 받아 원의 넓이를 구한 후 출력되도록 구현합니다.
            if (two.equals("원의넓이")) {
                while (true) {
                    /* 원의 넓이를 구하는 경우 반지름을 입력받아 원의 넓이를 구한 후 출력*/
                    System.out.print("원의 반지름 길이를 입력해주세요: ");
                    int radius = sc.nextInt();
                    double areaNumber;
                    //원의 넓이 구하기 메소드
                    areaNumber = circleCalculator.calculateCircleArea(radius);
                    //원의 넓이 구한거 보여줘
                    System.out.println(circleCalculator.getNum());
                    /* 원의 넓이 저장 */
                    circleCalculator.setNum(areaNumber);

                    /* 저장된 원의 넓이 값들 바로 전체 조회 */
                    System.out.print("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회) : ");
                    String show = sc.next();
                    if (show.equals("inquiry")) {
                        //넓이 리스트 조회 메서드 사용
                        circleCalculator.inquiryResults();
                    }

                    System.out.print("더 계산하시겠습니까? (exit 입력 시 종료) ");
                    String answer2 = sc.next();
                    if (answer2.equals("exit")) {
                        System.out.println("프로그램을 종료하겠습니다.");
                        break;
                        /* 반복문 종료 */
                    }
                }

            } else if (two.equals("사칙연산")) {
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
                        result = (int) ArithmeticCalculator.calculate(num1, num2, operator);
                        System.out.println(arithmeticCalculator.getNum());
                        //연산 결과를 Calculator 클래스의 연산 결과를 저장하는 필드 numbers2에 저장
                        arithmeticCalculator.setNum(result);
                    } catch (OutBadException e) {
                        System.out.println(e.getMessage());
                    }

                    //“remove”라는 문자열을 입력받으면 가장 먼저 저장된 결과가 삭제
                    System.out.print("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제) : ");
                    String remove = sc.next();
                    //인덱스 0번 값 삭제 = 맨 처음 저장된 값
                    if (remove.equals("remove")) {
                        // 삭제 메서드가 활용될 수 있도록 수정
                        arithmeticCalculator.removeResult();
                    }

                    //“inquiry”라는 문자열이 입력되면 저장된 연산 결과 전부를 출력
                    //foreach(향상된 for 문) 사용
                    System.out.print("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회) : ");
                    String show = sc.next();
                    if (show.equals("inquiry")) {
                        //Calculator 클래스에 저장된 연산 결과들을 조회
                        arithmeticCalculator.inquiryResults();
                    }

                    /* exit 을 입력 받으면 반복 종료 */
                    System.out.print("더 계산하시겠습니까?(exit 입력 시 종료) : ");
                    String answer = sc.next();
                    if (answer.equals("exit")) {
                        System.out.println("프로그램을 종료하겠습니다.");
                        break;
                    }
                }
            } else {
                System.out.println("잘못 입력하셨습니다.");
            }
        }
    }
}

