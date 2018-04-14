package com.tink.android.biz.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.tink.android.R;
import com.tink.android.biz.eat.EatFragment;
import com.tink.android.biz.guide.CityGuideFragment;
import com.tink.android.biz.shop.ShopFragment;
import com.tink.android.entity.TabEntity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.ct_tab)
    CommonTabLayout ctTab;
    @BindView(R.id.vp_main)
    ViewPager vpMain;

    private String[] mTitles;
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mTitles = new String[]{getString(R.string.tab_guide), getString(R.string.tab_shop),getString(R.string.tab_eat)};
        for(int i = 0; i < mTitles.length; i++){
            mTabEntities.add(new TabEntity(mTitles[i],0,0));
        }
        ctTab.setTabData(mTabEntities);

        ctTab.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                vpMain.setCurrentItem(position);
            }

            @Override
            public void onTabReselect(int position) {

            }
        });
        ctTab.setCurrentTab(0);
        vpMain.setOffscreenPageLimit(3);
        vpMain.setAdapter(new PagerAdapter(getSupportFragmentManager()));
        vpMain.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                ctTab.setCurrentTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


    private class PagerAdapter extends FragmentPagerAdapter {
        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles[position];
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    return CityGuideFragment.newInstance();
                case 1:
                    return ShopFragment.newInstance();
                case 2:
                    return EatFragment.newInstance();

                default:
                    return null;
            }
        }
    }
}
