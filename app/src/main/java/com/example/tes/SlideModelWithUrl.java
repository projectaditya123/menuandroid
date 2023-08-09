package com.example.tes;

public class SlideModelWithUrl {
    private int imageRes;
    private String imageUrl;

    private String displayText;


    public SlideModelWithUrl(int imageRes, String imageUrl,String displayText) {
        this.imageRes = imageRes;
        this.imageUrl = imageUrl;
        this.displayText = displayText;
    }

    public int getImageRes() {
        return imageRes;
    }

    public String getImageUrl() {
        return imageUrl;
    }
    public String getDisplayText() {
        return displayText;
    }
}
