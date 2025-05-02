package lv2;

import java.util.InputMismatchException;
import java.util.Stack;

public class Calculator implements calculate_function {

    private int num1,num2;
    private char op;
    private Stack<Double> result = new Stack<>();
    private double rs;


    public double getRs() {
        return rs;
    }

    public void setNum1(int num1) throws InputMismatchException {
        this.num1 = num1;
    }

    public void setNum2(int num2) throws InputMismatchException {
        this.num2 = num2;
    }

    public void setOp(char op) {

        this.op = op;
    }

    public char getOp() {
        return op;
    }


    public void calculate(){
        switch (op) {
            case '+' -> add();
            case '-' -> sub();
            case '*' -> mul();
            case '/' -> div();
            default -> throw new IllegalStateException();
        }
        System.out.println("결과 : "+getRs());

    }

    public double removeResult() {
        return result.pop();
    }

    public void printResult(){
        System.out.print("모든 결과 값 출력: ");
        for (Double v : result) {
            System.out.print(v+" ");
        }
    }

    @Override
    public double add() {
        rs = num1+num2;
        result.push(rs);
        return rs;
    }

    @Override
    public double sub() {
        rs = num1-num2;
        result.push(rs);
        return rs;
    }

    @Override
    public double mul() {
        rs = num1*num2;
        result.push(rs);
        return rs;
    }

    @Override
    public double div() {
        if(num2==0){
            throw new ArithmeticException();
        }
        rs = num1/(double)num2;
        result.push(rs);
        return rs;
    }
}
