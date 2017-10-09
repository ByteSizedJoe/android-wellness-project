package josephmedina.werkit;

import android.annotation.TargetApi;

import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by josephmedina on 5/10/17.
 */

public class Workout extends AppCompatActivity
{
    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.workout_layout);

        //Buttons
        Button goHome = (Button) findViewById(R.id.workoutGoHome);
        Button endButton = (Button) findViewById(R.id.endButton);

        //TextViews
        final TextView timeStarted = (TextView) findViewById(R.id.timeStarted);
        final TextView timeEnded = (TextView) findViewById(R.id.timeEnded);
        final TextView startTime = (TextView) findViewById(R.id.starttime);
        final TextView endTime = (TextView) findViewById(R.id.endtime);

        //Time Stuffs


        if(android.os.Build.VERSION.SDK_INT >= 24)
        {
            String myDate = java.text.DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());
            timeStarted.setText(myDate);
        }
        else
        {
            timeStarted.setText("");
            startTime.setText("Enjoy your workout!");
        }

        //Handle go home action
        goHome.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                finish();
            }
        });

        //Handle end action
        endButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //Moar Time Stuffs
                if(android.os.Build.VERSION.SDK_INT >= 24)
                {
                    String myDate = java.text.DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());
                    timeEnded.setText(myDate);
                    endTime.setText("Finished work out: ");
                }
                else
                {
                    timeEnded.setText("");
                    endTime.setText("Good job!");
                }

            }
        });

    }
}
