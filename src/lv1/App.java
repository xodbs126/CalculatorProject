package lv1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double result =0;

        while(true) {
            try{
            System.out.print("첫 번째 숫자를 입력하세요: "); // 피 연산자 입력
            int num1 = sc.nextInt();

            System.out.print("두 번째 숫자를 입력하세요: ");
            int num2 = sc.nextInt();

            System.out.print("사칙연산 기호를 입력하세요: "); // 연산자 입력
            String op = sc.next();
                result = switch (op) { // 사칙연산 func()
                    case "+" -> num1 + num2;
                    case "-" -> num1 - num2;
                    case "*" -> num1 * num2;
                    case "/" -> (double) num1 / num2;
                    default -> throw new IllegalStateException(); //지원하지 않는 연산자는 예외 발생
                };
                System.out.println("결과: " + result);

            }catch (IllegalStateException e){ // 예외 처리 로직
                System.out.println("[ERROR]: 해당 연산자는 지원하지 않습니다");
            }catch(ArithmeticException e){
                System.out.println("[ERROR]: 0으로 나눌수 없습니다.");
            }catch(InputMismatchException e){
                System.out.println("[ERROR]: 피연산자는 숫자만 가능합니다.");
                sc.next();
            }

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            String cmd = sc.next();
            if(cmd.equals("exit")) break;


        }
    }
}