package com.example.week8.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.week8.R;
import com.example.week8.bean.Product;
import com.example.week8.v.ShowActivity;

import java.util.List;

public class MyAdapter  extends RecyclerView.Adapter<MyAdapter.Holder> {
    List<Product.DataBean> mlist;
    Context context;
    int type=1;
    public MyAdapter(List<Product.DataBean> mlist, Context context) {
        this.mlist=mlist;
        this.context=context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        if(type==1){
             view= View.inflate(context, R.layout.first_item, null);
        }else if(type==2)
        {
            view= View.inflate(context, R.layout.two_item, null);
        }else
        {
            view= View.inflate(context, R.layout.three_item, null);
        }
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int i) {
           if(type==1){
               if(holder!=null&&holder.first_tv!=null){
                   holder.first_tv.setText(mlist.get(i).getNews_title());
                   Glide.with(context).load(mlist.get(i).getPic_url()).into(holder.first_iv);

               }
           }else if(type==2)
           {
               if(holder!=null&&holder.two_tv!=null){
                   holder.two_tv.setText(mlist.get(i).getNews_title());
                   Glide.with(context).load(mlist.get(i).getPic_url()).into(holder.two_iv);

               }
           }else
           {
               if(holder!=null&&holder.three_tv!=null){
                   holder.three_tv.setText(mlist.get(i).getNews_title());


               }
           }
    }

    @Override
    public int getItemViewType(int position) {
         if(position%3==0){
             type=1;
         }else if(position%3==1)
         {
             type=2;
         }else
         {
             type=3;
         }
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {

        return mlist.size();
    }

    public  class Holder extends  RecyclerView.ViewHolder{
        ImageView first_iv,two_iv;
        TextView first_tv,two_tv,three_tv;
        public Holder(@NonNull View itemView) {
            super(itemView);
            if(type==1){
                first_iv=itemView.findViewById(R.id.first_iv);
                first_tv=itemView.findViewById(R.id.first_tv);
            }else if(type==2)
            {
                two_iv=itemView.findViewById(R.id.two_iv);
                two_tv=itemView.findViewById(R.id.two_tv);
            }else
            {
                three_tv=itemView.findViewById(R.id.three_tv);
            }


        }
    }
}
