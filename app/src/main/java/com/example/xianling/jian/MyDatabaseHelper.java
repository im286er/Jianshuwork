package com.example.xianling.jian;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by xianling on 2016/2/7.
 */
public class MyDatabaseHelper extends SQLiteOpenHelper {
    private static final String DBNAME="test.db";
    private static final String TABLENAME="jianshu";
    private static final int TESTVERSION=1;
    public MyDatabaseHelper(Context context) {
        super(context, DBNAME, null, TESTVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql="create table"+" "+TABLENAME+"(account varchar,password varchar)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(newVersion!=oldVersion)
        {
            String sql="drop table if exists"+TABLENAME;
            db.execSQL(sql);
            this.onCreate(db);
        }
    }
}
