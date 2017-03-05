package com.ahmad.mustafa.foregivness3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AstegfarActivity extends AppCompatActivity
{
    private Button forgiveness_counter;
    private TextView counterInTextview;
    private static int counter = 0;

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
            if ( bundle.getString("type") != null ) {
            typy = bundle.getString("type");

        } else if ( bundle.getString("editType") != null ) {
            typy = bundle.getString("editType");
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


    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        if ( savedInstanceState == null ) return;
        counter = savedInstanceState.getInt("key");
        counterInTextview = (TextView) findViewById(R.id.counter_textview);
        counterInTextview.setText(counter+"");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        counter = Integer.parseInt(counterInTextview.getText().toString());
        outState.putInt("key" , counter);
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
        this.counter = 0;
        finish();
    }


}
