package com.bw.fragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.adapter.MyAdapter3;
import com.bw.bean.DataBean;
import com.bw.bean.User;
import com.example.yue.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.List;

public class Fragment1 extends Fragment {

    private PullToRefreshListView plv;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = View.inflate(getActivity(), R.layout.frag_item, null);
        Init();
        plv = view.findViewById(R.id.plv);
        return view;
    }

    private void Init() {
        new AsyncTask<String,Void,String>(){

            private List<User.AAA> list2;

            @Override
            protected String doInBackground(String... strings) {
                String json = DataBean.getStr();
                return json;
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                Gson gson=new Gson();
                User user = gson.fromJson(s, User.class);
                list2 = user.data;
                MyAdapter3 adapter3=new MyAdapter3(getActivity(),list2);
                plv.setMode(PullToRefreshBase.Mode.BOTH);
                plv.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
                    @Override
                    public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                        Toast.makeText(getActivity(),"下拉刷新",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                        Toast.makeText(getActivity(),"上拉加载",Toast.LENGTH_SHORT).show();
                    }
                });
                plv.setAdapter(adapter3);
            }
        }.execute();
    }
}
