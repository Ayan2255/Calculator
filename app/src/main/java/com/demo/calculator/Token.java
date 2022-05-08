package com.demo.calculator;



import java.util.Collection;
import java.util.Vector;

public class Token {

    private Vector<String> result;

    public boolean isOperator(char ch) {

        boolean b = true;
        String operator = "+-*/()%^";

        for (int i = 0; i < operator.length(); i++) {

            if (ch == operator.charAt(i)) {
                b = true;
                break;
            } else {
                b = false;
            }

        }

        return b;
    }

    public Vector<String> tokenize(String exp) {
        Vector<String> result = new Vector<String>();
        String token = "";

        for (int i = 0; i < exp.length(); i++) {

            char ch = exp.charAt(i);

            if (isOperator(ch)) {
                if(token == "") {
                    //	char c=result.elementAt(result.size()).charAt(0);
                    if(((result.isEmpty() && ch!='(')) ) {
                        System.out.println("Err...");
                        break;
                    }
                    token += ch;
                    result.add(token);
                    token = "";
                }
                else {
                    result.add(token);
                    token = "";
                    token+= ch;
                    result.add(token);
                    token = "";
                }
            }
            else {
                token += ch;
            }
        }
        if(token !="" ) {
            result.add(token);
        }

        return result;

    }
}
