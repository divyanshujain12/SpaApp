package com.example.lenovo.SpaApp.AppIntro;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.lenovo.SpaApp.R;
import com.example.lenovo.SpaApp.SelectCityActivity;
import com.neopixl.pixlui.components.textview.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import tyrantgit.explosionfield.ExplosionField;

/**
 * Created by Android on 26-04-2016.
 */
public class SecondFragment extends Fragment {
    @InjectView(R.id.appLogo)
    ImageView appLogo;
    @InjectView(R.id.txtInstruction)
    TextView txtInstruction;
    @InjectView(R.id.txtSignIn)
    TextView txtSignIn;
    @InjectView(R.id.txtSignUp)
    TextView txtSignUp;
    private ExplosionField mExplosionField;
    Intent intent;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.intro_second_fragment, container, false);
        ButterKnife.inject(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mExplosionField = ExplosionField.attach2Window(getActivity());
    }

    @OnClick({R.id.txtSignIn, R.id.txtSignUp})
    public void onClick(View view) {
        mExplosionField.explode(view);
        intent = new Intent(getContext(), SelectCityActivity.class);
        switch (view.getId()) {
            case R.id.txtSignIn:
                intent.putExtra("pos", 0);
                break;
            case R.id.txtSignUp:
                intent.putExtra("pos", 1);
                break;
        }
        handler.postDelayed(runnable, 1000);
    }

    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            startActivity(intent);
            getActivity().finish();
        }
    };

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}
