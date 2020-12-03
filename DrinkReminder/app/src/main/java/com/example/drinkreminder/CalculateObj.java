package com.example.drinkreminder;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.EditText;

import com.allyants.notifyme.NotifyMe;

import java.util.Calendar;

public class CalculateObj {

    public void setOzGoal(int ozGoal) {
        this.ozGoal = ozGoal;
    }

    int ozGoal;

    public void setNumRem(int numRem) {
        this.numRem = numRem;
    }

    int numRem;
    int ozToDrink;
    int minutesToMidnight;

    public void calculateTimes(Calendar now, Context context){
        Calendar midnight = Calendar.getInstance();
        midnight.set(Calendar.YEAR,Calendar.YEAR);
        midnight.set(Calendar.MONTH,Calendar.MONTH);
        midnight.set(Calendar.DAY_OF_MONTH,Calendar.DAY_OF_YEAR);
        midnight.set(Calendar.HOUR_OF_DAY,23);
        midnight.set(Calendar.MINUTE,59);
        midnight.set(Calendar.SECOND,59);
        midnight.add(Calendar.DAY_OF_MONTH, 1);

         Log.d("goal", Integer.toString(ozGoal));
        ozToDrink = ozGoal / numRem;
        minutesToMidnight /*ripChester*/ =
                midnight.get(Calendar.MINUTE) - now.get(Calendar.MINUTE) +
                        midnight.get(Calendar.HOUR_OF_DAY) * 60 - now.get(Calendar.HOUR_OF_DAY) * 60;
        Log.d("minutestomidnight" ,Integer.toString(minutesToMidnight));
        //Calendar timeset =
        for (int i=0; i<numRem; i++){

            int delay = (minutesToMidnight / numRem) *i;
            setNotification(delay, Integer.toString(ozToDrink),
                    context, now);
        }

    }
    public void setNotification(int delayMinutes,
                           String ozDiv, Context context, Calendar now) {


        Intent intent = new Intent(context,TestActivity.class);
        intent.putExtra("test","I am a String");
        NotifyMe notifyMe = new NotifyMe.Builder(context)
                .title("Keep Hydrated!")
                .content("Make sure to drink: " + ozDiv + "oz of Water!")
                .color(255,0,0,255)
                .led_color(255,255,255,255)
                .time(now)
                .delay(delayMinutes* 1000 * 60)
                .addAction(intent,"Snooze",false)
                .key("test")
                .addAction(new Intent(),"Dismiss",true,false)
                .addAction(intent,"Done")
                .large_icon(R.mipmap.ic_launcher_round)
                .rrule("FREQ=MINUTELY;INTERVAL=5;COUNT=2")
                .build();
    }
}
