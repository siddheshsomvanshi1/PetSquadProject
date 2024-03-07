package com.example.petsquad;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.ArrayList;

public class TreatmentRVAdapter extends RecyclerView.Adapter<TreatmentRVAdapter.ViewHolder>{

    private ArrayList<TreatmentModal> treatmentModalArrayList;
    private Context context;

    // constructor
    public TreatmentRVAdapter(ArrayList<TreatmentModal> treatmentModalArrayList, Context context) {
        this.treatmentModalArrayList = treatmentModalArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.treatment_rv_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TreatmentModal modal = treatmentModalArrayList.get(position);
        holder.treatmentNameTV.setText(modal.gettreatmentName());
        holder.treatmentDescTV.setText(modal.gettreatmentDescription());
        holder.treatmentCostTV.setText(modal.gettreatmentCost());
    }

    @Override
    public int getItemCount() {
        return treatmentModalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView treatmentNameTV, treatmentDescTV, treatmentCostTV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            treatmentNameTV = itemView.findViewById(R.id.idTVTreatmentName);
            treatmentDescTV = itemView.findViewById(R.id.idTVTreatmentDescription);
            treatmentCostTV = itemView.findViewById(R.id.idTVTreatmentCost);
        }
    }
}
