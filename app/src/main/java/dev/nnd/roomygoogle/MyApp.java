package dev.nnd.roomygoogle;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.content.Context;

import dev.nnd.roomygoogle.db.AppDatabase;

/**
 * Room persistence lib <br>
 * New SQLite wrapper from Google <br>
 * https://developer.android.com/topic/libraries/architecture/room.html
 */

public class MyApp extends Application {
    static AppDatabase db;
    static Context context;

    public static AppDatabase getDb() {
        if (db == null) {
            db = Room.databaseBuilder(context, AppDatabase.class, "user-database").build();
        }
        return db;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        db = Room.databaseBuilder(getApplicationContext(),
                                  AppDatabase.class,
                                  "user-database"
        ).build();

        context = getApplicationContext();
    }
}
