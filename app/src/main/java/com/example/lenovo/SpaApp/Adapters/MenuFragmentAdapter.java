package com.example.lenovo.SpaApp.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.lenovo.SpaApp.R;
import com.example.lenovo.SpaApp.Utils.Constants;
import com.example.lenovo.SpaApp.Utils.MySharedPereference;
import com.neopixl.pixlui.components.textview.TextView;

/**
 * Created by deii on 3/25/2016.
 */
public class MenuFragmentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private int itemsCount = 0;
    private String[] serviceName;
    private int[] serviceIcons;

    public MenuFragmentAdapter(Context context) {

        if (MySharedPereference.getInstance().getBoolean(context, Constants.LOGGED_IN)) {
            serviceName = context.getResources().getStringArray(R.array.logged_in_nav_name);
            serviceIcons = context.getResources().getIntArray(R.array.logged_in_nav_icon);
            serviceIcons = new int[]{R.drawable.home, R.drawable.my_appointment, R.drawable.my_account, R.drawable.how_it_works, R.drawable.corporate_inquiries, R.drawable.contact, R.drawable.ic_location, R.drawable.logout};
        } else {
            serviceName = context.getResources().getStringArray(R.array.logged_out_nav_name);
            serviceIcons = new int[]{R.drawable.home, R.drawable.how_it_works, R.drawable.corporate_inquiries, R.drawable.contact, R.drawable.ic_location, R.drawable.login};
        }
        this.context = context;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(context).inflate(R.layout.menu_fragment_item, parent, false);

        return new CellFeedViewHolder(view);
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        final CellFeedViewHolder holder = (CellFeedViewHolder) viewHolder;
        bindDefaultFeedItem(position, holder);
    }

    private void bindDefaultFeedItem(int position, CellFeedViewHolder holder) {
        //     holder.feedImage.setTag(categoryArray[position]);
        holder.imgMenuIcon.setImageResource(serviceIcons[position]);
        holder.txtMenuName.setText(serviceName[position]);
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
        return serviceName.length;
    }

    public static class CellFeedViewHolder extends RecyclerView.ViewHolder {
        ImageView imgMenuIcon;
        TextView txtMenuName;

        public CellFeedViewHolder(View view) {
            super(view);
            imgMenuIcon = (ImageView) view.findViewById(R.id.imgMenuIcon);
            txtMenuName = (TextView) view.findViewById(R.id.txtMenuName);


        }
    }


}
