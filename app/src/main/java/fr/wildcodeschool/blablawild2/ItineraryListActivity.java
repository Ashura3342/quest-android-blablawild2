package fr.wildcodeschool.blablawild2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class ItineraryListActivity extends AppCompatActivity {

    private Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itinerary_list);

        TripModel tripModel = getIntent().getParcelableExtra(ItinerarySearchActivity.EXTRA_TRIP);
        this.setTitle(String.format(getString(R.string.departure_to_destination), tripModel.getDeparture(), tripModel.getDestination()));

        RecyclerView listTrip = findViewById(R.id.list_trip);
        listTrip.setLayoutManager(new LinearLayoutManager(this));
        final ArrayList<TripModel> tripList = new ArrayList<>();

        tripList.add(new TripModel("Eric", "Cartman", "21/02/2017"));
        tripList.add(new TripModel("Stan", "Marsh", "21/02/2017"));
        tripList.add(new TripModel("Kenny", "Broflovski", "21/02/2017"));
        tripList.add(new TripModel("Kyle", "McCormick", "21/02/2017"));
        tripList.add(new TripModel("Wendy", "Testaburger", "21/02/2017"));

        TripAdapter adapter = new TripAdapter(tripList);
        listTrip.setAdapter(adapter);

        listTrip.addOnItemTouchListener(new RecyclerTouchListener(new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                TripModel current = tripList.get(position);
                if (toast != null)
                    toast.cancel();
                toast = Toast.makeText(ItineraryListActivity.this, current.getDestination(), Toast.LENGTH_SHORT);
                toast.show();
            }
        }));
    }
}
