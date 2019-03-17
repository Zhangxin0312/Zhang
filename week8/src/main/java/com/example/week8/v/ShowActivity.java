package com.example.week8.v;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.week8.R;
import com.example.week8.adapter.MyAdapter;
import com.example.week8.bean.Product;
import com.example.week8.contract.ContractInterface;
import com.example.week8.p.MyPresenter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ShowActivity extends AppCompatActivity implements  ContractInterface.LoginInterface{
         XRecyclerView recyclerView;
         private MyAdapter adapter;
         ContractInterface.MyPersenterInterface myPersenterInterface;
    List<Product.DataBean> mlist=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        myPersenterInterface=new MyPresenter(this);
        recyclerView=findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                myPersenterInterface.toModel();
                recyclerView.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                Toast.makeText(ShowActivity.this,"上拉加载",Toast.LENGTH_SHORT).show();
                myPersenterInterface.toModel();
                recyclerView.loadMoreComplete();
            }
        });
        myPersenterInterface.toModel();

        adapter = new MyAdapter(mlist,ShowActivity.this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void Login(String str) {

    }

    @Override
    public void Regist(String str) {

    }

    @Override
    public void notifys(List<Product.DataBean> list) {
         mlist.addAll(list);
         adapter.notifyDataSetChanged();
    }
}
