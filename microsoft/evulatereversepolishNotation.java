package com.anshuman;

import java.util.Arrays;
import java.util.Stack;

public class evulatereversepolishNotation {
    public static void main(String[] args) {
        String[] arr = {"4","13","5","/","+"};
        System.out.println( evalRPN(arr));
    }
    public static int evalRPN(String[] tokens) {

        Stack<Integer> st  = new Stack<>();
        for (String s : tokens){
            switch (s){
                case "+":
                    st.push(st.pop() + st.pop());
                    break;

                case "-":
                    st.push(-st.pop() + st.pop());
                    break;
                case  "*":
                    st.push(st.pop() * st.pop());
                    break;
                case "/":
                    int val = st.pop();
                    st.push(st.pop() / val);
                    break;
                default:
                    st.push(Integer.parseInt(s));

            }

        }
        return st.pop();
    }
// time complexcity o(n)
    // spacecomplexcity o(n)



    //problem
    //Runtime Error
    //java.lang.NumberFormatException: For input string: "*"
    //  at line 67, java.base/java.lang.NumberFormatException.forInputString

//    public static int evalRPN(String[] tokens) {
//        // take a stack to check every operent and oprator
//        Stack<Long> st = new Stack<>();
//        // trverse through the string arr
//        for(String ch : tokens){
//            if (ch.equals("+") || (ch == "-") || (ch == "/") || ch =="*"){
//                long a = st.pop(); // convert string to intenger
//                long b = st.pop(); // convert string to intenger
//
//                if (ch == "+") a =  b + a ;
//                if (ch == "-") a = b - a;
//                if (ch == "*") a = b * a;
//                if (ch == "/") a = b / a;
//                st.push(a);
//
//            }
//            else {
//                st.push(Long.parseLong(ch)) ;
//            }
//
//        }
//        return Integer.parseInt(String.valueOf(st.peek()));
//
//
//    }

}
