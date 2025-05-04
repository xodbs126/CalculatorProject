package lv3;

import java.util.Stack;


public class ArithmeticCalculator<T extends Number> implements calculate_function {
    private T num1, num2;
    private char op;
    private double rs;
    private Stack<Double> resultlist = new Stack<>();


    /*
     * Getter / Setter 설정
     */
    public void setNum1(T num1) {
        this.num1 = num1;
    }

    public void setNum2(T num2) {
        this.num2 = num2;
    }

    public void setOp(char op) {
        this.op = op;
    }

    public char getOp() {
        return op;
    }

    /**
     * 계산 로직 구현
     */
    public double calculate(char op){

        switch (OperatorType.fromChar(op)) {
            case PLUS -> add();
            case MINUS -> sub();
            case MULTIPLY -> mul();
            case DIVIDE -> div();
        }
        return rs;
    }


    /**
     * 사칙 연산
     */
    @Override
    public void add() {
        rs = num1.doubleValue()+num2.doubleValue();
        resultlist.push(rs);
    }

    @Override
    public void sub() {
        rs = num1.doubleValue()-num2.doubleValue();
        resultlist.push(rs);
    }

    @Override
    public void mul() {
        rs = num1.doubleValue()*num2.doubleValue();
        resultlist.push(rs);
    }

    @Override
    public void div() {
        if(num2.doubleValue()==0) throw new ArithmeticException();
        else {
            rs = num1.doubleValue() / num2.doubleValue();
            resultlist.push(rs);
        }
    }

    /**
     * 결과 출력
     */
    public void printResult(){

        if(resultlist.isEmpty()){
            System.out.println("저장된 값이 없습니다.");
        }else {
            System.out.print("모든 결과 값 출력: ");
            for (Double v : resultlist) {
                System.out.print(v + " ");
            }
        }
        System.out.println();
    }

    public double removeResult() {
        return resultlist.pop();
    }

    public void printRsBigger(double input) {
        System.out.print("입력값보다 큰 결과값 들:");
        resultlist.stream()
                .filter(rs -> rs > input)
                .forEach(System.out::println);
    }
}

