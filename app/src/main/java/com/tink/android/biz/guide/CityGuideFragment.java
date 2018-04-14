package com.tink.android.biz.guide;


import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.orhanobut.logger.Logger;
import com.tink.android.R;
import com.tink.android.base.BaseFragment;
import com.tink.android.entity.GuideEntity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CityGuideFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CityGuideFragment extends BaseFragment<CityGuidePresenter> implements CityGuideView {

    @BindView(R.id.rv_data)
    RecyclerView rvData;

    CityGuideAdapter mAdapter;
    LinearLayoutManager manager;
    List<GuideEntity> mData = new ArrayList<>();
    public CityGuideFragment() {
        // Required empty public constructor
    }


    public static CityGuideFragment newInstance() {
        CityGuideFragment fragment = new CityGuideFragment();

        return fragment;
    }


    @Override
    protected void initPresenter() {
        presenter = new CityGuidePresenter(context,this);
        presenter.attachView();
    }

    @Override
    protected int setLayoutRsID() {
        return R.layout.fragment_city_guide;
    }

    @Override
    public void initView() {

        mAdapter = new CityGuideAdapter(null);
        manager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        rvData.setLayoutManager(manager);
        rvData.setAdapter(mAdapter);

        addItem(mData,10);
        mAdapter.setNewData(mData);
        mAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                rvData.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Logger.d("loading more data");
                        addItem(mData,3);
                        mAdapter.setNewData(mData);
                    }
                },1000);
            }
        },rvData);

        //presenter.getData();
    }

    private void addItem(List<GuideEntity> mData,int count) {
        for(int i = 0 ; i < count ;i ++){
            GuideEntity entity = new GuideEntity();
            if(i % 3 == 0){
                entity.type = 0;
            }else{
                entity.type = 1;
            }
            mData.add(entity);
        }
    }
}
