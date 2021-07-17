package com.example.petutil;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Pets.class},version = 1,exportSchema = false)
public abstract class PetsDb extends RoomDatabase {

    static private PetsDb INSTANCE;
    static final ExecutorService exet = Executors.newFixedThreadPool(10);

    public abstract PetsDao petsDao();

    static PetsDb getInstance(Context context) {
        if(INSTANCE == null) {
            synchronized (Pets.class) {
                if(INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),PetsDb.class,"PetsDb")
                            .allowMainThreadQueries()
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }

        return INSTANCE;
    }
}
