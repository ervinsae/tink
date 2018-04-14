package com.tink.android.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.orhanobut.logger.Logger;
import com.trello.rxlifecycle2.components.support.RxFragment;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Ervin on 2018/2/2.
 */

public abstract class BaseFragment<T extends BasePresenter> extends RxFragment {

    protected T presenter;
    protected Context context;
    private Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(setLayoutRsID(),container,false);
        unbinder = ButterKnife.bind(this,view);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        context = getContext();
        initPresenter();
    }



    protected abstract void initPresenter();


    protected abstract int setLayoutRsID();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Logger.d("-----------fragment destroy view----------");
        if(presenter != null){
            presenter.detachView();
            presenter = null;
        }
        if(unbinder != Unbinder.EMPTY){
            unbinder.unbind();
        }
    }
}
