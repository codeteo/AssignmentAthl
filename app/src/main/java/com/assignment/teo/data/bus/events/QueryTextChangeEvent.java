package com.assignment.teo.data.bus.events;

/**
 * Event to notify all interested components about a change on search's query text.
 */

public class QueryTextChangeEvent {

    private String queryText;

    public QueryTextChangeEvent(String queryText) {
        this.queryText = queryText;
    }

    public String getQueryText() {
        return queryText;
    }

    public void setQueryText(String queryText) {
        this.queryText = queryText;
    }
}
