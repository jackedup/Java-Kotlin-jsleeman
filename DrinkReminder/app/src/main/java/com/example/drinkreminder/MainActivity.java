package com.example.drinkreminder;

import androidx.appcompat.app.AppCompatActivity;

    import android.content.Intent;
        import android.os.Bundle;
import android.util.Log;
import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import com.allyants.notifyme.NotifyMe;
        import java.util.Calendar;

public class MainActivity extends AppCompatActivity{
    EditText etTitle,etContent, etGoal,etReminders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnNotify = findViewById(R.id.btnNotify);
        etGoal = findViewById(R.id.ozGoal);
        etReminders = findViewById(R.id.RemindersPer);
        final CalculateObj calcObj = new CalculateObj();


        btnNotify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar now = Calendar.getInstance();
                calcObj.setNumRem(Integer.parseInt(etReminders.getText().toString()));
                calcObj.setOzGoal(Integer.parseInt(etGoal.getText().toString()));
                calcObj.calculateTimes(now, getApplicationContext());

            }

        });
    }



}