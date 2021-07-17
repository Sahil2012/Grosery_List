package com.example.petutil;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class PetsRepo {

    private PetsDao petsDao;
    private LiveData<List<Pets>> arr;

    public PetsRepo(Application application) {
        this.petsDao = PetsDb.getInstance(application).petsDao();
        this.arr = petsDao.getAllPets();
    }


    public LiveData<List<Pets>> getArr() {
        return arr;
    }

    public void insert(Pets pets) {
        PetsDb.exet.execute(new Runnable() {
            @Override
            public void run() {
                petsDao.insert(pets);
            }
        });
    }

    public void delete(Pets pets) {
        PetsDb.exet.execute(new Runnable() {
            @Override
            public void run() {
                petsDao.delete(pets);
            }
        });
    }

    public void update(Pets pets) {
        PetsDb.exet.execute(new Runnable() {
            @Override
            public void run() {
                petsDao.update(pets);
            }
        });
    }

}
