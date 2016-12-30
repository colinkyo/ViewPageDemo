package com.example.a7yan.viewpagedemo;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;

import java.util.ArrayList;
import java.util.List;

public class VPFragment extends AppCompatActivity {
    private ViewPager vp;
    private PagerTabStrip tabStrip;
    private List<Fragment> fragmentList;
    private String[] tabNames;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vpfragment);
        vp = (ViewPager) findViewById(R.id.vp);
        tabStrip = (PagerTabStrip) findViewById(R.id.vp_tab);

        tabStrip.setTextColor(Color.RED);
        tabStrip.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
        tabStrip.setTabIndicatorColor(Color.GREEN);



        tabNames=getResources().getStringArray(R.array.tabs);

        fragmentList=new ArrayList<Fragment>();
        for(int i=0;i<3;i++)
        {
            ContentFragment contentFragment=ContentFragment.newInstance("第"+i+"个Fragment");
            fragmentList.add(contentFragment);
        }
        FragmentManager fragmentManager=getSupportFragmentManager();
        MyAdapter myAdapter=new MyAdapter(fragmentManager);
        vp.setAdapter(myAdapter);

    }
    class MyAdapter extends FragmentPagerAdapter{

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }
        //返回对象，注意是android.support.v4.app.Fragment;
        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList!=null?fragmentList.size():0;
        }
        //获取界面对于的标题
        @Override
        public CharSequence getPageTitle(int position) {
            return tabNames[position];
        }
    }
}
