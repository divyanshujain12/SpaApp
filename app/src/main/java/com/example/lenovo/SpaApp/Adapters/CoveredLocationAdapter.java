package com.example.lenovo.SpaApp.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.lenovo.SpaApp.Interfaces.RecyclerViewClick;
import com.example.lenovo.SpaApp.Models.SelectCityModel;
import com.example.lenovo.SpaApp.R;
import com.example.lenovo.SpaApp.Utils.ImageLoading;
import com.example.lenovo.SpaApp.Utils.RoundedImageView;
import com.neopixl.pixlui.components.textview.TextView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by divyanshuPC on 5/26/2018.
 */

public class CoveredLocationAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener {

    private Context context;
    private RecyclerViewClick recyclerViewClick;
    private ArrayList<SelectCityModel> selectCityModels;
    private int lastPosition = -1;
    private ImageLoading imageLoading;
    private HashMap<String, String> cityDetailHashMap = new HashMap<>();

    public CoveredLocationAdapter(Context context, RecyclerViewClick recyclerViewClick, ArrayList<SelectCityModel> selectCityModels) {
        this.context = context;
        this.recyclerViewClick = recyclerViewClick;
        this.selectCityModels = selectCityModels;
        imageLoading = new ImageLoading(context, true);
        addValuesInCityDetailHashMap();

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(context).inflate(R.layout.covered_location_adapter, parent, false);

        return new CoveredLocationsViewHolder(view);
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        final CoveredLocationsViewHolder holder = (CoveredLocationsViewHolder) viewHolder;
        bindDefaultFeedItem(position, holder);
    }

    private void bindDefaultFeedItem(int position, CoveredLocationsViewHolder holder) {

        //     holder.feedImage.setTag(categoryArray[position]);
        String cityName = selectCityModels.get(position).getName();
        holder.customView.setId(position);
        holder.cityDetailTV.setText(cityDetailHashMap.get(cityName));
        holder.cityNameTV.setText(cityName);
        imageLoading.LoadImage(selectCityModels.get(position).getThumbnail(), holder.cityIV, null);
        holder.customView.setOnClickListener(this);
        //setAnimation(holder.customView, position);
    }

    @Override
    public int getItemViewType(int position) {
        return 1;
    }

    @Override
    public int getItemCount() {
        return selectCityModels.size();
    }

    @Override
    public void onClick(View v) {
        recyclerViewClick.onClickItem(v.getId(), v);
    }

    public static class CoveredLocationsViewHolder extends RecyclerView.ViewHolder {
        TextView cityDetailTV, cityNameTV;
        View customView;
        RoundedImageView cityIV;

        public CoveredLocationsViewHolder(View view) {
            super(view);
            customView = view;
            cityDetailTV = (TextView) view.findViewById(R.id.cityDetailTV);
            cityNameTV = (TextView) view.findViewById(R.id.cityNameTV);
            cityIV = (RoundedImageView) view.findViewById(R.id.cityIV);
        }
    }

    private void setAnimation(View viewToAnimate, int position) {
        if (position > lastPosition) {
            Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }
    }

    private void addValuesInCityDetailHashMap() {
        cityDetailHashMap.put("New York", "We currently service all of Manhattan, in addition to select parts of Brooklyn, Queens and the Bronx  ( in addition, location must be accessible by subway).   To check if your location is covered, please email us at info@myspa2go.com .");
        cityDetailHashMap.put("London", "We currently cover all areas in and surrounding central London.   Feel free to contact us at info@myspa2go.co.uk for further information and to find out if we cover your area.");
        cityDetailHashMap.put("Los Angeles", "Coming Soon...");

    }
}
