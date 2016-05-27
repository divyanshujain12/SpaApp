package com.example.lenovo.SpaApp.Adapters;

import android.content.Context;
import android.media.Image;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.lenovo.SpaApp.R;
import com.example.lenovo.SpaApp.Utils.CommonFunctions;
import com.neopixl.pixlui.components.textview.TextView;

/**
 * Created by Lenovo on 01-03-2016.
 */
public class ViewPagerAdapter extends PagerAdapter {
    // Declare Variables
    Context context;
    int[] imageResources;
    String[] imageText;
    LayoutInflater inflater;
    CommonFunctions commonFunctions;
    int[] firstPageIcons = {R.drawable.service_icon1, R.drawable.service_icon2, R.drawable.service_icon3};
    int[] secondPageIcons = {R.drawable.service_icon2, R.drawable.service_icon4, R.drawable.service_icon6};
    int[] thirdPageIcons = {R.drawable.service_icon7, R.drawable.service_icon8, R.drawable.service_icon9};
    int[] fourthPageIcons = {R.drawable.service_icon10, R.drawable.service_icon11, R.drawable.service_icon12};
    ImageView firstIcon, secondIcon, thirdIcon;
    TextView txtInstruction;
    ImageView imageView;

    public ViewPagerAdapter(Context context, int[] imageResources, String[] imageText
    ) {
        this.context = context;
        this.imageResources = imageResources;
        this.imageText = imageText;
        commonFunctions = new CommonFunctions(context);

    }

    @Override
    public int getCount() {
        return imageText.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((RelativeLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        // Declare Variables


        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.how_to_work_viewpager_item, container,
                false);
        firstIcon = (ImageView) itemView.findViewById(R.id.firstIcon);
        secondIcon = (ImageView) itemView.findViewById(R.id.secondIcon);
        thirdIcon = (ImageView) itemView.findViewById(R.id.thirdIcon);
        txtInstruction = (TextView) itemView.findViewById(R.id.txtInstruction);
        imageView = (ImageView) itemView.findViewById(R.id.imageView);
        switch (position) {
            case 0:
                changeIcons(firstPageIcons);
                break;
            case 1:
                changeIcons(secondPageIcons);
                break;
            case 2:
                changeIcons(thirdPageIcons);
                break;
            case 3:
                changeIcons(fourthPageIcons);
                break;
        }
        txtInstruction.setText(imageText[position]);
        imageView.setImageResource(imageResources[position]);
       /*  commonFunctions.StartAsyncTaskInParallel(new CreateBlurredImage(context, imageView, imageResources[position]));*/
        ((ViewPager) container).addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        // Remove viewpager_item.xml from ViewPager
        ((ViewPager) container).removeView((RelativeLayout) object);

    }

    private void changeIcons(int[] array) {
        firstIcon.setImageResource(array[0]);
        secondIcon.setImageResource(array[1]);
        thirdIcon.setImageResource(array[2]);
    }
}
