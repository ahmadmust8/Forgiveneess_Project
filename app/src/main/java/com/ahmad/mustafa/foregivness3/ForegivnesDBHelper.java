package com.ahmad.mustafa.foregivness3;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ahmad on 01/03/17.
 */

public class ForegivnesDBHelper extends SQLiteOpenHelper {

    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "foregivnesDB";
    public static final String TABLE_FOREGIVNES = "foregivness";

    public static final String COLUMN_TYPE_FOREGIVNES = "foregivnes";
    public static final String COLUMN_TYPE_COUNTER = "typeCounter";

    private static ForegivnesDBHelper foregivnesDBHelper;
    public ForegivnesDBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DB_NAME, factory, DB_VERSION);
    }

    private ForegivnesDBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    public static synchronized ForegivnesDBHelper getInstent(Context context)
    {
        if ( foregivnesDBHelper == null )
        {
            foregivnesDBHelper = new ForegivnesDBHelper(context);
        }
        return foregivnesDBHelper;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String CREATE_FOREGIVNES_TABLE = "CREATE TABLE " +
                TABLE_FOREGIVNES + "("
                + COLUMN_TYPE_FOREGIVNES + " TEXT," +
                COLUMN_TYPE_COUNTER +" INTEGER" + ")";
        sqLiteDatabase.execSQL(CREATE_FOREGIVNES_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_FOREGIVNES);
        onCreate(sqLiteDatabase);
    }
}
