package com.example.petsquad;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DoctorScheduleRVAdapter extends RecyclerView.Adapter<DoctorScheduleRVAdapter.ViewHolder> {

    private ArrayList<DoctorScheduleModal> doctorscheduleModalArrayList;
    private Context context;

    public DoctorScheduleRVAdapter(ArrayList<DoctorScheduleModal> doctorscheduleModalArrayList, Context context) {
        this.doctorscheduleModalArrayList = doctorscheduleModalArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dschedule_rv_item, parent, false);
        return new DoctorScheduleRVAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DoctorScheduleModal modal = doctorscheduleModalArrayList.get(position);
        holder.day.setText(modal.getDay());
        holder.opentime.setText(modal.getStarttime());
        holder.closetime.setText(modal.getClosetime());
    }

    @Override
    public int getItemCount() {
        return doctorscheduleModalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView day, opentime, closetime;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            day = itemView.findViewById(R.id.idTVday);
            opentime = itemView.findViewById(R.id.idTVopentime);
            closetime = itemView.findViewById(R.id.idTVclosetime);
        }
    }
}
