package com.example.lenovo.SpaApp.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.lenovo.SpaApp.Models.ProductModel;
import com.example.lenovo.SpaApp.R;
import com.example.lenovo.SpaApp.Interfaces.RecyclerViewClick;
import com.neopixl.pixlui.components.textview.TextView;

import java.util.ArrayList;

/**
 * Created by Lenovo on 23-03-2016.
 */
public class ProductsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener {

    private Context context;
    private int itemsCount = 0;
    private ArrayList<ProductModel> subServiceModels;
    private RecyclerViewClick recyclerViewClick;

    public ProductsAdapter(Context context, ArrayList<ProductModel> subServiceModels, RecyclerViewClick recyclerViewClick) {
        this.context = context;
        this.subServiceModels = subServiceModels;
        this.recyclerViewClick = recyclerViewClick;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);

        return new CellFeedViewHolder(view);
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        final CellFeedViewHolder holder = (CellFeedViewHolder) viewHolder;
        bindDefaultFeedItem(position, holder);
    }

    private void bindDefaultFeedItem(int position, CellFeedViewHolder holder) {

        ProductModel subServiceModel = subServiceModels.get(position);
        holder.customView.setId(position);
        holder.txtServiceSub.setText(subServiceModel.getName());
        holder.txtPrice.setText(subServiceModel.getCost());

        holder.customView.setOnClickListener(this);
    }

    public void updateItems() {
        itemsCount = 10;
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        return 1;
    }

    @Override
    public int getItemCount() {
        return subServiceModels.size();
    }

    @Override
    public void onClick(View v) {
        recyclerViewClick.onClickItem(v.getId(), v);
    }

    public static class CellFeedViewHolder extends RecyclerView.ViewHolder {
        TextView txtServiceSub, txtPrice;
        View customView;

        public CellFeedViewHolder(View view) {
            super(view);
            customView = view;
            txtServiceSub = (TextView) view.findViewById(R.id.txtServiceSub);
            txtPrice = (TextView) view.findViewById(R.id.txtPrice);
        }
    }


}

