package com.example.day18.v;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.day18.R;
import com.example.day18.adapter.MyAdapter;
import com.example.day18.bean.Product;
import com.example.day18.contract.Contract;
import com.example.day18.p.MyPresenter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  implements Contract.MyViewInterface {
    RecyclerView recyclerView;
    private MyAdapter adapter;
   Contract.MyPresenterInterface myPresenterInterface;
   List<Product.DataBean>  mlist=new ArrayList<>();
    public   CheckBox checkAll;
    TextView zong;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerView);
        zong=findViewById(R.id.zong);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        myPresenterInterface=new MyPresenter(this);
        myPresenterInterface.toModel();
        adapter = new MyAdapter(MainActivity.this,mlist);
        recyclerView.setAdapter(adapter);
        init();
    }

    public  void init() {
        checkAll=findViewById(R.id.checkAll);
        checkAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                  if(checkAll.isChecked()){
                      CheckAll(true);
                      getSum();
                  }else
                  {
                      CheckAll(false);
                      getSum();
                  }
                  adapter.notifyDataSetChanged();
            }
        });
    }
    //全选全不选
    public  void  CheckAll(boolean  check) {
        //循环外层集合
        for (int i = 0; i < mlist.size(); i++) {
            //给flag设置为true
            mlist.get(i).setFlag(check);
            for (int j = 0; j < mlist.get(i).getList().size(); j++) {
                //循环内层集合  设置flag
                mlist.get(i).getList().get(j).setFlags(check);
            }
        }
        adapter.notifyDataSetChanged();
    }
    //点击商家让内层选中
    public  void  CheckWai(int position, int tag,boolean flag){
           mlist.get(position).setFlag(flag);
        if(tag!=-1){
            mlist.get(position).getList().get(tag).setFlags(false);

        }else
        {
            for (int i = 0; i <mlist.get(position).getList().size() ; i++) {
                mlist.get(position).getList().get(i).setFlags(flag);
            }
        }

        adapter.notifyDataSetChanged();
    }
    //获取商家的下标
    int n=0;
    public  int    getWaiID(Product.DataBean.ListBean listBean){
        //得到内层的对象

        Product.DataBean.ListBean  listBean1=listBean;
        for (int i = 0; i <mlist.size() ; i++) {
            for (int j = 0; j < mlist.get(i).getList().size(); j++) {
                Product.DataBean.ListBean listBean2=mlist.get(i).getList().get(j);
                 //进行比对  找到为false的内层对象的集合
                if(listBean2.equals(listBean1)){
                    n=i;
                }
            }

        }
        return  n;
    }

    public  int    getNei(boolean check, Product.DataBean.ListBean listBean){
        //得到内层的对象

        Product.DataBean.ListBean  listBean1=listBean;
        for (int i = 0; i <mlist.size() ; i++) {
            for (int j = 0; j < mlist.get(i).getList().size(); j++) {
                Product.DataBean.ListBean listBean2=mlist.get(i).getList().get(j);
                //进行比对  找到为false的内层对象的集合
                if(listBean2.equals(listBean1)){
                   listBean2.setFlags(check);
                    n=i;
                }
            }

        }
        return  n;
    }

    @Override
    public void notifys(List<Product.DataBean> list) {
        mlist.clear();
        mlist.addAll(list);
        adapter.notifyDataSetChanged();
    }

    public  void getSum(){
        int sum=0;
        int value=0;
        for (int i = 0; i < mlist.size(); i++) {

            for (int j = 0; j < mlist.get(i).getList().size(); j++) {
                //循环内层集合  设置flag
               if( mlist.get(i).getList().get(j).isFlags()){
                   double price = mlist.get(i).getList().get(j).getPrice();
                   int nums = mlist.get(i).getList().get(j).getNums();
                   sum= (int) (price*nums);
               }
               value+=sum;
            }
        }
        zong.setText(value+"");
    }
}
