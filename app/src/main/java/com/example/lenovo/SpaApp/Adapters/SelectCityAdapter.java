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

/**
 * Created by divyanshu on 7/5/2016.
 */
public class SelectCityAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener {

    private Context context;
    private RecyclerViewClick recyclerViewClick;
    private ArrayList<SelectCityModel> selectCityModels;
    private int lastPosition = -1;
    private ImageLoading imageLoading;

    public SelectCityAdapter(Context context, RecyclerViewClick recyclerViewClick, ArrayList<SelectCityModel> selectCityModels) {
        this.context = context;
        this.recyclerViewClick = recyclerViewClick;
        this.selectCityModels = selectCityModels;
        imageLoading = new ImageLoading(context, true);

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(context).inflate(R.layout.select_cty_item, parent, false);

        return new CellFeedViewHolder(view);
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        final CellFeedViewHolder holder = (CellFeedViewHolder) viewHolder;
        bindDefaultFeedItem(position, holder);
    }

    private void bindDefaultFeedItem(int position, CellFeedViewHolder holder) {

        //     holder.feedImage.setTag(categoryArray[position]);
        holder.customView.setId(position);
        holder.cityNumberTV.setText(String.valueOf(position + 1));
        holder.cityNameTV.setText(selectCityModels.get(position).getName());
        imageLoading.LoadImage(selectCityModels.get(position).getThumbnail(), holder.cityIV, null);
        holder.customView.setOnClickListener(this);
        setAnimation(holder.customView, position);
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

    public static class CellFeedViewHolder extends RecyclerView.ViewHolder {
        TextView cityNumberTV, cityNameTV;
        View customView;
        RoundedImageView cityIV;

        public CellFeedViewHolder(View view) {
            super(view);
            customView = view;
            cityNumberTV = (TextView) view.findViewById(R.id.cityNumberTV);
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
}