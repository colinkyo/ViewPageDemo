package com.example.a7yan.viewpagedemo;

import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private List<ImageView>  imageViewList;
    private TextView tv;
    private String[] tnames;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager) findViewById(R.id.vp);
        tv = (TextView) findViewById(R.id.tv);
        //数据源
        imageViewList= new ArrayList<ImageView>();
        int[] imageRes=getImageRes();
        tnames=getNames();
        //Log.i("7Yan",tnames[0]);
        tv.setText(tnames[0]);
        for(int i=0;i<imageRes.length;i++){
            ImageView iv=new ImageView(this);
            iv.setImageResource(imageRes[i]);
            imageViewList.add(iv);
        }
        MyAdapter myadapter=new MyAdapter();
        viewPager.setAdapter(myadapter);
        viewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){
            @Override
            public void onPageSelected(int position) {
                tv.setText(tnames[position]);
                super.onPageSelected(position);
            }
        });
    }
    public void click(View view){
        Intent intent=new Intent(this,VPFragment.class);
        startActivity(intent);
    }
    private String[] getNames() {
       return  new String[]{"手机1","手机2","手机3"};
    }

    private int[] getImageRes()
    {
        return new int[]{R.mipmap.t1,R.mipmap.t2,R.mipmap.t3};
    }

    class MyAdapter extends PagerAdapter{
        //viewPage中可以显示的子视图个数
        @Override
        public int getCount() {
            return imageViewList != null ? imageViewList.size():0;
        }

        //判断子视图是否加载过，加载过就复用，没有就创建
        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }
        //创建一个子视图
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(imageViewList.get(position));
            return imageViewList.get(position);
        }
        //移除子视图


        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(imageViewList.get(position));
            //必须注释掉
            //super.destroyItem(container, position, object);
        }
    }
}
