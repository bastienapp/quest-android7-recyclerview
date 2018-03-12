package fr.wcs.blablawild;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Created by bastienwcs on 12/03/18.
 */

public class ItineraryAdapter extends RecyclerView.Adapter<ItineraryAdapter.ViewHolder> {

    private ArrayList<ItineraryModel> mItineraryModels;

    public ItineraryAdapter(ArrayList<ItineraryModel> itineraryModels) {
        this.mItineraryModels = itineraryModels;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.item_trip, parent, false);

        // Return a new holder instance
        return new ViewHolder(contactView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ItineraryModel itineraryModel = mItineraryModels.get(position);
        holder.textFirstname.setText(itineraryModel.getFirstname());
        holder.textLastname.setText(itineraryModel.getLastname());
        holder.textPrice.setText(String.format("$%s", itineraryModel.getPrice()));

        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
        holder.textDate.setText(sdf.format(itineraryModel.getDate()));
    }

    @Override
    public int getItemCount() {
        return mItineraryModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textFirstname;
        TextView textLastname;
        TextView textDate;
        TextView textPrice;

        public ViewHolder(View itemView) {
            super(itemView);

            textFirstname = itemView.findViewById(R.id.text_firstname);
            textLastname = itemView.findViewById(R.id.text_lastname);
            textDate = itemView.findViewById(R.id.text_date);
            textPrice = itemView.findViewById(R.id.text_price);
        }
    }
}
