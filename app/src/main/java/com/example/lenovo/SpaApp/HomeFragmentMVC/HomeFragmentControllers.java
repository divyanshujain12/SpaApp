package com.example.lenovo.SpaApp.HomeFragmentMVC;

import android.content.Intent;
import android.os.Build;
import android.support.v4.app.ActivityOptionsCompat;
import android.view.View;

import com.example.lenovo.SpaApp.CategoryProducts.ProductsActivity;
import com.example.lenovo.SpaApp.R;
import com.example.lenovo.SpaApp.Utils.Constants;

/**
 * Created by divyanshu on 5/29/2016.
 */
public class HomeFragmentControllers extends HomeFragment implements View.OnClickListener {


    public static HomeFragmentControllers getInstance() {
        HomeFragmentControllers homeFragmentControllers = new HomeFragmentControllers();
        return homeFragmentControllers;
    }

    public void onResume() {
        super.onResume();
        txtCancel.setOnClickListener(this);
    }

    public void onServiceSelected(View view, int pos) {
        Intent intent = new Intent(getActivity(), ProductsActivity.class);
        intent.putExtra(Constants.POS, pos);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            createTransitionAnimation(view, intent);
        } else {
            startActivity(intent);
        }
        // recyclerview.setAdapter(new ProductsAdapter(getActivity(), SingeltonClass.getInstance().getProductsArrayList(pos), this));
    }

    private void createTransitionAnimation(View view, Intent intent) {
        View imageView = view.findViewById(R.id.serviceIcon);
        imageView.setTransitionName(getString(R.string.imageview_transition_name));
        ActivityOptionsCompat options = ActivityOptionsCompat.
                makeSceneTransitionAnimation(getActivity(), imageView, imageView.getTransitionName());
        getActivity().startActivity(intent, options.toBundle());
    }

    private void OnServiceClick(View view, int pos) {

        onServiceSelected(view, pos);
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onClickItem(int position, View view) {

        View parentView = (View) view.getParent();
        if (parentView == servicesRV)
            OnServiceClick(view, position);

    }
}
