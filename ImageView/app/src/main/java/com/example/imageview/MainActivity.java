package com.example.imageview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private int draw = 0, a =0, b=0;
    int manghinhbai[]={
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


    private String ketQua(int[] arr){
        String kq ="";
        if(tinhBaTay(arr) == 3)
            kq = "Kết quả 3 tây";
        else {
            int tong =0;
            for(int i=0; i< arr.length; i++){
                if(arr[i] % 13 <10)
                    tong += arr[i]%13 +1;
            }
            if(tong % 10 ==0){
                kq = "Kết quả bù, số tây là " + tinhBaTay(arr);
            }else
                kq = "Kết quả là " + (tong % 10)+ " nút, số tây là " + tinhBaTay(arr);
        }
        return kq;
    }

    private int random(int min, int max){
        return min+(int)(Math.random()*((max-min)+1));
    }

    private int[] laySauSoNgauNhien(int min, int max){
        int[] baso = new int[6];
        int i =0;
        while (i<6){
            int k = random(min, max);
            if(kiemTraTrung(k, baso))
                baso[i++] = k;
        }
        return baso;

    }

    private boolean kiemTraTrung(int k, int[] arr){
        for (int i=0; i < arr.length; i++){
            if(arr[i] == k)
                return false;
        }
        return true;
    }

    private int tinhBaTay(int[] arr){
        int k=0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] % 13 >=10)
                k++;
        }
        return k;
    }

    public int tong(int[] arr){
        int sum = 0;
        for (int i =0; i< arr.length; i++){
            if (arr[i] % 13 < 10)
                sum += arr[i]%13+1;
        }
        return sum;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView ivA1 = findViewById(R.id.imageViewA1);
        ImageView ivA2 = findViewById(R.id.imageViewA2);
        ImageView ivA3 = findViewById(R.id.imageViewA3);

        ImageView ivB1 = findViewById(R.id.imageViewB1);
        ImageView ivB2 = findViewById(R.id.imageViewB2);
        ImageView ivB3 = findViewById(R.id.imageViewB3);

        Button btn_RutBai = findViewById(R.id.btn_rutlabai);

        TextView tv_draw = findViewById(R.id.id_draw);
        TextView tv_a = findViewById(R.id.id_awin);
        TextView tv_b = findViewById(R.id.id_bwin);

        TextView ab = findViewById(R.id.a);
        TextView ba = findViewById(R.id.b);
        TextView test = findViewById(R.id.test);

        btn_RutBai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int[] balabai = laySauSoNgauNhien(0, 51);
                ivA1.setImageResource(manghinhbai[balabai[0]]);
                ivA2.setImageResource(manghinhbai[balabai[1]]);
                ivA3.setImageResource(manghinhbai[balabai[2]]);
                ivB1.setImageResource(manghinhbai[balabai[3]]);
                ivB2.setImageResource(manghinhbai[balabai[4]]);
                ivB3.setImageResource(manghinhbai[balabai[5]]);

                int[] arrA = Arrays.copyOfRange(balabai, 0, 3);
                int[] arrB = Arrays.copyOfRange(balabai, 3, 6);

                if(tinhBaTay(arrA) == 3 && tinhBaTay(arrB) == 3){
                    draw++;
                } else if(tong(arrA)%10 == tong(arrB)%10){
                    draw++;
                } else if(tinhBaTay(arrA) == 3 && tinhBaTay(arrB) <3){
                    a++;
                }else if(tinhBaTay(arrB) == 3 && tinhBaTay(arrA) <3){
                    b++;
                }
                else if (tong(arrA)%10 > tong(arrB)%10){
                    a++;
                }else if (tong(arrA)%10 < tong(arrB)%10){
                    b++;
                }


                tv_draw.setText("DRAW : "+draw);
                tv_a.setText("PLAYER A WIN: "+a);
                tv_b.setText("PLAYER B WIN: "+b);

            }
        });

    }
}