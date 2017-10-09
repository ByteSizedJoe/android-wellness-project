package josephmedina.werkit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{
    private int fragmentNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButton();
    }
    public void addListenerOnButton()
    {
        //Buttons
        Button createWorkoutButton = (Button) findViewById(R.id.createbutton);
        Button timerButton = (Button) findViewById(R.id.chronometerbutton);
        Button profileButton = (Button) findViewById(R.id.profilebutton);
        Button logButton = (Button) findViewById(R.id.logbutton);

        //Handle create button action
        createWorkoutButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent createScreen = new Intent(getApplicationContext(), CreateWorkoutView.class);
                startActivity(createScreen);
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
            }
        });

        //Handle timer button action
        timerButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent createScreen = new Intent(getApplicationContext(), TimerFunction.class);
                startActivity(createScreen);
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
            }
        });

        //Handle profile button action
        profileButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent createScreen = new Intent(getApplicationContext(), Profile.class);
                startActivity(createScreen);
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
            }
        });

        //Handle log button action
        logButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent createScreen = new Intent(getApplicationContext(), LogWorkout.class);
                startActivity(createScreen);
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);

            }
        });

    }
}
