package com.example.week6.v;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.week6.R;
import com.example.week6.adapter.MyAdapter;
import com.example.week6.bean.User;
import com.example.week6.p.MyPresenter;
import com.example.week6.p.MyPresenterInterface;

import java.util.ArrayList;
import java.util.List;

public class ShowActivity extends AppCompatActivity implements  MyViewInterface{
      RecyclerView recyclerView;
      MyAdapter adapter;
      List<User.AAA> mlist=new ArrayList<>();
      MyPresenterInterface myPresenterInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        recyclerView= findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        myPresenterInterface=new MyPresenter(this);
        myPresenterInterface.toModel();

        adapter=new MyAdapter(mlist,ShowActivity.this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void deng(String str) {

    }

    @Override
    public void zhu(String str) {

    }

    @Override
    public void notifys(List<User.AAA> list) {
        mlist.addAll(list);
        adapter.notifyDataSetChanged();
    }
    public  void onDestory(){
        myPresenterInterface.onDestory();
        myPresenterInterface=null;
    }
}
