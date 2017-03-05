package com.ahmad.mustafa.foregivness3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AddNewFrogivnes2 extends AppCompatActivity
{

    // all types of forgivness buttons
    private Button forgivnes1;
    private Button forgivnes2;
    private Button forgivnes3;
    private Button forgivnes4;

    // maybe needs this object later ?
    private Button newforgivnes;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_frogivnes2);

        // initials the buttons
        forgivnes1 = (Button)findViewById(R.id.forgivnes_1);
        forgivnes2 = (Button)findViewById(R.id.forgivnes_2);
        forgivnes3 = (Button)findViewById(R.id.forgivnes_3);
        forgivnes4 = (Button)findViewById(R.id.forgivnes_4);

    }

    // on any button of forgivnees is  clicked & choose which button is clicked
    // & put it's name to Intent object & start
    public void onClickForgivnessType(View view)
    {
        int id = view.getId();
        switch (id)
        {
            case R.id.forgivnes_1:
                startActivity(new Intent(getApplicationContext() , AstegfarActivity.class).
                        putExtra( "type" , forgivnes1.getText().toString()));
                break;

            case R.id.forgivnes_2:
                startActivity(new Intent(getApplicationContext() , AstegfarActivity.class).
                        putExtra( "type" , forgivnes2.getText().toString()));
                break;

            case R.id.forgivnes_3:
                startActivity(new Intent(getApplicationContext() , AstegfarActivity.class).
                        putExtra( "type" , forgivnes3.getText().toString()));
                break;

            case R.id.forgivnes_4:
                startActivity(new Intent(getApplicationContext() , AstegfarActivity.class).
                        putExtra("type" , forgivnes4.getText().toString()));
                break;

            default:

        }

        finish();
    }




    // on Click on the new type Button this method well commit.
    public void newTypeClick(View view) {

        startActivity(new Intent(getApplicationContext() , NewTypeForegivnss.class));
        finish();
    }
}
