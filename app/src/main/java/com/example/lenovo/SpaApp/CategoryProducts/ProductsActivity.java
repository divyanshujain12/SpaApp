package com.example.lenovo.SpaApp.CategoryProducts;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.example.lenovo.SpaApp.Adapters.ProductsAdapter;
import com.example.lenovo.SpaApp.AppointmentDescriptionActivity;
import com.example.lenovo.SpaApp.CustomViews.ToolbarWithBackButton;
import com.example.lenovo.SpaApp.R;
import com.example.lenovo.SpaApp.Utils.Constants;
import com.example.lenovo.SpaApp.Utils.ImageLoading;
import com.example.lenovo.SpaApp.Utils.SingeltonClass;

import GlobalClasses.GlobalActivity;
import butterknife.ButterKnife;
import butterknife.InjectView;

public class ProductsActivity extends GlobalActivity {

    @InjectView(R.id.productsRV)
    RecyclerView productsRV;
    @InjectView(R.id.categoryIV)
    ImageView categoryIV;
    ImageLoading imageLoading;
    @InjectView(R.id.toolbar)
    ToolbarWithBackButton toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        setContentView(R.layout.activity_products);
        ButterKnife.inject(this);
        initViews();
    }

    private void initViews() {
        imageLoading = new ImageLoading(this);
        int pos = getIntent().getIntExtra(Constants.POS, 0);
        toolbar.InitToolbar(this, SingeltonClass.serviceModelArrayList.get(pos).getName());
        imageLoading.LoadImage(SingeltonClass.serviceModelArrayList.get(pos).getIcon(), categoryIV, null);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        productsRV.setHasFixedSize(true);
        productsRV.setLayoutManager(linearLayoutManager);
        productsRV.setAdapter(new ProductsAdapter(this, SingeltonClass.getInstance().getProductsArrayList(pos), this));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            categoryIV.setTransitionName(getString(R.string.imageview_transition_name));

        }
    }

    @Override
    public void onClickItem(int position, View view) {
        super.onClickItem(position, view);
        Intent intent = new Intent(this, AppointmentDescriptionActivity.class);
        intent.putExtra(Constants.POS, position);
        startActivity(intent);
    }
}
