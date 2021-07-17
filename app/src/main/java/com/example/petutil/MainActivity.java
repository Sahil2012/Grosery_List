package com.example.petutil;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements EditInter {

    private FloatingActionButton bt;
    private PetsViewModel pv;
    LiveData<List<Pets>> arr;
    private RecyclerView rv;
    private PetsAdapter pa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bt = findViewById(R.id.add);

        rv = findViewById(R.id.revew);
        rv.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        pa = new PetsAdapter(this,MainActivity.this);
        rv.setAdapter(pa);

        pv = new PetsViewModel(getApplication());
        pv.getAllPets().observe(this,petsList -> {
            pa.upData(petsList);
        });

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this,AddPets.class);
                startActivity(it);
            }
        });
    }

    @Override
    public void onEditInter() {

        Intent it  = new Intent(this,EditPets.class);
        startActivity(it);
    }
}