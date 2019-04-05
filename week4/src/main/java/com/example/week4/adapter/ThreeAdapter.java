package com.example.week4.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.week4.R;
import com.example.week4.bean.Product;
import com.example.week4.fragment.ShouFragment;
import com.example.week4.v.ShowActivity;
import com.example.week4.view.MyButton;

import java.util.List;

public class ThreeAdapter extends RecyclerView.Adapter<ThreeAdapter.Holder> {
    Context context;
    List<Product.DataBean.ListBean> mlist;

    ShowActivity activity;
    ShouFragment shouFragment;
    public ThreeAdapter(Context context, List<Product.DataBean.ListBean> list, ShouFragment shouFragment) {
        this.context=context;
        this.shouFragment=shouFragment;
        this.mlist=list;

    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=View.inflate(context,R.layout.three_item,null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final Holder holder, final int i) {
        Glide.with(context).load(mlist.get(i).getImages()).into(holder.three_iv);
        holder.three_price.setText(mlist.get(i).getPrice()+"");
        holder.three_name.setText(mlist.get(i).getSubhead());
        holder.three_cb.setChecked(mlist.get(i).isFlags());
        holder.myButton.tvv.setText(mlist.get(i).getNums()+"");
        holder.three_cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(holder.three_cb.isChecked()==false){
                     //获得外层的id
                    int n = shouFragment.getWaiId(mlist.get(i));
                    shouFragment.getWai(n,i,holder.three_cb.isChecked());
                    shouFragment.checkAll.setChecked(false);
                }else
                {
                    shouFragment.getNei(holder.three_cb.isChecked(),mlist.get(i));
                }
            }
        });

        holder.three_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                  shouFragment.startAct(mlist.get(i).getPid());
            }
        });

        holder.myButton.jian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num = mlist.get(i).getNums();
                num--;
                if(num<=1){
                    num=1;
                    Toast.makeText(context,"不能再少了",Toast.LENGTH_SHORT).show();
                }

                mlist.get(i).setNums(num);
                shouFragment.getSum();
                holder.myButton.tvv.setText(num+"");
            }
        });

        holder.myButton.jia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num = mlist.get(i).getNums();
                num++;
                mlist.get(i).setNums(num);
                shouFragment.getSum();
                holder.myButton.tvv.setText(num+"");
            }
        });

    }

    @Override
    public int getItemCount() {

        return mlist.size();
    }

    public  class Holder extends  RecyclerView.ViewHolder{
        CheckBox three_cb;
        ImageView three_iv;
        TextView three_name,three_price;
        MyButton myButton;
        public Holder(@NonNull View itemView) {
            super(itemView);
            three_cb=itemView.findViewById(R.id.three_cb);
            three_iv=itemView.findViewById(R.id.three_iv);
            three_name=itemView.findViewById(R.id.three_name);
            three_price=itemView.findViewById(R.id.three_price);
            myButton=itemView.findViewById(R.id.myButton);
        }
    }
}
