package com.tink.android.biz.guide;

import android.content.Context;

import com.tink.android.api.ApiRequest;
import com.tink.android.base.BasePresenter;
import com.tink.android.base.BaseResp;
import com.tink.android.entity.GuideEntity;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class CityGuidePresenter extends BasePresenter<CityGuideView>{

    public CityGuidePresenter(Context context, CityGuideView iView) {
        super(context, iView);
    }

    public void getData(){
        ApiRequest.getApiService().queryCityGuide()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<BaseResp<List<GuideEntity>>>() {
                    @Override
                    public void accept(BaseResp<List<GuideEntity>> listBaseResp) throws Exception {
                        //更新UI
                    }
                });
    }
}
