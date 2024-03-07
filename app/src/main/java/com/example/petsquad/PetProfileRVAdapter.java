package com.example.petsquad;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PetProfileRVAdapter extends RecyclerView.Adapter<PetProfileRVAdapter.ViewHolder>{

    private ArrayList<PetProfileModal> petProfileModalArrayList;
    private Context context;

    public PetProfileRVAdapter(ArrayList<PetProfileModal> petProfileModalArrayList, Context context) {
        this.petProfileModalArrayList = petProfileModalArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public PetProfileRVAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pet_profile_rv_item, parent, false);
        return new PetProfileRVAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PetProfileRVAdapter.ViewHolder holder, int position) {

        PetProfileModal modal = petProfileModalArrayList.get(position);
        holder.petName.setText(modal.getPetName());
        holder.petAge.setText(modal.getPetAge());
        holder.petBreed.setText(modal.getPetBreed());

    }

    @Override
    public int getItemCount() {
        return petProfileModalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView petName, petAge, petBreed;

        public ViewHolder(View view) {
            super(view);
            petName = itemView.findViewById(R.id.idTVpetName);
            petAge = itemView.findViewById(R.id.idTVpetAge);
            petBreed=itemView.findViewById(R.id.idTVpetBreed);
        }
    }


}
