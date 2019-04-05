package com.example.day18.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.day18.R;
import com.example.day18.bean.Product;
import com.example.day18.v.MainActivity;
import com.example.day18.view.MyButton;

import java.util.List;

public class TwoAdapter extends RecyclerView.Adapter<TwoAdapter.Holder> {
    Context  context;
    List<Product.DataBean.ListBean> mlist;
    MainActivity activity;
    public TwoAdapter(Context  context, List<Product.DataBean.ListBean> mlist) {
        this.context=context;
        this.mlist=mlist;
        activity= (MainActivity) context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.two_item, null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final Holder holder, final int i) {

         holder.two_price.setText(mlist.get(i).getPrice()+"");
         mlist.get(i).setNums(1);
        holder.two_name.setText(mlist.get(i).getSubhead());
        Glide.with(context).load(mlist.get(i).getImages()).into(holder.two_iv);
        holder.two_cb.setChecked(mlist.get(i).isFlags());
        holder.two_cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 if(holder.two_cb.isChecked()==false){
                     //得到外层对象下标
                     int n = activity.getWaiID( mlist.get(i));
                     //让内层的flag为当前状态
                     activity.CheckWai(n,i,holder.two_cb.isChecked());
                     //让全选的按钮设置为fasle
                       activity.checkAll.setChecked(false);
                 }else
                 {
                    activity.getNei(holder.two_cb.isChecked(),mlist.get(i));
                 }
            }
        });

        holder.myButton.jia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n = Integer.parseInt(holder.myButton.ttv.getText().toString());
                n++;
                mlist.get(i).setNums(n);
                holder.myButton.ttv.setText(n+"");
                activity.getSum();
            }
        });
        holder.two_cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                 if(holder.two_cb.isChecked()){
                       mlist.get(i).setFlags(true);
                       activity.getSum();
                 }else
                 {
                     mlist.get(i).setFlags(false);
                     activity.getSum();
                 }
            }
        });
        holder.myButton.jian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n = Integer.parseInt(holder.myButton.ttv.getText().toString());
                n--;
                if(n<=1){
                    Toast.makeText(context,"不能再少了",Toast.LENGTH_SHORT).show();
                    n=1;
                }
                mlist.get(i).setNums(n);
                holder.myButton.ttv.setText(n+"");
                activity.getSum();
            }
        });
        String num = holder.myButton.ttv.getText().toString();
        mlist.get(i).setNums(Integer.parseInt(num));
    }

    @Override
    public int getItemCount() {

        return mlist.size();
    }

    public  class Holder extends  RecyclerView.ViewHolder{
        TextView two_name,two_price;
        ImageView two_iv;
        CheckBox two_cb;
        MyButton myButton;
        public Holder(@NonNull View itemView) {
            super(itemView);
            two_iv=itemView.findViewById(R.id.two_iv);
            two_cb=itemView.findViewById(R.id.two_cb);
            two_name=itemView.findViewById(R.id.two_name);
            two_price=itemView.findViewById(R.id.two_price);
            myButton=itemView.findViewById(R.id.myButton);
        }
    }
}
