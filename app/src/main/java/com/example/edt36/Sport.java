package com.example.edt36;

import java.util.ArrayList;
import java.util.List;

public class Sport {
    private String flag;
    private String textTitle;
    private String textDescription;
    private String webUrl;
    private ArrayList<String> images;

    public Sport() {
    }

    public Sport(String flag, String textTitle, String textDescription, String webUrl, ArrayList<String> images) {

        this.flag = flag;
        this.textTitle = textTitle;
        this.textDescription = textDescription;
        this.webUrl = webUrl;
        this.images = images;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getTextTitle() {
        return textTitle;
    }

    public void setTextTitle(String textTitle) {
        this.textTitle = textTitle;
    }

    public String getTextDescription() {
        return textDescription;
    }

    public void setTextDescription(String textDescription) {
        this.textDescription = textDescription;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    public ArrayList<String> getImages() {
        return images;
    }

    public void setImages(ArrayList<String> images) {
        this.images = images;
    }


}
