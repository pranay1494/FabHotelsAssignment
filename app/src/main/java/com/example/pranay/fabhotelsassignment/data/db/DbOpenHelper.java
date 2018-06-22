package com.example.pranay.fabhotelsassignment.data.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.pranay.fabhotelsassignment.data.db.model.DaoMaster;
import com.example.pranay.fabhotelsassignment.injection.ApplicationContext;
import com.example.pranay.fabhotelsassignment.injection.DatabaseInfo;

import org.greenrobot.greendao.database.Database;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by pranay on 22/06/18.
 */

public class DbOpenHelper extends DaoMaster.OpenHelper {
    @Inject
    public DbOpenHelper(@ApplicationContext Context context, @DatabaseInfo String name) {
        super(context, name);
    }

    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
        super.onUpgrade(db, oldVersion, newVersion);
        switch (oldVersion) {
            case 1:
            case 2:
                //db.execSQL("ALTER TABLE " + UserDao.TABLENAME + " ADD COLUMN "
                // + UserDao.Properties.Name.columnName + " TEXT DEFAULT 'DEFAULT_VAL'");
        }
    }
}
