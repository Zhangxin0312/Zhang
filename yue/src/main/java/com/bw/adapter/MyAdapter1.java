package com.bw.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.bw.fragment.HangFragment;
import com.bw.fragment.JiaoFragment;
import com.bw.fragment.ShouFragment;
import com.bw.fragment.ZiXuanFragment;
import com.bw.fragment.ZiXunFragment;

public class MyAdapter1 extends FragmentPagerAdapter {
    public MyAdapter1(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment  fragment=null;
        switch (position){
            case  0:
                fragment=new ShouFragment();
                break;
            case  1:
                fragment=new ZiXuanFragment();

                break;
            case  2:
                fragment=new HangFragment();
                break;
            case  3:
                fragment=new ZiXunFragment();
                break;
            case  4:
                fragment=new JiaoFragment();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 5;
    }
}
