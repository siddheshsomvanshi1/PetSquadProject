package com.example.petsquad;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DoctorAppointmentRVAdapter extends RecyclerView.Adapter<DoctorAppointmentRVAdapter.ViewHolder>{

    private ArrayList<DoctorAppointmentModal> doctorAppointmentModalArrayList;
    private Context context;

    public DoctorAppointmentRVAdapter(ArrayList<DoctorAppointmentModal> doctorAppointmentModalArrayList, Context context) {
        this.doctorAppointmentModalArrayList = doctorAppointmentModalArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.doctor_appointment_rv_item, parent, false);
        return new DoctorAppointmentRVAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DoctorAppointmentRVAdapter.ViewHolder holder, int position) {

        DoctorAppointmentModal modal = doctorAppointmentModalArrayList.get(position);
        holder.DateTV.setText(modal.getAppointDate());
        holder.TimeTV.setText(modal.getAppointTime());
        holder.petNameTV.setText(modal.getPetName());

    }

    @Override
    public int getItemCount() {
        return doctorAppointmentModalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView DateTV, TimeTV, petNameTV;

        public ViewHolder(View view) {
            super(view);
            DateTV = itemView.findViewById(R.id.idTVDate);
            TimeTV = itemView.findViewById(R.id.idTVTime);
            petNameTV=itemView.findViewById(R.id.idTVDApetName);
        }
    }
}
