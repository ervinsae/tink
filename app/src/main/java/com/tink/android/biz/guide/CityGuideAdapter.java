package com.tink.android.biz.guide;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.tink.android.R;
import com.tink.android.entity.GuideEntity;

import java.util.List;

public class CityGuideAdapter extends BaseMultiItemQuickAdapter<GuideEntity,BaseViewHolder> {
    public CityGuideAdapter(@Nullable List<GuideEntity> data) {
        super(data);
        addItemType(0, R.layout.adapter_image_item);
        addItemType(1,R.layout.adapter_image_text_item);
    }

    @Override
    protected void convert(BaseViewHolder helper, GuideEntity item) {
        switch (helper.getItemViewType()) {
            case 0:
                break;
            case 1:
                break;
        }
    }

}
