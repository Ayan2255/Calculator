package com.demo.calculator;


import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.Vector;


public class Equation {
    Stack<Double> st = new Stack<Double>();
    //	Vector<String> vc=new Vector<String>();
    double result = 0, ft, sd;
    //	Queue<String> qe = new PriorityQueue<>();
    Vector<String> vc = new Vector<String>();
    //	Postfix postfix = new Postfix();
    Token token = new Token();

    public double e(Vector<String> s) {
        for(int  i=0; i<s.size(); i++) {
            String el = s.elementAt(i);
            if(token.isOperator(el.charAt(0))){
                double ft = st.peek();
                if(st.size()!=0) {
                    st.pop();
                }
                double sd = st.peek();
                if(st.size()!=0) {
                    st.pop();
                }
                switch (el) {

                    case "+": {
                        st.add(ft+sd);
                        break;
                    }
                    case "-": {
                        st.add(sd-ft);
                        break;
                    }
                    case "*": {
                        st.add(ft*sd);
                        break;
                    }
                    case "/": {
                        st.add(sd/ft);
                        break;
                    }
                    case "^": {
                        st.add(Math.pow(sd,ft));
                        break;
                    }
//					case "%": {
//						st.add(ft+sd);
//						break;
//					}
//
                    default:
                        result = 0;

                }

            }
            else {
                st.add(Double.parseDouble(el));
            }
            result = st.elementAt(0);

        }

        return result;
    }
}

