package com.example.week4.v;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.week4.R;
import com.example.week4.adapter.FourAdapter;
import com.example.week4.bean.User;
import com.example.week4.contract.Contract;
import com.example.week4.p.MyPresenter;

import java.util.ArrayList;
import java.util.List;

public class TwoActivity extends AppCompatActivity implements Contract.MyViewInterfaces {
        RecyclerView recyclerView1;
        List<User> mlist=new ArrayList<>();
    private FourAdapter adapter;
    Contract.MyPresenterInterface myPresenterInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        Intent intent = getIntent();
        int id = intent.getIntExtra("id",1);
        recyclerView1=findViewById(R.id.recyclerView1);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView1.setLayoutManager(layoutManager);
        myPresenterInterface=new MyPresenter<>(this);
        myPresenterInterface.toModels(id);

        adapter = new FourAdapter(TwoActivity.this,mlist);
        recyclerView1.setAdapter(adapter);


    }


    @Override
    public void notitya(User user) {
         mlist.clear();
         mlist.add(user);
         adapter.notifyDataSetChanged();
    }
}
