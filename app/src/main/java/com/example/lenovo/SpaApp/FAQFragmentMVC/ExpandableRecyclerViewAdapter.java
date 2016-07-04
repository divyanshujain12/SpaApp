package com.example.lenovo.SpaApp.FAQFragmentMVC;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.RotateAnimation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.lenovo.SpaApp.R;
import com.example.lenovo.SpaApp.Utils.CommonFunctions;
import com.neopixl.pixlui.components.textview.TextView;

import java.util.ArrayList;

/**
 * Created by android on 04/07/16.
 */
public class ExpandableRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener {

    private ArrayList<FaqModel> faqModels;
    private Context context;
    private RotateAnimation rotateOpenAnimation, rotateCloseAnimation;

    public ExpandableRecyclerViewAdapter(Context context, ArrayList<FaqModel> faqModels) {
        this.context = context;
        this.faqModels = faqModels;
        rotateOpenAnimation = new RotateAnimation(0, 90, RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f);
        rotateOpenAnimation.setDuration(100);
        rotateOpenAnimation.setFillAfter(true);

        rotateCloseAnimation = new RotateAnimation(90, 0, RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f);
        rotateCloseAnimation.setDuration(100);
        rotateCloseAnimation.setFillAfter(true);

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(context).inflate(R.layout.faq_content_view, parent, false);

        return new CellFeedViewHolder(view);
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {

        final CellFeedViewHolder holder = (CellFeedViewHolder) viewHolder;
        FaqModel faqModel = faqModels.get(position);

        holder.questionTV.setText(faqModel.getQuestion());
        holder.answerTV.setText(faqModel.getAnswer());
        holder.questionLL.setOnClickListener(this);
    }

    @Override
    public int getItemCount() {
        return faqModels.size();
    }

    @Override
    public void onClick(View v) {
        View parentView = (View) v.getParent();
        View arrowIV = v.findViewById(R.id.arrowIV);
        View answerView = parentView.findViewById(R.id.answerLL);

        if (answerView.getVisibility() == View.GONE) {
            CommonFunctions.expand(answerView);
            arrowIV.startAnimation(rotateOpenAnimation);
        } else {
            CommonFunctions.collapse(answerView);
            arrowIV.startAnimation(rotateCloseAnimation);
        }
    }

    public static class CellFeedViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout questionLL;
        TextView questionTV;
        TextView answerTV;

        public CellFeedViewHolder(View view) {
            super(view);
            questionLL = (RelativeLayout) view.findViewById(R.id.questionLL);
            questionTV = (TextView) view.findViewById(R.id.questionTV);
            answerTV = (TextView) view.findViewById(R.id.answerTV);


        }
    }
}
