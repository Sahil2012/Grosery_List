package com.example.petutil;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;

public class PetsAdapter extends RecyclerView.Adapter<ViewHold>{

    private List<Pets> arr = new ArrayList<>();
    private Context context;
    private EditInter li;
    SharedPreferences sharedPreferences;

    public PetsAdapter(Context context,EditInter li) {

        this.li = li;
        this.context = context;
        sharedPreferences = context.getSharedPreferences("PetsFile",MODE_PRIVATE);
    }

    @NonNull
    @Override
    public ViewHold onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.pets_layout,parent,false);
        return new ViewHold(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHold holder, int position) {
        holder.getName().setText(arr.get(position).getName());
        holder.getBreed().setText(arr.get(position).getBreed());
        holder.getWeight().setText(arr.get(position).getWeight());

        holder.getEditBut().setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SharedPreferences.Editor editor = sharedPreferences.edit();

                        editor.putString("name",arr.get(position).getName());
                        editor.putString("breed",arr.get(position).getBreed());
                        editor.putString("weight",arr.get(position).getWeight());
                        editor.apply();

                        li.onEditInter();
                    }
                }
        );
    }

    @Override
    public int getItemCount() {
        return arr.size();
    }

    public void upData(List<Pets> arr) {
        this.arr = arr;
        notifyDataSetChanged();
    }
}

class ViewHold extends RecyclerView.ViewHolder {

    private TextView breed;
    private LinearLayout editBut;
    private TextView name;
    private TextView weight;

    public ViewHold(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.nameHold);
        breed = itemView.findViewById(R.id.breedHold);
        editBut = itemView.findViewById(R.id.goToEdit);
        weight = itemView.findViewById(R.id.quan);
    }

    public TextView getName() {
        return name;
    }

    public TextView getBreed() {
        return breed;
    }

    public LinearLayout getEditBut() {
        return editBut;
    }

    public TextView getWeight() {
        return weight;
    }
}

interface EditInter {
    void onEditInter();
}