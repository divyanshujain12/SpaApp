package com.example.lenovo.SpaApp.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.lenovo.SpaApp.Models.ServiceModel;
import com.example.lenovo.SpaApp.R;
import com.example.lenovo.SpaApp.Interfaces.RecyclerViewClick;
import com.example.lenovo.SpaApp.Utils.ImageLoading;
import com.example.lenovo.SpaApp.Utils.SingeltonClass;
import com.neopixl.pixlui.components.textview.TextView;

/**
 * Created by divyanshu on 4/6/2016.
 */
public class HomeServiceCategoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener {

    private Context context;
    private int itemsCount = 0;
    private RecyclerViewClick recyclerViewClick;
    private ImageLoading imageLoading;
//    private int[] serviceIncons = {R.drawable.service_icon1, R.drawable.service_icon2, R.drawable.service_icon3, R.drawable.service_icon4, R.drawable.service_icon5, R.drawable.service_icon6};

    public HomeServiceCategoryAdapter(Context context, RecyclerViewClick recyclerViewClick) {
        this.context = context;
        this.recyclerViewClick = recyclerViewClick;
        imageLoading = new ImageLoading(context);

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

        ServiceModel serviceModel = SingeltonClass.serviceModelArrayList.get(position);
        //     holder.feedImage.setTag(categoryArray[position]);
        holder.customView.setId(position);
        imageLoading.LoadImage(serviceModel.getIcon(), holder.serviceIcon, null);
        holder.txtServiceName.setText(serviceModel.getName());
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
        return SingeltonClass.serviceModelArrayList.size();
    }

    @Override
    public void onClick(View v) {
        recyclerViewClick.onClickItem(v.getId(), v);
    }

    public static class CellFeedViewHolder extends RecyclerView.ViewHolder {
        TextView txtServiceName;
        ImageView serviceIcon;
        View customView;

        public CellFeedViewHolder(View view) {
            super(view);
            customView = view;
            serviceIcon = (ImageView) view.findViewById(R.id.serviceIcon);
            txtServiceName = (TextView) view.findViewById(R.id.txtServiceName);


        }
    }


}


