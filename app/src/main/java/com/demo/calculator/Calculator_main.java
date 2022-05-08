package com.demo.calculator;


import java.util.Vector;
public class Calculator_main {


    public String calculate (String s)  {
        Token token=new Token();

        Postfix postfix=new Postfix();
        Equation equation=new Equation();
      //  String s="((2*3)+(12/6))";
     //   System.out.println("Equation => \n"+s);
try {

    Vector <String> result = new Vector<String>();
    result=token.tokenize(s);

    if(result ==null) {System.out.println("null");}
    else {


        System.out.println("After Tokenize => \n"+result);
        System.out.println( "After Postfix => \n"+ postfix.postfixx(result));

        try {
            System.out.println("Finar result =>"+equation.e(  postfix.postfixx(result)));}
        catch(Exception e){
            System.out.println("Error....");
        }

    }
    String rr= String.valueOf(equation.e(  postfix.postfixx(result)));
    return rr;
}
catch (Exception e){
    return  "Invalid equation";
}
    }}
