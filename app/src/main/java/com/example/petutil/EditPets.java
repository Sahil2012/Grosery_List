package com.example.petutil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditPets extends AppCompatActivity {

    private EditText breed;
    private EditText weight;
    private Button submit;
    private Button back;
    private PetsViewModel pv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_pets);

        SharedPreferences sharedPreferences = getApplication().getSharedPreferences("PetsFile",MODE_PRIVATE);

        pv = new PetsViewModel(getApplication());

        breed = findViewById(R.id.EditBreed);
        weight = findViewById(R.id.Editweight);

        String name = sharedPreferences.getString("name","Not Found");
        breed.setText(sharedPreferences.getString("breed","Not Found"));
        weight.setText(sharedPreferences.getString("weight","Not Found"));


        submit = findViewById(R.id.edit);
        back = findViewById(R.id.Delete);
        Pets pets = new Pets(name,breed.getText().toString(),true,weight.getText().toString());

        back.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        pv.delete(pets);
                        Toast.makeText(EditPets.this, "Item Deleted", Toast.LENGTH_SHORT).show();

                        finish();
                    }
                }
        );

        submit.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Pets pet = new Pets(name,breed.getText().toString(),true,weight.getText().toString());
                        pv.update(pet);
                        Toast.makeText(EditPets.this,"Item Updated",Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }
        );
    }
}