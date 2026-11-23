package com.example.mid_exam_haytham_alsalmi_1320225082;


public class Artwork {

    private int imageResource;
    private String title;
    private String artist;
    private int year;
    private String websiteUrl;

    public Artwork(int imageResource, String title,
                   String artist, int year, String websiteUrl) {

        this.imageResource = imageResource;
        this.title = title;
        this.artist = artist;
        this.year = year;
        this.websiteUrl = websiteUrl;
    }

    public int getImageResource() {
        return imageResource;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public int getYear() {
        return year;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }
}
