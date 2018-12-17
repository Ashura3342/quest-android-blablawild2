package fr.wildcodeschool.blablawild2;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class TripViewHolder extends RecyclerView.ViewHolder {

    private final TextView tvDeparture;
    private final TextView tvDestination;
    private final TextView tvDate;

    public TripViewHolder(@NonNull View itemView) {
        super(itemView);
        tvDeparture = itemView.findViewById(R.id.tv_departure);
        tvDestination = itemView.findViewById(R.id.tv_destination);
        tvDate = itemView.findViewById(R.id.tv_date);
    }

    public String getDeparture() {
        return tvDeparture.getText().toString();
    }

    public String getDestination() {
        return tvDestination.getText().toString();
    }

    public String getDate() {
        return tvDate.getText().toString();
    }

    public void setDeparture(String departure) {
        this.tvDeparture.setText(departure);
    }

    public void setDestination(String destination) {
        this.tvDestination.setText(destination);
    }

    public void setDate(String date) {
        this.tvDate.setText(date);
    }

    public void setTripModel(TripModel tripModel) {
        this.setDeparture(tripModel.getDeparture());
        this.setDestination(tripModel.getDestination());
        this.setDate(tripModel.getDate());
    }
}
