package com.assignment.teo.data.bus.events;

public class OpenDetailsActivityEvent {

    private String imageUrl;
    private String title;
    private String overview;
    private int genreId;

    public OpenDetailsActivityEvent(String imageUrl, String title, String overview, int genreId) {
        this.imageUrl = imageUrl;
        this.title = title;
        this.overview = overview;
        this.genreId = genreId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }
}
