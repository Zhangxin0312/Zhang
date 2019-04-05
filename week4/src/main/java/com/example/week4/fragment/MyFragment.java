package com.example.week4.fragment;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.week4.R;
import com.makeramen.roundedimageview.RoundedImageView;

public class MyFragment extends Fragment {
    RoundedImageView rou;
    ObjectAnimator animator,animator1;
    Button shu;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view=View.inflate(getActivity(),R.layout.my_item,null);
        rou = view.findViewById(R.id.rou);
        shu = view.findViewById(R.id.shu);
        rou.setImageResource(R.mipmap.a);
         shu.setOnClickListener(new View.OnClickListener() {


             @Override
           public void onClick(View view) {

                 animator = ObjectAnimator.ofFloat(rou, "translationY", 0, 300,0);
                 animator1 = ObjectAnimator.ofFloat(rou, "alpha", 1, 0.3f,1);
                 animator.setDuration(5000);
                 animator1.setDuration(5000);
                 animator.start();
                 animator1.start();
           }
       });
        return view;
    }
}
