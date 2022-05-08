package com.demo.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.demo.calculator.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Calculator_main calculator_main=new Calculator_main();
    String s="";
ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.displayText.setTextSize(34);
        binding.displayText2.setTextSize(24);
        binding.displayText.setTextColor(Color.parseColor("#FFFFFF"));
        binding.displayText2.setTextColor(Color.parseColor("#868B8E"));


        binding.e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                binding.displayText.setText(s);

                binding.displayText.setTextSize(24);
                binding.displayText.setTextColor(Color.parseColor("#868B8E"));
                binding.displayText2.setTextColor(Color.parseColor("#FFFFFF"));
                binding.displayText2.setTextSize(34);

                if(!calculator_main.calculate(s).equals("Invalid equation")){

                    binding.displayText2.setText(calculator_main.calculate(s));

                }
                else {binding.displayText2.setText("");
                    Toast.makeText(MainActivity.this, "Plase valid equation..", Toast.LENGTH_SHORT).show();
                }


                s="";

            }
        });

        
       binding.displayText.addTextChangedListener(textWatcher);
        binding.displayText.setText(s);
        binding.close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(s.length()!=0){
               s= s.substring(0, s.length() - 1);
                binding.displayText.setText(s);}
            }
        });
        binding.close.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                s="";
                binding.displayText.setText(s);
                return false;
            }
        });
        binding.N.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             s="";
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
                s+="+";
                binding.displayText.setText(s);
            }
        });
        binding.sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s+="-";
                binding.displayText.setText(s);
            }
        });
        binding.mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s+="*";
                binding.displayText.setText(s);
            }
        });



        binding.div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s+="/";
                binding.displayText.setText(s);
            }
        });
        binding.dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s+=".";
                binding.displayText.setText(s);
            }
        });


        binding.pow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s+="^";
                binding.displayText.setText(s);
            }
        });






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