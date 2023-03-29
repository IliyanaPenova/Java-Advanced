package StacksandQueues;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String [] numbers=scanner.nextLine().split("\\s+");
        ArrayDeque<String> stack=new ArrayDeque<>();
        Collections.addAll(stack,numbers);
        while(stack.size()>1){
            int firstNumber=Integer.parseInt(stack.pop());
            String operator=stack.pop();
            int secondNumber=Integer.parseInt(stack.pop());
            if(operator.equals("+")){
                stack.push(String.valueOf(firstNumber+secondNumber));
            }else{
                stack.push(String.valueOf(firstNumber-secondNumber));
            }
        }
        System.out.println(stack.pop());

    }
}
