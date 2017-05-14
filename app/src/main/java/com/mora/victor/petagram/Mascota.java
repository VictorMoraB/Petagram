package com.mora.victor.petagram;

/**
 * Created by Victor on 14-May-17.
 */

public class Mascota {

    private String Name;
    private int Image;
    private int LikesCount;

    //Maneter un constructor por defecto, en el cual los elementos se deben inicializar
    //a traves de los setters
    public  Mascota(){}

    public  Mascota(String name, int image, int likesCount){
        Name = name;
        Image = image;
        LikesCount = likesCount;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
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
