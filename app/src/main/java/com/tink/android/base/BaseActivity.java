package com.tink.android.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Ervin on 2017/10/28.
 */

public abstract class BaseActivity<T extends BasePresenter> extends RxAppCompatActivity {

    protected T presenter;
    private Unbinder unbinder;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayoutRsID());
        unbinder = ButterKnife.bind(this);

        Log.d("main", "------------");
        initPresenter();
    }

    //由于该基类中不能获取presenter中具体的iView对应的实现类，所以将他抽象给上层去做；
    protected abstract void initPresenter();


    protected abstract int setLayoutRsID();
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(presenter!=null){
            presenter.detachView();
            presenter = null;
        }

        if (unbinder != Unbinder.EMPTY) unbinder.unbind();
    }
}
