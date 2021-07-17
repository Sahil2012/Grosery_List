package com.example.petutil;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class PetsViewModel extends AndroidViewModel {

    private PetsRepo pr;

    public PetsViewModel(@NonNull Application application) {
        super(application);
        pr = new PetsRepo(application);
    }

    void insert(Pets pets) {
        pr.insert(pets);
    }

    void delete(Pets pets) {
        pr.delete(pets);
    }

    void update(Pets pets) {
        pr.update(pets);
    }

    LiveData<List<Pets>> getAllPets() {
        return pr.getArr();
    }
}
