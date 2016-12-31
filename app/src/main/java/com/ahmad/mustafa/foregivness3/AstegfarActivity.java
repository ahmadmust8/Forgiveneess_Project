package com.ahmad.mustafa.foregivness3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AstegfarActivity extends AppCompatActivity
{
    Button forgiveness_counter;
    TextView counterInTextview;
    public int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_astegfar);

        //extract Intent data from Bundle object
        Bundle bundle = getIntent().getExtras();
        String typy = "";

        // to avoid breakdown
        if (bundle != null)
        {
            typy = bundle.getString("type");
        }

        //create Button to compute the Forgiveness and implement onClick Method.
        forgiveness_counter =
                (Button) findViewById(R.id.button_forgivenss_counter);
        forgiveness_counter.setText(typy);
        forgiveness_counter.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                counterIncrease(view);
            }
        });
    }

    // on forgiveness_counter button clicked it's well be increase the counter 1
    public void counterIncrease(View view)
    {
        counterInTextview = (TextView) findViewById(R.id.counter_textview);
        this.counter = this.counter + 1;
        counterInTextview.setText(this.counter+"");
    }

    // to kill this Activity after pressed on back button
    @Override
    public void onBackPressed()
    {
        finish();
    }
}
