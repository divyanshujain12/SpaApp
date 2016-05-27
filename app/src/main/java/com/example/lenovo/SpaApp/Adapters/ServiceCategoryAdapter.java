package com.example.lenovo.SpaApp.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.lenovo.SpaApp.R;
import com.neopixl.pixlui.components.textview.TextView;

/**
 * Created by Lenovo on 23-03-2016.
 */
public class ServiceCategoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private int itemsCount = 0;
    private String[] filenames = {"SERVICE", "SERVICE", "SERVICE", "SERVICE", "SERVICE", "SERVICE", "SERVICE", "SERVICE", "SERVICE", "SERVICE", "SERVICE"};

    public ServiceCategoryAdapter(Context context) {
        this.context = context;

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
        //     holder.feedImage.setTag(categoryArray[position]);

        holder.txtServiceSub.setText(filenames[position] + String.valueOf(" " + position));
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
        return filenames.length;
    }

    public static class CellFeedViewHolder extends RecyclerView.ViewHolder {
        TextView txtServiceSub;

        public CellFeedViewHolder(View view) {
            super(view);

            txtServiceSub = (TextView) view.findViewById(R.id.txtServiceSub);


        }
    }


}

