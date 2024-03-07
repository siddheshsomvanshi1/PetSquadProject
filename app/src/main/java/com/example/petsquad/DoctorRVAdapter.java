package com.example.petsquad;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DoctorRVAdapter extends RecyclerView.Adapter<DoctorRVAdapter.ViewHolder>{

    private ArrayList<DoctorModal> doctorModalArrayList;
    private Context context;

    public DoctorRVAdapter(ArrayList<DoctorModal> doctorModalArrayList, Context context) {
        this.doctorModalArrayList = doctorModalArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public DoctorRVAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.doctor_rv_item, parent, false);
        return new DoctorRVAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DoctorRVAdapter.ViewHolder holder, int position) {
        DoctorModal modal = doctorModalArrayList.get(position);
        holder.doctorNameTV.setText(modal.getDoctorName());
        holder.doctorAgeTV.setText(modal.getDoctorAge());
        holder.doctorExperienceTV.setText(modal.getDoctorExperience());
    }

    @Override
    public int getItemCount() {
        return doctorModalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView doctorNameTV, doctorAgeTV, doctorExperienceTV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            doctorNameTV = itemView.findViewById(R.id.idTVDoctorName);
            doctorAgeTV = itemView.findViewById(R.id.idTVDoctorAge);
            doctorExperienceTV = itemView.findViewById(R.id.idTVDoctorExperience);
        }
    }


}
