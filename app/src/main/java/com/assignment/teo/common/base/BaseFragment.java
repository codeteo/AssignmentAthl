package com.assignment.teo.common.base;

import android.support.v4.app.Fragment;

import com.assignment.teo.data.bus.BusProvider;

/**
 * Base class to be extended by all fragments in tabLayout
 */

public abstract class BaseFragment extends Fragment {

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


