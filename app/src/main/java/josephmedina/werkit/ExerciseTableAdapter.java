package josephmedina.werkit;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by josephmedina on 5/10/17.
 */

public class ExerciseTableAdapter extends BaseAdapter
{
    //Package-private constant variables.
    static final String firstColumn="first";
    static final String secondColumn="second";
    static final String thirdColumn="third";

    ArrayList<HashMap<String,String>> exerciseList;
    Activity activity;
    TextView textFirst;
    TextView textSecond;
    TextView textThird;

    public ExerciseTableAdapter(Activity activity, ArrayList<HashMap<String,String>> exerciseList)
    {
        super();
        this.activity = activity;
        this.exerciseList = exerciseList;
    }

    @Override
    public int getCount()
    {
        return exerciseList.size();
    }

    @Override
    public Object getItem(int position)
    {
        return exerciseList.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return 0;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater=activity.getLayoutInflater();

        if(convertView == null){

            convertView=inflater.inflate(R.layout.exercise_table, null);

            textFirst = (TextView) convertView.findViewById(R.id.ctExerciseName);
            textSecond = (TextView) convertView.findViewById(R.id.ctSets);
            textThird = (TextView) convertView.findViewById(R.id.ctReps);
        }

        HashMap<String, String> map=exerciseList.get(position);
        textFirst.setText(map.get(firstColumn));
        textSecond.setText(map.get(secondColumn));
        textThird.setText(map.get(thirdColumn));

        return convertView;
    }


}
