package com.ahmad.mustafa.foregivness3;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import java.util.Calendar;
import java.util.List;




public class NewTypeForegivnss extends AppCompatActivity {

    private EditText newTypeEditText;
    ForegivnesDataSource foregivnesDataSource;
    private static int idStatic = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_type_foregivnss);
        idStatic++;

    }

    // this method well commit on new type of foregivness is create
    //and send String edit to AstegfarActivity and opens it .
    public void onCreateNewType(View view) {

        newTypeEditText = (EditText) findViewById(R.id.new_type_edittext);
        final String obj = newTypeEditText.getText().toString();

        isThereOne();
        if ( !newTypeEditText.getText().toString().isEmpty() )
        {
            foregivnesDataSource = new ForegivnesDataSource(getApplicationContext());
            foregivnesDataSource.open();
            foregivnesDataSource.createForegivnes(obj ,idStatic);
            foregivnesDataSource.close();
        }

        startActivity( new Intent(getApplicationContext() , AstegfarActivity.class).
                putExtra("editType" , newTypeEditText.getText().toString()) );
        finish();
    }

    public void remember(View view) {

        boolean checked = ((CheckBox) view).isChecked();

        if(!checked) return;

        newTypeEditText = (EditText) findViewById(R.id.new_type_edittext);
        final String obj = newTypeEditText.getText().toString();

        Calendar calendar = Calendar.getInstance();

        calendar.add(Calendar.HOUR , 1);


        Intent intent = new Intent( getApplicationContext() , NotificationRecever.class)
                .putExtra("editType" , newTypeEditText.getText().toString());


        PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext()
                ,100
                ,intent
                ,PendingIntent.FLAG_UPDATE_CURRENT);


        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP
                ,calendar.getTimeInMillis()
                ,AlarmManager.INTERVAL_HOUR
                ,pendingIntent);

    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


    public void isThereOne()
    {
        foregivnesDataSource = new ForegivnesDataSource(getApplicationContext());
        foregivnesDataSource.open();
        final List<ForegfivnesMudel> foregfivnesMudels =
                foregivnesDataSource.getallForegfivnesMudels();
        foregivnesDataSource.close();

        if ( foregfivnesMudels.size() < 0 ){
            idStatic = 1;
        }else {
           idStatic = foregfivnesMudels.size();
           idStatic++;
        }



    }

}
