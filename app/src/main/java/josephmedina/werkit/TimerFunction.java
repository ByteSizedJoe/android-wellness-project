package josephmedina.werkit;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

/**
 * Created by josephmedina on 5/10/17.
 */

public class TimerFunction extends AppCompatActivity
{
    long timeWhenStopped = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timer_layout);

        //Buttons
        Button start = (Button) findViewById(R.id.startTimeButton);
        Button reset = (Button) findViewById(R.id.resetTimeButton);
        Button goHome = (Button) findViewById(R.id.goHomeButton);

        final Chronometer timeElapsed  = (Chronometer) findViewById(R.id.chronometer);

        timeElapsed.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener()
        {
            @Override
            public void onChronometerTick(Chronometer cArg)
            {
                long time = SystemClock.elapsedRealtime() - cArg.getBase();
                int h   = (int)(time /3600000);
                int m = (int)(time - h*3600000)/60000;
                int s= (int)(time - h*3600000- m*60000)/1000 ;
                String hh = h < 10 ? "0"+h: h+"";
                String mm = m < 10 ? "0"+m: m+"";
                String ss = s < 10 ? "0"+s: s+"";
                cArg.setText(hh+":"+mm+":"+ss);
            }
        });

        //Handle the start action
        start.setOnClickListener(new View.OnClickListener()
        {
            private boolean state = true;
            @Override
            public void onClick(View v)
            {
                if(state)
                {
                    timeElapsed.setBase(SystemClock.elapsedRealtime() + timeWhenStopped);
                    state = false;
                    timeElapsed.start();

                }
                else
                {
                    state = true;
                    timeElapsed.stop();
                    timeWhenStopped = timeElapsed.getBase() - SystemClock.elapsedRealtime();
                }
            }
        });

        //Handle the reset action
        reset.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                timeElapsed.stop();
                timeElapsed.setBase(SystemClock.elapsedRealtime());
                timeWhenStopped = 0;
            }
        });

        //Handle the go home action
        goHome.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                finish();//todo temp solution.
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
            }
        });

    }


}
