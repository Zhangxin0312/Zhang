package com.bw.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.widget.BaseAdapter;

import com.bw.fragment.Fragment1;
import com.bw.fragment.Fragment2;
import com.bw.fragment.Fragment3;
import com.bw.fragment.Fragment4;
import com.bw.fragment.Fragment5;
import com.bw.fragment.Fragment6;
import com.bw.fragment.Fragment7;

public class MyAdapter2 extends FragmentPagerAdapter {
    String[] arr={"沪深","板块","指数","港股","新三板","商品","更多"};
    @Override
    public CharSequence getPageTitle(int position) {
        return   arr[position];
    }

    public MyAdapter2(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment  fragment=null;
        switch (position){
            case 0:
                fragment=new Fragment1();
                break;
            case 1:
                fragment=new Fragment2();
                break;
            case 2:
                fragment=new Fragment3();
                break;
            case 3:
                fragment=new Fragment4();
                break;
            case 4:
                fragment=new Fragment5();
                break;
                case 5:
                fragment=new Fragment6();
                break;
            case 6:
                fragment=new Fragment7();
                break;


        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 7;
    }
}
