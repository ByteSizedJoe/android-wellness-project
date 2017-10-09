package josephmedina.werkit;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

/**
 * Created by josephmedina on 5/10/17.
 */

public class Profile extends AppCompatActivity
{
    private static int CAMERA_REQUEST = 1888;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_layout);

        //Buttons
        Button saveButton = (Button) findViewById(R.id.pSaveButton);
        Button clearButton = (Button) findViewById(R.id.profileClearButton);
        Button goHome = (Button) findViewById(R.id.goHomeButton);
        ImageView profilePic = (ImageView) findViewById(R.id.profilePic);

        //EditTexts
        final EditText name = (EditText) findViewById(R.id.profileName);
        final EditText quote = (EditText) findViewById(R.id.quoteBox);
        final EditText bio = (EditText) findViewById(R.id.aboutMeBox);
        final EditText currWeight = (EditText) findViewById(R.id.weightInput);
        final EditText goalWeight = (EditText) findViewById(R.id.goalInput);

        //Handle profilePic action
        profilePic.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);
            }
        });


        //Handle save action
        saveButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

            }
        });

        //Handle clear action
        clearButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                name.setText("");
                quote.setText("");
                bio.setText("");
                currWeight.setText("");
                goalWeight.setText("");
            }
        });

        //Handle goHome action
        goHome.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                finish(); //todo temporary solution
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
            }
        });
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA_REQUEST) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            ImageView profilePic = (ImageView) findViewById(R.id.profilePic);
            profilePic.setImageBitmap(photo);
        }

    }

}
