package com.theoaktroop.androditimeduration;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import javax.xml.datatype.Duration;

public class MainActivity extends AppCompatActivity {
    private TextView et;
    private long d1=0,d2=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et=(TextView)findViewById(R.id.etv);
    }
    public void sTart(View view)
    {
        d1=System.currentTimeMillis();
    }
    public void fIni(View view)
    {
        d2=System.currentTimeMillis();
        long diff=Math.max(d2 ,d1)-Math.min(d2, d1);
        long diffSeconds = diff / 1000 % 60;
        long diffMinutes = diff / (60 * 1000) % 60;
        long diffHours = diff / (60 * 60 * 1000) % 24;
        long diffDays = diff / (24 * 60 * 60 * 1000);
        System.out.print(diffDays + " days, ");
        System.out.print(diffHours + " hours, ");
        System.out.print(diffMinutes + " minutes, ");
        System.out.print(diffSeconds + " seconds.\n");
        String timeString=formatDuration(diffHours,diffMinutes,diffSeconds);
        et.setText(timeString);
         diff=timeDuration(timeString);
         diffSeconds = diff / 1000 % 60;
         diffMinutes = diff / (60 * 1000) % 60;
         diffHours = diff / (60 * 60 * 1000) % 24;
         diffDays = diff / (24 * 60 * 60 * 1000);
        System.out.print(diffDays + " days, ");
        System.out.print(diffHours + " hours, ");
        System.out.print(diffMinutes + " minutes, ");
        System.out.print(diffSeconds + " seconds.\n");



    }

    public static String formatDuration(long diffHours,long diffMinutes,long diffSeconds) {

        String positive = String.format(
                "%d:%02d:%02d",
                diffHours, diffMinutes,
                diffSeconds);
        return  positive;
    }
    public static long timeDuration(String timeStirng)
    {

        String sHour=""+timeStirng.charAt(0);
        String sMinutes=""+timeStirng.charAt(2)+timeStirng.charAt(3);
        String sSeconds=""+timeStirng.charAt(5)+timeStirng.charAt(6);
        long durationInMillisecond=Long.parseLong(sHour)*60*60*1000+Long.parseLong(sMinutes)*60*1000+Long.parseLong(sSeconds)*1000;
    return durationInMillisecond;
    }
}
