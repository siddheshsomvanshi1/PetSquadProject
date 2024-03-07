package com.example.petsquad;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class OwnerRVAdapter extends RecyclerView.Adapter<OwnerRVAdapter.ViewHolder>{

    private ArrayList<OwnerModal> ownerModalArrayList;
    private Context context;

    public OwnerRVAdapter(ArrayList<OwnerModal> ownerModalArrayList, Context context) {
        this.ownerModalArrayList = ownerModalArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public OwnerRVAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.owner_rv_item, parent, false);
        return new OwnerRVAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OwnerRVAdapter.ViewHolder holder, int position) {

        OwnerModal modal = ownerModalArrayList.get(position);
        holder.ownerName.setText(modal.getOwnerName());
        holder.ownerEmail.setText(modal.getOwnerEmail());


    }

    @Override
    public int getItemCount() {
        return ownerModalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView ownerName, ownerEmail;

        public ViewHolder(View view) {
            super(view);
            ownerName = itemView.findViewById(R.id.idTVownerName);
            ownerEmail = itemView.findViewById(R.id.idTVownerEmail);

        }
    }


}
