package com.example.freakingmath;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView mA, mB, mOperator, mRes, mScore;
    ImageButton mRight, mFail;
    boolean check;
    Random random;
    int a, b, kq;
    int operator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Mapping();
        setRandom();
        setOnclick();
    }
    //Ánh xạ
    private void  Mapping(){
        mA = findViewById(R.id.a);
        mB = findViewById(R.id.b);
        mOperator = findViewById(R.id.operator);
        mRes = findViewById(R.id.res);
        mScore = findViewById(R.id.score);
        mFail = findViewById(R.id.fail);
        mRight = findViewById(R.id.dung);
    }

    //set Random
    private void setRandom(){
        random = new Random();
        a = random.nextInt(100);
        b = random.nextInt(100);
        operator = random.nextInt(4);
        check = random.nextBoolean();
        mA.setText(String.valueOf(a));
        mB.setText(String.valueOf(b));
        switch (operator){
            case 0:
                mOperator.setText(" + ");
                kq = a + b;
                break;
            case 1:
                mOperator.setText(" - ");
                kq = a - b;
                break;
            case 2:
                mOperator.setText(" * ");
                kq = a * b;
                break;
            case 3:
                mOperator.setText(" / ");
                kq = a / b;
                break;
        }
        if(!check){
            int temp = -10 + random.nextInt(20);
            kq = kq + temp;
        }
        mRes.setText(String.valueOf(kq));
    }

    //set Onclick
    private void  setOnclick(){

        mRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(check){
                    int temp = Integer.parseInt(mScore.getText().toString()) + 10;
                    mScore.setText(String.valueOf(temp));
                    Toast.makeText(MainActivity.this, "Bạn đac chọn đúng. Bạn được cộng 10 điểm", Toast.LENGTH_SHORT).show();
                }
                else {
                    int temp = Integer.parseInt(mScore.getText().toString()) - 10;
                    mScore.setText(String.valueOf(temp));
                    Toast.makeText(MainActivity.this, "Bạn đac chọn sai. Bạn bị trừ 10 điểm", Toast.LENGTH_SHORT).show();
                }
                setRandom();
            }
        });

        mFail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!check){
                    int temp = Integer.parseInt(mScore.getText().toString()) + 10;
                    mScore.setText(String.valueOf(temp));
                    Toast.makeText(MainActivity.this, "Bạn đac chọn đúng. Bạn được cộng 10 điểm", Toast.LENGTH_SHORT).show();
                }
                else {
                    int temp = Integer.parseInt(mScore.getText().toString()) - 10;
                    mScore.setText(String.valueOf(temp));
                    Toast.makeText(MainActivity.this, "Bạn đac chọn sai. Bạn bị trừ 10 điểm", Toast.LENGTH_SHORT).show();
                }
                setRandom();
            }
        });
    }
}