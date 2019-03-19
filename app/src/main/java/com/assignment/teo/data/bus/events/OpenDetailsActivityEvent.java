package com.assignment.teo.data.bus.events;

import com.assignment.teo.features.search.enums.TypesEnum;

public class OpenDetailsActivityEvent {

    private String imageUrl;
    private String title;
    private String overview;
    private int genreId;
    private TypesEnum type;

    public OpenDetailsActivityEvent(String imageUrl, String title,
                                    String overview, int genreId, TypesEnum type) {
        this.imageUrl = imageUrl;
        this.title = title;
        this.overview = overview;
        this.genreId = genreId;
        this.type = type;
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

    public TypesEnum getType() {
        return type;
    }

    public void setType(TypesEnum type) {
        this.type = type;
    }
}
