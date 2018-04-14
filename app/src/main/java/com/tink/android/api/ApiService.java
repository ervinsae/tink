package com.tink.android.api;

import com.tink.android.base.BaseResp;
import com.tink.android.entity.GuideEntity;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.http.GET;

/**
 * Created by Ervin on 2018/4/14.
 */

public interface ApiService {

    /**
     * 查询个人信息
     * @return
     */
    @GET("domain" + "user/me")
    Flowable<BaseResp<List<GuideEntity>>> queryCityGuide();
}


