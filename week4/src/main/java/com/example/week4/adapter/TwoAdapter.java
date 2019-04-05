package com.example.week4.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.week4.R;
import com.example.week4.bean.Product;
import com.example.week4.fragment.ShouFragment;
import com.example.week4.v.ShowActivity;

import java.util.List;

public class TwoAdapter  extends RecyclerView.Adapter<TwoAdapter.Holder> {
    Context context;
    List<Product.DataBean> mlist;
    private ThreeAdapter adapter;
    ShouFragment shouFragment;
    public TwoAdapter(Context context, List<Product.DataBean> mlist, ShouFragment shouFragment) {
        this.context=context;
        this.mlist=mlist;
         this.shouFragment=shouFragment;
    }


    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=View.inflate(context,R.layout.two_item,null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final Holder holder, final int i) {
         holder.two_name.setText(mlist.get(i).getSellerName());
        holder.cb.setChecked(mlist.get(i).isFlag());

        LinearLayoutManager layoutManager=new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
         holder.recycler.setLayoutManager(layoutManager);
          holder.cb.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                   shouFragment.getWai(i,-1,holder.cb.isChecked());
              }
          });
         adapter = new ThreeAdapter(context,mlist.get(i).getList(),shouFragment);

         holder.recycler.setAdapter(adapter);
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public  class Holder extends  RecyclerView.ViewHolder{
        CheckBox cb;
        TextView two_name;
        RecyclerView recycler;

        public Holder(@NonNull View itemView) {
            super(itemView);
            cb=itemView.findViewById(R.id.cb);
            two_name=itemView.findViewById(R.id.two_name);
            recycler=itemView.findViewById(R.id.recycler);
        }
    }

}
