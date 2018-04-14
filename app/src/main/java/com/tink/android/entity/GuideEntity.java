package com.tink.android.entity;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.google.gson.annotations.SerializedName;

public class GuideEntity implements MultiItemEntity{

    @SerializedName("title")
    public String title;
    @SerializedName("content")
    public String content;
    @SerializedName("url")
    public String url;
    @SerializedName("type")
    public int type;

    @Override
    public int getItemType() {
        return type;
    }
}
