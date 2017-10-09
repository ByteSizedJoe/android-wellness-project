package josephmedina.werkit;

import static josephmedina.werkit.ExerciseTableAdapter.firstColumn;
import static josephmedina.werkit.ExerciseTableAdapter.secondColumn;
import static josephmedina.werkit.ExerciseTableAdapter.thirdColumn;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by josephmedina on 5/9/17.
 */

public class CreateWorkoutView extends AppCompatActivity
{
    //ArrayList to be populated with our EditTexts
    private ArrayList<HashMap<String,String>> workout;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.createwo_view);

        workout = new ArrayList<>();

        //Our exercise list and adapter
        final ListView exerciseListView = (ListView) findViewById(R.id.exerciseList);
        final ExerciseTableAdapter ETAdapter = new ExerciseTableAdapter(this, workout);
        exerciseListView.setAdapter(ETAdapter);

        //Buttons
        final Button addExercise = (Button) findViewById(R.id.addButton);
        Button saveButton = (Button) findViewById(R.id.ctSave);
        Button clearButton = (Button) findViewById(R.id.clearButton);
        Button goHomeButton = (Button) findViewById(R.id.cgoHome);

        //EditTexts
        final EditText workoutName = (EditText) findViewById(R.id.c_workoutNameInput);
        final EditText exerciseName = (EditText) findViewById(R.id.c_exerciseInput);
        final EditText setsInput = (EditText) findViewById(R.id.c_setInput);
        final EditText repsInput = (EditText) findViewById(R.id.c_repInput);

        //TextView
        final TextView workoutTitle = (TextView) findViewById(R.id.workoutTitle);


        //Save stuffs
        final SharedPreferences database = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        final SharedPreferences.Editor collection = database.edit();
        final Gson gson = new Gson();

        //Load stuffs
        initializeTable(database);

        //Add exercise action handled here.
        addExercise.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                HashMap<String,String> tempVar = new HashMap<>();
                tempVar.put(firstColumn, exerciseName.getText().toString());
                tempVar.put(secondColumn, setsInput.getText().toString());
                tempVar.put(thirdColumn, repsInput.getText().toString());
                workout.add(tempVar);
                exerciseListView.setAdapter(ETAdapter);
                workoutTitle.setText(workoutName.getText().toString());
            }
        });

        //Save workout action handled here.
        saveButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String keyTitle = "Workout";
                String keyExercises = "Exercises";

                ArrayList<String> workoutTitles = new ArrayList<>();
                workoutTitles.add(workoutName.getText().toString());

                String saveTitleArray = gson.toJson(workoutTitles);
                String saveArray = gson.toJson(workout);
                collection.putString(keyTitle, saveTitleArray);
                collection.putString(keyExercises, saveArray);
                collection.commit();

                if(database.contains(keyTitle) && database.contains(keyExercises))
                {
                    Toast.makeText(getApplicationContext(), "Workout saved!", Toast.LENGTH_LONG).show();
                }
            }
        });

        //Clear action handled here.
        clearButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                workoutTitle.setText("Workout");
                workout.clear();
                exerciseListView.setAdapter(ETAdapter);
            }
        });

        //Go home action handled here.
        goHomeButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                finish();
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
            }
        });
    }

    public void initializeTable(SharedPreferences database)
    {
        HashMap<String, String> temp = new HashMap<>();
        temp.put(firstColumn, "Exercise");
        temp.put(secondColumn, "Sets");
        temp.put(thirdColumn, "Reps");
        workout.add(temp);

        if(database.contains("Workout"))
        {
            SharedPreferences db=PreferenceManager.getDefaultSharedPreferences(this);

            Gson gson = new Gson();
            String arrayListString = db.getString("Workout", null);
            System.out.println(arrayListString);//Debugging purposes...

            /*
            Type type = new TypeToken<ArrayList<HashMap<String, String>>>() {}.getType();
            ArrayList<HashMap<String,String>> arrayList = gson.fromJson(arrayListString, type);
            ExerciseTableAdapter newETAdapter = new ExerciseTableAdapter(this, arrayList);
            ListView newExerciseListView = (ListView) findViewById(R.id.exerciseList);
            newExerciseListView.setAdapter(newETAdapter);
            */

            Toast.makeText(getApplicationContext(),"Loaded saved info ;)", Toast.LENGTH_LONG).show();
        }
    }

}
