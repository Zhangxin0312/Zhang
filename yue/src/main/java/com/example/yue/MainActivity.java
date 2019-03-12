package com.example.yue;

import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.bw.adapter.MyAdapter;
import com.bw.adapter.MyAdapter1;
import com.bw.bean.Per;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {

    private XListView xlv;
    private List<Per> list;
    String[] title={"V8.36","客服热线","营业部网点","系统设置","换肤"};
    private ViewPager vp;
    private RadioGroup rg;
    private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3;
    private RadioButton rb4;
    private RadioButton rb5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitData();
        xlv = findViewById(R.id.xlv);
        rg = findViewById(R.id.rg);
        rb1 = findViewById(R.id.rb1);
        rb2 = findViewById(R.id.rb2);
        rb3 = findViewById(R.id.rb3);
        rb4 = findViewById(R.id.rb4);
        rb5 = findViewById(R.id.rb5);
      rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
          @Override
          public void onCheckedChanged(RadioGroup radioGroup, int position) {
              switch (position){
                  case R.id.rb1:
                      vp.setCurrentItem(0);
                      break;
                  case R.id.rb2:
                      vp.setCurrentItem(1);
                      break;
                  case R.id.rb3:
                      vp.setCurrentItem(2);
                      break;
                  case R.id.rb4:
                      vp.setCurrentItem(3);
                      break;
                  case R.id.rb5:
                      vp.setCurrentItem(4);
                      break;
              }
          }
      });

        vp = findViewById(R.id.vp);
        MyAdapter1   adapter1=new MyAdapter1(getSupportFragmentManager());
        vp.setAdapter(adapter1);
        MyAdapter  adapter=new MyAdapter(MainActivity.this,list);
        xlv.setAdapter(adapter);
        rb1.setBackgroundColor(Color.RED);
        vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        rb1.setBackgroundColor(Color.RED);
                        rb2.setBackgroundColor(Color.WHITE);
                        rb3.setBackgroundColor(Color.WHITE);
                        rb4.setBackgroundColor(Color.WHITE);
                        rb5.setBackgroundColor(Color.WHITE);
                        break;
                    case 1:
                        rb2.setBackgroundColor(Color.RED);
                        rb1.setBackgroundColor(Color.WHITE);
                        rb3.setBackgroundColor(Color.WHITE);
                        rb4.setBackgroundColor(Color.WHITE);
                        rb5.setBackgroundColor(Color.WHITE);
                        break;
                    case 2:
                        rb3.setBackgroundColor(Color.RED);
                        rb2.setBackgroundColor(Color.WHITE);
                        rb1.setBackgroundColor(Color.WHITE);
                        rb4.setBackgroundColor(Color.WHITE);
                        rb5.setBackgroundColor(Color.WHITE);
                        break;
                        case 3:
                        rb4.setBackgroundColor(Color.RED);
                        rb2.setBackgroundColor(Color.WHITE);
                        rb3.setBackgroundColor(Color.WHITE);
                        rb1.setBackgroundColor(Color.WHITE);
                        rb5.setBackgroundColor(Color.WHITE);
                        break;
                    case 4:
                        rb5.setBackgroundColor(Color.RED);
                        rb2.setBackgroundColor(Color.WHITE);
                        rb3.setBackgroundColor(Color.WHITE);
                        rb4.setBackgroundColor(Color.WHITE);
                        rb1.setBackgroundColor(Color.WHITE);
                        break;

                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

        private void InitData() {
            list = new ArrayList<>();
            for (int i=0;i<5;i++){
                Per p=new Per();
                if(i==0){
                    p.setImg(R.mipmap.a);
                    p.setName(title[i]);
                    p.setType(0);
                }else{
                    p.setName(title[i]);
                    p.setType(1);
                }
                list.add(p);
            }
       }
}
