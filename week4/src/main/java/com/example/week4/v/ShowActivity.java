package com.example.week4.v;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.week4.R;
import com.example.week4.fragment.MyFragment;
import com.example.week4.fragment.ShouFragment;

public class ShowActivity extends FragmentActivity {
    ViewPager vp;
    MyAdapter adapter;
    RadioButton rb1,rb2;
    RadioGroup rg;

   public Fragment fragment=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        vp=findViewById(R.id.vp);
        rb1=findViewById(R.id.rb1);
        rb2=findViewById(R.id.rb2);
        rg=findViewById(R.id.rg);
        adapter = new MyAdapter(getSupportFragmentManager());
        rb1.setBackgroundColor(Color.RED);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.rb1:
                          vp.setCurrentItem(0);
                        break;
                    case R.id.rb2:
                        vp.setCurrentItem(1);
                        break;
                }
            }
        });
        vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                  switch (i){
                      case 0:
                          rb1.setBackgroundColor(Color.RED);
                          rb2.setBackgroundColor(Color.WHITE);
                          break;
                      case 1:
                          rb2.setBackgroundColor(Color.RED);
                          rb1.setBackgroundColor(Color.WHITE);
                          break;
                  }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        vp.setAdapter(adapter);
    }

    public  class MyAdapter extends FragmentPagerAdapter {
        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {

            switch (i){
                case 0:
                    fragment=new ShouFragment();
                    break;
                case 1:
                    fragment=new MyFragment();
                    break;
            }
            return fragment;
        }

        @Override
        public int getCount() {
            return 2 ;
        }
    }
}
