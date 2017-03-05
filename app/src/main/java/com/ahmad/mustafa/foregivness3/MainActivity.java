package com.ahmad.mustafa.foregivness3;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

import static android.R.attr.id;
import static com.ahmad.mustafa.foregivness3.R.id.fab;

public class MainActivity extends AppCompatActivity
{

    ListView forgivneesListView ;
    ForegivnesDataSource foregivnesDataSource;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        forgivneesListView =(ListView)findViewById(R.id.list_view);
        foregivnesDataSource = new ForegivnesDataSource(getApplicationContext());
        foregivnesDataSource.open();
             final List<ForegfivnesMudel> foregfivnesMudels =
                    foregivnesDataSource.getallForegfivnesMudels();
            foregivnesDataSource.close();



        int [] forgivnesess = new int[foregfivnesMudels.size()];
        for ( int i = 0 ; i < foregfivnesMudels.size() ; i++ )
        {
            forgivnesess[i] = foregfivnesMudels.get(i).getCounterType();
        }

        final ForegivnesAdapter adapter = new ForegivnesAdapter(getApplicationContext()
                ,foregfivnesMudels);

        forgivneesListView.setAdapter(adapter);
        forgivneesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, final int pos, long l) {
                foregivnesDataSource.open();
                List<ForegfivnesMudel> foregfivnesMudels1 =
                        foregivnesDataSource.getallForegfivnesMudels();
                foregivnesDataSource.close();
                startActivity(new Intent(getApplicationContext() , AstegfarActivity.class)
                        .putExtra("type",foregfivnesMudels1.get(pos).getForgivnesType()));
            }
        });

        forgivneesListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int pos, long l) {

                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Select Your option")
                        .setMessage("Delete or Cancel")
                        .setPositiveButton("Delete",new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                foregivnesDataSource.open();
                                List<ForegfivnesMudel> foregfivnesMudels1 =
                                        foregivnesDataSource.getallForegfivnesMudels();
                                foregivnesDataSource.deletForegivnes(
                                        foregfivnesMudels1.get(pos).getCounterType());
                                foregivnesDataSource.close();
                                onRestart();
                                Toast.makeText(getApplicationContext(),"Done",Toast.LENGTH_LONG).show();
                            }
                        })
                        .setNegativeButton("Cancel",new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })
                        .show();

                return true ;
            }
        });


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //open new Activity
                startActivity( new Intent(getApplicationContext() , AddNewFrogivnes2.class));

                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                  //      .setAction("Action", null).show();
            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        forgivneesListView =(ListView)findViewById(R.id.list_view);
        foregivnesDataSource = new ForegivnesDataSource(getApplicationContext());
        foregivnesDataSource.open();
        final List<ForegfivnesMudel> foregfivnesMudels =
                foregivnesDataSource.getallForegfivnesMudels();
        foregivnesDataSource.close();

        final ForegivnesAdapter adapter = new ForegivnesAdapter(getApplicationContext()
                ,foregfivnesMudels);

        forgivneesListView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
