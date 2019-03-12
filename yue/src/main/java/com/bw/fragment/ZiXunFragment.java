package com.bw.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.astuetz.PagerSlidingTabStrip;
import com.bw.adapter.MyAdapter2;
import com.example.yue.R;

public class ZiXunFragment extends Fragment {

    private PagerSlidingTabStrip tabs;
    private ViewPager vp1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.zixun_item, null);
        tabs = view.findViewById(R.id.tabs);
        vp1 = view.findViewById(R.id.vp1);
        MyAdapter2 adapter2=new MyAdapter2(getActivity().getSupportFragmentManager());
        vp1.setAdapter(adapter2);
        tabs.setViewPager(vp1);
        return view;
    }
}
