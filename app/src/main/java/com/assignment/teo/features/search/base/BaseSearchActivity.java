package com.assignment.teo.features.search.base;

import com.assignment.teo.common.base.BaseTransitionActivity;
import com.assignment.teo.data.bus.BusProvider;

public abstract class BaseSearchActivity extends BaseTransitionActivity {

    @Override
    public void onResume() {
        super.onResume();
        BusProvider.getInstance().register(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        BusProvider.getInstance().unregister(this);
    }
}
