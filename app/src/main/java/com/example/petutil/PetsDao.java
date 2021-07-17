package com.example.petutil;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface PetsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Pets pets);

    @Delete
    void delete(Pets pets);

    @Update
    void update(Pets pets);

    @Query("SELECT * FROM petsinfo ORDER BY name ASC")
    LiveData<List<Pets>> getAllPets();

    @Query("DELETE FROM petsinfo")
    void deleteAll();
}
