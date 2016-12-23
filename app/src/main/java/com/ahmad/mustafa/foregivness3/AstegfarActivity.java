package com.ahmad.mustafa.foregivness3;

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
        //create Button to compute the Forgiveness and implement onClick Method.
        forgiveness_counter =
                (Button) findViewById(R.id.button_forgivenss_counter);
        forgiveness_counter.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                onCounterIncrease(view);
            }
        });
    }

    public void onCounterIncrease(View view)
    {
        counterInTextview = (TextView) findViewById(R.id.counter_textview);
        this.counter = this.counter + 1;
        counterInTextview.setText(this.counter+"");
    }

}
