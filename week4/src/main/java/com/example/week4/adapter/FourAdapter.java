package com.example.week4.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.week4.R;
import com.example.week4.bean.Product;
import com.example.week4.bean.User;
import com.example.week4.v.TwoActivity;

import java.util.List;

public class FourAdapter extends RecyclerView.Adapter<FourAdapter.Holder> {
    Context context;
    List<User> mlist;
    public FourAdapter(Context context, List<User> mlist) {
        this.context=context;
        this.mlist=mlist;

    }


    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=View.inflate(context,R.layout.four_item,null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final Holder holder, final int i) {
        Glide.with(context).load(mlist.get(i).getData().getImages()).into(holder.four_iv);
         holder.four_price.setText(mlist.get(i).getData().getPrice()+"");
         holder.four_title.setText(mlist.get(i).getData().getTitle());
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public  class Holder extends  RecyclerView.ViewHolder{
       ImageView four_iv;
       TextView four_title,four_price;
        public Holder(@NonNull View itemView) {
            super(itemView);
            four_iv=itemView.findViewById(R.id.four_iv);
            four_title=itemView.findViewById(R.id.four_title);
            four_price=itemView.findViewById(R.id.four_price);
        }
    }

}
