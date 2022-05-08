package com.demo.calculator;

import java.util.Stack;
import java.util.Vector;

public class Postfix  {


    Token token=new Token();
    public int priority(String ch){
        if(ch.equals("+")|| ch.equals("-")){
            return 1;
        }
        else if(ch.equals("*")|| ch.equals("/")){
            return 2;
        }
        else if(ch.equals("^")){
            return 3;
        }
        else return -1;

    }





    public Vector<String> postfixx(Vector <String> infix) {

        Vector<String> result=new Vector<String>();
        try {
            Stack<String> st=new Stack<String>();
            infix.insertElementAt("(", 0);
            infix.insertElementAt(")", infix.size());


            for(int i=0;i<infix.size();i++) {
                String ch=infix.elementAt(i);

                if(ch.equals("(") )
                {
                    st.push(ch);
                }
                else if(ch.equals(")") )
                {
                    while(!st.peek().equals("(") && (!st.empty())) {

                        result.add(st.peek());
                        st.pop();

                    }
                    st.pop();

                }

                else if(token.isOperator(ch.charAt(0))  )
                {
                    while(!st.peek().equals("(") && (!st.empty())&& priority(ch)<=priority(st.peek())) {

                        result.add(st.peek());
                        st.pop();

                    }
                    st.push(ch);

                }
                else {
                    result.add(ch);
                }

            }}catch(Exception e) {
            System.out.println("Error...");
        }



        return result;}


}
