package com.assignment.teo.features.search;

/**
 * Contract class used for search feature {@link SearchActivity}.
 */

public interface SearchMVP {

    interface View {

        void showMessage(String message);

    }

    interface Presenter {

        void onLoadData();

    }

}
