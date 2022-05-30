package com.demo.calculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.Toast;

import com.demo.calculator.databinding.ActivityMainBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    FirebaseFirestore firebaseFirestore;
    TextView textView;
    Calculator_main calculator_main=new Calculator_main();
    String s="";
    static int  bk=0;
ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        firebaseFirestore=FirebaseFirestore.getInstance();
        setContentView(binding.getRoot());
        binding.displayText.setTextSize(34);
        binding.displayText2.setTextSize(24);
        binding.displayText.setTextColor(Color.parseColor("#FFFFFF"));
        binding.displayText2.setTextColor(Color.parseColor("#868B8E"));


        binding.e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                binding.displayText.setText(s);
int a;
                binding.displayText.setTextSize(24);
                binding.displayText.setTextColor(Color.parseColor("#868B8E"));
                binding.displayText2.setTextColor(Color.parseColor("#FFFFFF"));
                binding.displayText2.setTextSize(34);

                if(!calculator_main.calculate(s).equals("Invalid equation")){
                  // binding.displayText2.getVisibility();
                    binding.displayText2.setText(calculator_main.calculate(s));
                      s=calculator_main.calculate(s);
                    Map<String,Object> map=new HashMap();

                    map.put("Equation",binding.displayText2.getText().toString());
                    map.put("Result",binding.displayText.getText().toString());

                    firebaseFirestore.collection("History").document("first")
                            .set(map).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void unused) {
                                    Toast.makeText(MainActivity.this, "Save data..", Toast.LENGTH_SHORT).show();
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(MainActivity.this, "Érror..", Toast.LENGTH_SHORT).show();
                                }
                            });



                }
                else {binding.displayText2.setText("");
                    Toast.makeText(MainActivity.this, "Plase valid equation..", Toast.LENGTH_SHORT).show();
                }



            }
        });

        
       binding.displayText.addTextChangedListener(textWatcher);
        binding.displayText.setText(s);
        binding.close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                if(s.length()!=0){
                    if(s=="("){bk--;}
                    if(s==")"){bk++;}


               s= s.substring(0, s.length() - 1);
                binding.displayText.setText(s);


                }

            }
        });
        binding.close.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                s="";
                bk=0;
                binding.displayText.setText(s);
                return false;
            }
        });
        binding.N.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             s="";
             bk=0;
                binding.displayText.setText(s);
            }
        });
        binding.b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s+="1";
                binding.displayText.setText(s);
            }
        });
        binding.b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s+="2";
                binding.displayText.setText(s);
            }
        });
        binding.b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s+="3";
                binding.displayText.setText(s);
            }
        });
        binding.b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s+="4";
                binding.displayText.setText(s);
            }
        });
        binding.b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s+="5";
                binding.displayText.setText(s);
            }
        });
        binding.b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s+="6";
                binding.displayText.setText(s);
            }
        });
        binding.b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s+="7";
                binding.displayText.setText(s);
            }
        });
        binding.b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s+="8";
                binding.displayText.setText(s);
            }
        });
        binding.b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s+="9";
                binding.displayText.setText(s);
            }
        });
        binding.b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s+="0";
                binding.displayText.setText(s);
            }
        });




        binding.sum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(s!=""&& s.charAt(s.length()-1 )!='+'&&
                s.charAt(s.length()-1)!='-'&&
                s.charAt(s.length()-1)!='*'&&
                s.charAt(s.length()-1)!='/'
                        &&s.charAt(s.length()-1)!='.'
                  )

                {
                    s+="+";
                    binding.displayText.setText(s);
                }
               else{   Toast.makeText(MainActivity.this, "Place valid input ", Toast.LENGTH_SHORT).show();
               }
            }
        });
        binding.sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(s!=""&& s.charAt(s.length()-1 )!='+'&&
                        s.charAt(s.length()-1)!='-'&&
                        s.charAt(s.length()-1)!='*'&&
                        s.charAt(s.length()-1)!='/'
                        &&s.charAt(s.length()-1)!='.'
                )

                {
                    s+="-";
                    binding.displayText.setText(s);
                }
                else{   Toast.makeText(MainActivity.this, "Place valid input ", Toast.LENGTH_SHORT).show();
                }
            }
        });
        binding.mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(s!=""&& s.charAt(s.length()-1 )!='+'&&
                        s.charAt(s.length()-1)!='-'&&
                        s.charAt(s.length()-1)!='*'&&
                        s.charAt(s.length()-1)!='/'
                        &&s.charAt(s.length()-1)!='.'
                )

                {
                    s+="*";
                    binding.displayText.setText(s);
                }
                else{   Toast.makeText(MainActivity.this, "Place valid input ", Toast.LENGTH_SHORT).show();
                }
            }
        });



        binding.div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(s!=""&& s.charAt(s.length()-1 )!='+'&&
                        s.charAt(s.length()-1)!='-'&&
                        s.charAt(s.length()-1)!='*'&&
                        s.charAt(s.length()-1)!='/'
                        &&s.charAt(s.length()-1)!='.'
                )

                {
                    s+="/";
                    binding.displayText.setText(s);
                }
                else{   Toast.makeText(MainActivity.this, "Place valid input ", Toast.LENGTH_SHORT).show();
                }
            }
        });
        binding.dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(s!=""&& s.charAt(s.length()-1 )!='+'&&
                        s.charAt(s.length()-1)!='-'&&
                        s.charAt(s.length()-1)!='*'&&
                        s.charAt(s.length()-1)!='/'
                        &&s.charAt(s.length()-1)!='.'
                )

                {
                    s+=".";
                    binding.displayText.setText(s);
                }
                else{   Toast.makeText(MainActivity.this, "Place valid input ", Toast.LENGTH_SHORT).show();
                }
            }
        });


        binding.pow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s+="^";
                binding.displayText.setText(s);
            }
        });



       binding.braket.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               if(s==""){
                   s+="(";
                   bk++;
               }

           else if( s.charAt(s.length()-1 )!='+'&&
                    s.charAt(s.length()-1)!='-'&&
                    s.charAt(s.length()-1)!='*'&&
                    s.charAt(s.length()-1)!='/'&&
                    s.charAt(s.length()-1)!='('&&
                    s.charAt(s.length()-1)!='.'
                    ){
                if(bk!=0)
                 {
                     bk--;
                     s+=")";

                }
                else{
                    s+="*(";
                    bk++;
                }

            }

            else{

                if(     s.charAt(s.length()-1 )=='+'||
                        s.charAt(s.length()-1)=='-'||
                        s.charAt(s.length()-1)=='*'||
                        s.charAt(s.length()-1)=='/'||
                        s.charAt(s.length()-1)=='('

                ){s+="(";
                    bk++;}
                else{s+="*(";
                    bk++;}




            }
               binding.displayText.setText(s);
           }
       });

       binding.displayText2.requestFocus();
       binding.displayText2.setBackgroundResource(android.R.color.transparent);


        binding.displayText.requestFocus();
        binding.displayText.setBackgroundResource(android.R.color.transparent);


binding.displayText2.setShowSoftInputOnFocus(false);
        binding.displayText.setShowSoftInputOnFocus(false);


    }
    TextWatcher textWatcher =new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
          //  String s=editable.toString();
            binding.displayText2.setText(s);
            binding.displayText.setTextSize(34);
            binding.displayText2.setTextSize(24);
            binding.displayText.setTextColor(Color.parseColor("#FFFFFF"));
            binding.displayText2.setTextColor(Color.parseColor("#868B8E"));

        }
    };





}