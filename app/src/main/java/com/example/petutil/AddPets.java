package com.example.petutil;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddPets extends AppCompatActivity {

    private PetsViewModel pv;
    private Button bt;
    private EditText name;
    private EditText breed;
    private EditText weight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_pets);

        bt = findViewById(R.id.submit);
        name = findViewById(R.id.name);
        breed = findViewById(R.id.breed);
        weight = findViewById(R.id.weight);

        pv = new PetsViewModel(this.getApplication());

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pets pets = new Pets(name.getText().toString(),breed.getText().toString(),true,weight.getText().toString());
                pv.insert(pets);
                finish();
            }
        });
    }
}