package com.virtualstudios.travelapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.flaviofaria.kenburnsview.KenBurnsView;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TravelLocationsAdapter extends RecyclerView.Adapter<TravelLocationsAdapter.ViewHolder> {

    private List<TravelLocation> travelLocations;

    public TravelLocationsAdapter(List<TravelLocation> travelLocations) {
        this.travelLocations = travelLocations;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_container_location, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.setLocationData(travelLocations.get(position));
    }

    @Override
    public int getItemCount() {
        return travelLocations.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private KenBurnsView kbvLocation;
        private TextView textTitle, textLocation, textStarRating;

         ViewHolder(@NonNull View itemView) {
            super(itemView);
            kbvLocation = itemView.findViewById(R.id.kbvLocations);
            textTitle = itemView.findViewById(R.id.textTitle);
            textLocation = itemView.findViewById(R.id.textLocation);
            textStarRating = itemView.findViewById(R.id.textStarRating);
        }

        void setLocationData(TravelLocation travelLocation){
             Picasso.get().load(travelLocation.imageUrl).into(kbvLocation);
             textTitle.setText(travelLocation.title);
             textLocation.setText(travelLocation.location);
             textStarRating.setText(String.valueOf(travelLocation.starRating));
        }
    }
}
