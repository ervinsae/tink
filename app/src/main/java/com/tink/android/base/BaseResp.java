package com.tink.android.base;

import android.support.annotation.Nullable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BaseResp<T> {
    @Expose
    @SerializedName("code")
    public int code;
    @Expose
    @SerializedName("msg")
    public String msg;

    @Nullable
    @Expose
    @SerializedName("data")
    public T t;
}
