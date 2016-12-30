package com.example.a7yan.viewpagedemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by 7Yan on 2016/12/30.
 */

public class ContentFragment extends Fragment
{
    //创建ContentFragment对象的方法
    public static ContentFragment newInstance(String msg){
        ContentFragment fragment=new ContentFragment();
        Bundle bundle=new Bundle();
        bundle.putString("msg",msg);
        fragment.setArguments(bundle);
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.content_layout,null);
        TextView tv = (TextView) view.findViewById(R.id.tv);
        Bundle bundle=getArguments();
        if(bundle!=null)
        {
            String msg=bundle.getString("msg");
            tv.setText(msg);
        }
        return view;
    }
}
