package com.example.imageview2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    int manghinhbai[] = {
            R.drawable.c1,R.drawable.c2,R.drawable.c3,R.drawable.c4,R.drawable.c5,
            R.drawable.c6,R.drawable.c7,R.drawable.c8,R.drawable.c9,R.drawable.c10,
            R.drawable.cj,R.drawable.cq,R.drawable.ck,
            R.drawable.d1,R.drawable.d2,R.drawable.d3,R.drawable.d4,R.drawable.d5,
            R.drawable.d6,R.drawable.d7,R.drawable.d8,R.drawable.d9,R.drawable.d10,
            R.drawable.dj,R.drawable.dq,R.drawable.dk,
            R.drawable.h1,R.drawable.h2,R.drawable.h3,R.drawable.h4,R.drawable.h5,
            R.drawable.h6,R.drawable.h7,R.drawable.h8,R.drawable.h9,R.drawable.h10,
            R.drawable.hj,R.drawable.hq,R.drawable.hk,
            R.drawable.s1,R.drawable.s2,R.drawable.s3,R.drawable.s4,R.drawable.s5,
            R.drawable.s6,R.drawable.s7,R.drawable.s8,R.drawable.s9,R.drawable.s10,
            R.drawable.sj,R.drawable.sq,R.drawable.sk};

    ImageView ivA1;
    ImageView ivA2;
    ImageView ivA3;

    ImageView ivB1;
    ImageView ivB2;
    ImageView ivB3;

    TextView tv_draw ;
    TextView tv_a ;
    TextView tv_b ;

    CountDownTimer Timer;
    CountDownTimer times;
    long time =0;
    TimePicker timePicker;
    int i =1 ;
    int draw= 0, a =0, b=0;

    private int tinhBaTay(int[] arr){
        int k=0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] % 13 >=10)
                k++;
        }
        return k;
    }

    private int random(int min, int max){
        return min+(int)(Math.random()*((max-min)+1));
    }

    private int[] laySauSoNgauNhien(int min, int max){
        int[] sauso = new int[6];
        int i =0;
        while (i<6){
            int k = random(min, max);
            if(kiemTraTrung(k, sauso))
                sauso[i++] = k;
        }
        return sauso;

    }

    private boolean kiemTraTrung(int k, int[] arr){
        for (int i=0; i < arr.length; i++){
            if(arr[i] == k)
                return false;
        }
        return true;
    }

    public int tong(int[] arr){
        int sum = 0;
        for (int i =0; i< arr.length; i++){
            if (arr[i] % 13 < 10)
                sum += arr[i]%13+1;
        }
        return sum;
    }

    public void starPlays(long time){
         Timer = new CountDownTimer(time, 5000) {
            public void onTick(long millisUntilFinished) {
                Toast.makeText(MainActivity.this, "Ván "+ i++ + " Bắt Đầu", Toast.LENGTH_SHORT).show();
                System.out.println("0");
                setManghinhbai();
            }

            public void onFinish() {
                tv_draw.setText("DRAW : 0");
                tv_a.setText("PLAYER A : 0");
                tv_b.setText("PLAYER B : 0");
                i=1;
                a =0;
                b= 0;
                draw = 0;
                timePicker.setHour(0);
                timePicker.setMinute(0);
                System.out.println("done");
            }
        }.start();
    }

    public void setManghinhbai(){

        int[] saulabai = laySauSoNgauNhien(0, 51);
        ivA1.setImageResource(manghinhbai[saulabai[0]]);
        ivA2.setImageResource(manghinhbai[saulabai[1]]);
        ivA3.setImageResource(manghinhbai[saulabai[2]]);
        ivB1.setImageResource(manghinhbai[saulabai[3]]);
        ivB2.setImageResource(manghinhbai[saulabai[4]]);
        ivB3.setImageResource(manghinhbai[saulabai[5]]);

        int[] arrA = Arrays.copyOfRange(saulabai, 0, 3);
        int[] arrB = Arrays.copyOfRange(saulabai, 3, 6);

        if(tinhBaTay(arrA) == 3 && tinhBaTay(arrB) == 3){
            tv_draw.setText("DRAW : "+ ++draw);
        } else if(tong(arrA)%10 == tong(arrB)%10){
            tv_draw.setText("DRAWN : "+ ++draw);
        } else if(tinhBaTay(arrA) == 3 && tinhBaTay(arrB) <3){
            tv_a.setText("PLAYER A : "+ ++a);
        }else if(tinhBaTay(arrB) == 3 && tinhBaTay(arrA) <3){
            tv_b.setText("PLAYER B : "+ ++b);
        }
        else if (tong(arrA)%10 > tong(arrB)%10){
            tv_a.setText("PLAYER A : "+ ++a);
        }else if (tong(arrA)%10 < tong(arrB)%10){
            tv_b.setText("PLAYER B : "+ ++b);
        }
    }

    public void setTime(long time){
        times = new CountDownTimer(time, 1000) {
            public void onTick(long millisUntilFinished) {
                if(timePicker.getMinute() != 0)
                    timePicker.setMinute(timePicker.getMinute()-1);
                else if(timePicker.getMinute() == 0){
                    timePicker.setMinute(59);
                    if (timePicker.getHour() != 0)
                        timePicker.setHour(timePicker.getHour()-1);
                }

            }

            public void onFinish() {

            }
        }.start();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timePicker = findViewById(R.id.id_timePicker);
        timePicker.setIs24HourView(true);
        timePicker.setHour(0);
        timePicker.setMinute(0);

        ivA1 = findViewById(R.id.imageViewA1);
        ivA2 = findViewById(R.id.imageViewA2);
        ivA3 = findViewById(R.id.imageViewA3);

        ivB1 = findViewById(R.id.imageViewB1);
        ivB2 = findViewById(R.id.imageViewB2);
        ivB3 = findViewById(R.id.imageViewB3);

        tv_draw = findViewById(R.id.id_draw);
        tv_a = findViewById(R.id.id_awin);
        tv_b = findViewById(R.id.id_bwin);

        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                time = ((hourOfDay*60)+minute)*1000;
            }
        });

        Button btnStar = findViewById(R.id.btn_Star);
        btnStar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                starPlays(time);
                setTime(time);
            }
        });

        Button btnCancel = findViewById(R.id.btn_Cancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Timer.cancel();
                tv_draw.setText("DRAW : 0");
                tv_a.setText("PLAYER A : 0");
                tv_b.setText("PLAYER B : 0");
                i=1;
                a =0;
                b= 0;
                draw = 0;
                timePicker.setHour(0);
                timePicker.setMinute(0);
                times.cancel();
            }
        });

    }
}