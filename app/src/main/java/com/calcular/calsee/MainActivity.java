package com.calcular.calsee;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.EditText;
import android.os.Bundle;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText num1 = findViewById(R.id.num1);
        EditText num2 = findViewById(R.id.num2);
        TextView operator = findViewById(R.id.operator);
        TextView res = findViewById(R.id.textView);
        ImageButton add = findViewById(R.id.add);
        double[] m = {0};
        String[] operate = new String[1];

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operator.setText("+");
               operate[0] ="add";

            }
        });

        ImageButton sub = findViewById(R.id.sub);

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operator.setText("-");
               operate[0]="sub";
            }
        });

        ImageButton div = findViewById(R.id.div);
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operator.setText("÷");
               operate[0]="div";
            }
        });

        ImageButton multiply = findViewById(R.id.multiply);

        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operator.setText("×");
                operate[0]="mul";
            }
        });

        ImageButton percent = findViewById(R.id.percent);

        percent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operator.setText("%");
                operate[0]="mod";
            }
        });


        ImageButton pow = findViewById(R.id.pow);

        pow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operator.setText("^");
                operate[0]="power";
            }
        });

        ImageButton clear = findViewById(R.id.clear);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operator.setText("");
                num1.setText("");
                num2.setText("");
            }
        });

        ImageButton equal = findViewById(R.id.equal);

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a = num1.getText().toString();
                String b = num2.getText().toString();
                double n1 = ConvertDouble(a);
                double n2 = ConvertDouble(b);
                switch(operate[0]){
                    case"add": m[0]=Add(n1,n2);
                    res.setText("" + m[0]);
                    break;
                    case"sub": m[0]=Sub(n1,n2);
                        res.setText("" + m[0]);
                        break;
                    case"div": m[0]=divs(n1,n2);
                        res.setText("" + m[0]);
                        break;
                    case"mul": m[0]=Mul(n1,n2);
                        res.setText("" + m[0]);
                        break;
                    case"mod": m[0]=mod(n1,n2);
                        res.setText("" + m[0]);
                        break;
                    case"power": m[0]=Math.pow(n1,n2);
                        res.setText("" + m[0]);
                        break;
                    default: res.setText("recheck values");
                }


        };


        });
    }

    double ConvertDouble(String num) {
        if (num != null && num.length() > 0) {
            try {
                return Double.parseDouble(num);
            } catch(Exception e) {
                Toast.makeText(MainActivity.this, "Enter Values", Toast.LENGTH_SHORT).show();
                return 1;
            }
        }
        else return 0;
    }

    double Add(double i, double j){
        double sum = i+j;
        return sum;
    }

    double Sub(double i, double j){
        double dif = i-j;
                return dif;
    }

    double Mul(double i, double j){
        double prod = i*j;
        return prod;
    }

    double divs(double i, double j){
        double div = i/j;
        return div;
    }

    double mod(double i, double j){
        double rem = i%j;
        return rem;
    }

    }