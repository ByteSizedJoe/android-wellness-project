package josephmedina.werkit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by josephmedina on 5/10/17.
 */

public class LogWorkout extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_layout);

        //Button
        Button goHome = (Button) findViewById(R.id.logGoHome);

        //Handle go home action
        goHome.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //finish();
                //overridePendingTransition(R.anim.fadein, R.anim.fadeout);

                //Temp work to access workout class
                Intent createScreen = new Intent(getApplicationContext(), Workout.class);
                startActivity(createScreen);
            }
        });
    }
}
