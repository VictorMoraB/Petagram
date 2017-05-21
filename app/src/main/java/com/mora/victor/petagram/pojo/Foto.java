package com.mora.victor.petagram.pojo;

/**
 * Created by Victor on 20-May-17.
 */

public class Foto {

    private int Image;
    private int LikesCount;

    public Foto(int image , int likesCount){
        Image = image;
        LikesCount = likesCount;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    public int getLikesCount() {
        return LikesCount;
    }

    public void setLikesCount(int likesCount) {
        LikesCount = likesCount;
    }
}
