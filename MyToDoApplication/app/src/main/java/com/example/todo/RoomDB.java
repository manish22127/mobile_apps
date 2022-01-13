package com.example.todo;

//add database entities
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import android.content.Context;

@Database(entities = {MainData.class},version = 1,exportSchema = false)

public abstract class RoomDB extends RoomDatabase {
    private static RoomDB databse;
    private static String DATABASE_NAME="database";
    public  synchronized static RoomDB getInstance(Context context) {
        if (databse == null) {
            databse = Room.databaseBuilder(context.getApplicationContext(), RoomDB.class, DATABASE_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return databse;
    }
    public abstract MainDao mainDao();

}
