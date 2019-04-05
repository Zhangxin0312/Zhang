package com.example.week4.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.week4.R;
import com.example.week4.adapter.TwoAdapter;
import com.example.week4.bean.Product;
import com.example.week4.bean.User;
import com.example.week4.contract.Contract;
import com.example.week4.p.MyPresenter;
import com.example.week4.v.TwoActivity;

import java.util.ArrayList;
import java.util.List;

public class ShouFragment extends Fragment implements  Contract.MyViewInterface{
    RecyclerView recyclerView;
    TextView zj,shu;
    private TwoAdapter adapter;
     List<Product.DataBean>   mlist=new ArrayList<>();
     Contract.MyPresenterInterface myPresenterInterface;
     public CheckBox checkAll;
    private View view;
    private int numm;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = View.inflate(getActivity(), R.layout.shou_item,null);
         recyclerView= view.findViewById(R.id.recyclerView);
         zj=view.findViewById(R.id.zj);
          shu=view.findViewById(R.id.shu);
        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        myPresenterInterface=new MyPresenter<>(this);
        myPresenterInterface.toModel();
        adapter = new TwoAdapter(getActivity(),mlist,this);
        recyclerView.setAdapter(adapter);
        init();

        return view;
    }

    public void init() {
        checkAll=view.findViewById(R.id.checkAll);
        checkAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkAll.isChecked()){
                    CheckAll(true);
                    getSum();
                }else
                {
                    CheckAll(false);
                    zj.setText(0+"");
                    shu.setText(0+"");
                }
            }

        });
    }
        public  void CheckAll(boolean check){
            for (int i = 0; i <mlist.size() ; i++) {
                 mlist.get(i).setFlag(check);
                for (int j = 0; j < mlist.get(i).getList().size(); j++) {
                    mlist.get(i).getList().get(j).setFlags(check);
                }

            }
            adapter.notifyDataSetChanged();
        }


       public  void  getSum(){
        int sum=0;
        int value=0;
        int s=0;
           for (int i = 0; i <mlist.size() ; i++) {
               for (int j = 0; j < mlist.get(i).getList().size(); j++) {
                   if(mlist.get(i).getList().get(j).isFlags()){
                       double price = mlist.get(i).getList().get(j).getPrice();
                       numm = mlist.get(i).getList().get(j).getNums();
                       value= (int) (price* numm);
                       s+=numm;
                   }
                   sum+=value;
               }

           }
           shu.setText(s+"");
           zj.setText(sum+"");
           adapter.notifyDataSetChanged();

       }

       public  void  getWai(int i, int tag, boolean checked){
                mlist.get(i).setFlag(checked);
                if(tag!=-1){
                    mlist.get(i).getList().get(tag).setFlags(false);
                }else
                {
                    for (int j = 0; j <mlist.get(i).getList().size() ; j++) {
                         mlist.get(i).getList().get(j).setFlags(checked);
                    }

                }
                adapter.notifyDataSetChanged();
       }

       public  void  startAct(int id){
        Log.e("tag",id+"");
        Intent intent=new Intent(getActivity(),TwoActivity.class);
        intent.putExtra("id",id);
        startActivity(intent);
       }

    @Override
    public void notitys(List<Product.DataBean> list) {
         mlist.clear();
         mlist.addAll(list);
         adapter.notifyDataSetChanged();
    }

      int n=0;
    public int getWaiId(Product.DataBean.ListBean listBean) {
        for (int i = 0; i <mlist.size() ; i++) {
            for (int j = 0; j <mlist.get(i).getList().size() ; j++) {
                Product.DataBean.ListBean listBean1 = mlist.get(i).getList().get(j);
                if(listBean1.equals(listBean)){
                    n=i;
                }
            }
        }
        return n;
    }
    public void getNei(boolean checked, Product.DataBean.ListBean listBean) {
        for (int i = 0; i <mlist.size() ; i++) {
            for (int j = 0; j <mlist.get(i).getList().size() ; j++) {
                Product.DataBean.ListBean listBean1 = mlist.get(i).getList().get(j);
                if(listBean1.equals(listBean)){
                    listBean1.setFlags(checked);
                }
            }
        }

    }
}
