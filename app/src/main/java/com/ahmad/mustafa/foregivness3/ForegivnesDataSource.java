package com.ahmad.mustafa.foregivness3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static com.ahmad.mustafa.foregivness3.ForegivnesDBHelper.COLUMN_TYPE_COUNTER;
import static com.ahmad.mustafa.foregivness3.ForegivnesDBHelper.COLUMN_TYPE_FOREGIVNES;
import static com.ahmad.mustafa.foregivness3.ForegivnesDBHelper.TABLE_FOREGIVNES;

/**
 * Created by ahmad on 01/03/17.
 */

public class ForegivnesDataSource {


    private ForegivnesDBHelper foregivnesDBHelper;
    private SQLiteDatabase sqLiteDatabase;
    String [] allColumn = {COLUMN_TYPE_FOREGIVNES , COLUMN_TYPE_COUNTER};

    public ForegivnesDataSource (Context context)
    {
        foregivnesDBHelper = ForegivnesDBHelper.getInstent(context);

    }

    public void open()
    {
        try {
            sqLiteDatabase = foregivnesDBHelper.getWritableDatabase();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void close()
    {
        sqLiteDatabase.close();
    }

    public void createForegivnes(String foregivnes , int count)
    {
        ContentValues list = new ContentValues();
        list.put(COLUMN_TYPE_FOREGIVNES , foregivnes);
        list.put(COLUMN_TYPE_COUNTER , count);
        sqLiteDatabase.insert(TABLE_FOREGIVNES , null , list);
    }

    public void deletForegivnes(int counter)
    {
        sqLiteDatabase.delete(TABLE_FOREGIVNES ,COLUMN_TYPE_COUNTER + " = " + counter, null);
    }

    public List<ForegfivnesMudel> getallForegfivnesMudels()
    {
        List<ForegfivnesMudel> mudels = new ArrayList<ForegfivnesMudel>();

        Cursor cursor = sqLiteDatabase.query(TABLE_FOREGIVNES
                ,allColumn
                ,null
                ,null
                ,null
                ,null
                ,null);
        cursor.moveToFirst();

        while ( !cursor.isAfterLast() )
        {
            ForegfivnesMudel mudel = new ForegfivnesMudel();
            mudel.setForgivnesType(cursor.getString(0));
            mudel.setCounterType(cursor.getInt(1));
            mudels.add(mudel);
            cursor.moveToNext();

        }

        cursor.close();
        return mudels;
    }

}
