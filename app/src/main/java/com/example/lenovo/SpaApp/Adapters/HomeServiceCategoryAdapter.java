package com.example.lenovo.SpaApp.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.lenovo.SpaApp.R;
import com.neopixl.pixlui.components.textview.TextView;

/**
 * Created by divyanshu on 4/6/2016.
 */
public class HomeServiceCategoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private int itemsCount = 0;
    private int[] serviceIncons = {R.drawable.service_icon1, R.drawable.service_icon2, R.drawable.service_icon3, R.drawable.service_icon4, R.drawable.service_icon5, R.drawable.service_icon6};
    private String[] filenames = {"SERVICE 1", "SERVICE 2", "SERVICE 3", "SERVICE 4", "SERVICE 5", "SERVICE 6"};

    public HomeServiceCategoryAdapter(Context context) {
        this.context = context;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(context).inflate(R.layout.home_service_categories_adapter, parent, false);

        return new CellFeedViewHolder(view);
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        final CellFeedViewHolder holder = (CellFeedViewHolder) viewHolder;
        bindDefaultFeedItem(position, holder);
    }

    private void bindDefaultFeedItem(int position, CellFeedViewHolder holder) {
        //     holder.feedImage.setTag(categoryArray[position]);
        holder.serviceIcon.setImageResource(serviceIncons[position]);
        holder.txtServiceName.setText(filenames[position]);
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
        TextView txtServiceName;
        ImageView serviceIcon;

        public CellFeedViewHolder(View view) {
            super(view);
            serviceIcon = (ImageView) view.findViewById(R.id.serviceIcon);
            txtServiceName = (TextView) view.findViewById(R.id.txtServiceName);


        }
    }


}


