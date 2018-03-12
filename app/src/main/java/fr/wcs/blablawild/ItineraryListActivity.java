package fr.wcs.blablawild;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ItineraryListActivity extends AppCompatActivity {

    private ArrayList<ItineraryModel> mResults = new ArrayList<>();
    ItineraryAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itinerary_list);

        Intent intent = getIntent();
        final String departure = intent.getStringExtra(ItinerarySearchActivity.EXTRA_DEPARTURE);
        final String destination = intent.getStringExtra(ItinerarySearchActivity.EXTRA_DESTINATION);
        String title = String.format(getString(R.string.title_list), departure, destination);
        setTitle(title);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy-hh:mm");

        try {
            mResults.add(new ItineraryModel(departure, destination, "Eric", "Cartman", sdf.parse("21/02/2017-15:30"), 15));
            mResults.add(new ItineraryModel(departure, destination, "Stan", "Marsh", sdf.parse("21/02/2017-16:00"), 20));
            mResults.add(new ItineraryModel(departure, destination, "Kenny", "Broflovski", sdf.parse("21/02/2017-16:30"), 16));
            mResults.add(new ItineraryModel(departure, destination, "Kyle", "McCormick", sdf.parse("21/02/2017-17:00"), 40));
            mResults.add(new ItineraryModel(departure, destination, "Wendy", "Testaburger", sdf.parse("21/02/2017-17:30"), 20));
        } catch (ParseException e) {
        }
        mAdapter = new ItineraryAdapter(mResults);
        RecyclerView listTrip = findViewById(R.id.list_trip);
        listTrip.setAdapter(mAdapter);
        listTrip.setLayoutManager(new LinearLayoutManager(this));
        listTrip.setHasFixedSize(true);

        Button buttonAddTrip = findViewById(R.id.button_add_trip);
        buttonAddTrip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addItinerary(departure, destination);
            }
        });
    }

    private void addItinerary(String departure, String destination) {
        mResults.add(new ItineraryModel(departure, destination, "John", "Doe", new Date(), 0));
        mAdapter.notifyDataSetChanged();
    }
}
