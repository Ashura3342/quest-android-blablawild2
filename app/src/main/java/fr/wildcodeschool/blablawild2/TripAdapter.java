package fr.wildcodeschool.blablawild2;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by bastienwcs on 15/04/18.
 */
public class TripAdapter extends RecyclerView.Adapter<TripViewHolder> {

    private List<TripModel> objects;

    public TripAdapter(@NonNull List<TripModel> objects) {
        this.objects = objects;
    }

    @NonNull
    @Override
    public TripViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        return new TripViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_trip, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull TripViewHolder tripViewHolder, int i) {
        TripModel tripModel = objects.get(i);
        tripViewHolder.setTripModel(tripModel);
    }

    @Override
    public int getItemCount() {
        return objects.size();
    }
}
