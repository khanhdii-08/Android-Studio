package com.example.giaipt;

import java.text.DecimalFormat;

public class GiaiPT {

    private DecimalFormat decimalFormat = new DecimalFormat("#.##");

    public String ptb2 (double a, double b, double c)
    {
        String kq=null;
        if(a==0)
        {
            if(b==0)
            {
                if(c==0)
                    kq="Phương Trình Có Vô Số Nghiệm ";
                else
                    kq="Phương Trình Vô Nghiệm";
            }
            kq="Phương Trình Có Một Nghiệm = " + (-c/b);
        }
        else
        {
            double x1,x2, denta= Math.pow(b, 2)-4*a*c;
            if(denta<0)
                kq="Phương Trình Vô Nghiệm";
            else if(denta>0)
            {
                x1=(-b+Math.sqrt(denta))/(2*a);
                x2=(-b-Math.sqrt(denta))/(2*a);
                kq="x1 = " + (x1) + ", "+ "x2 = " + (x2);
            }
            else
                kq="Phương Trình Có Nghiệm Kép x = " + (-b/(2*a));
        }
        return kq;
    }


    public String ptb1 (double a, double b)
    {
        String kq=null;
        if (a == 0) {
            if (b == 0) {
                kq="Phương trình này có vô số nghiệm.";
            } else {
                kq="Phương trình vô nghiệm.";
            }
        } else {
            kq = "Phương trình có nghiệm x = " + decimalFormat.format(-b/a) + ".";
        }
        return kq;
    }



}
