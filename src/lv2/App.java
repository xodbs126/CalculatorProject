package lv2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        /* Calculator 인스턴스 생성 */
        Calculator cal = new Calculator();
        Scanner sc = new Scanner(System.in);
        /* 반복문 시작 */

        while(true) {
            try {
                System.out.print("첫 번째 숫자를 입력하세요: "); // 피 연산자 입력
                int num1 = sc.nextInt();
                cal.setNum1(num1);
                System.out.print("두 번째 숫자를 입력하세요: ");
                int num2 = sc.nextInt();
                cal.setNum2(num2);
                System.out.print("사칙연산 기호를 입력하세요: "); // 연산자 입력
                char operator = sc.next().charAt(0);
                cal.setOp(operator);

                try {
                    cal.calculate(); // Calculate의 계산 func() 호출
                } catch (IllegalStateException e) { // 예외 처리
                    System.out.println("[ERROR]: 해당 연산자는 지원하지 않습니다" + cal.getOp());

                }
            } catch (ArithmeticException e) {
                System.out.println("[ERROR]: 0으로 나눌수 없습니다.");
            }catch (InputMismatchException e){
                System.out.println("[ERROR]: 피연산자는 숫자만 가능합니다.");
                sc.next();
            }
            /* 위 요구사항에 맞게 소스 코드 수정 */
            System.out.print("더 계산하시겠습니까? (exit 입력 시 종료) ");
            String cmd = sc.next();
            if(cmd.equals("exit")) break;
            /* 반복문 종료 */
        }
        //removeResult() 활용
        System.out.println("가장 최근 결과값을 삭제합니다. : " + cal.removeResult());
        //모든 결과 값 출력
        cal.printResult();

    }
}
