package com.mora.victor.petagram.pojo;

import java.util.ArrayList;

/**
 * Created by Victor on 14-May-17.
 */

public class Mascota {

    private String Name;
    private int Image;
    private int LikesCount;
    private ArrayList<Foto> fotosGaleria;


    //Maneter un constructor por defecto, en el cual los elementos se deben inicializar
    //a traves de los setters
    public  Mascota(){}

    public  Mascota(String name, int image, int likesCount){
        Name = name;
        Image = image;
        LikesCount = likesCount;
        crearFotosPerfilPrueba();
    }

    //por ahora todas las fotos de la galeria seran las mismas, igual a la de perfril ademas

    //agregar 12 fotos de perfil
    private void crearFotosPerfilPrueba(){

        ArrayList<Foto> fotos = new ArrayList<>();
        for(int i = 2; i< 20; i=i+2){
            fotos.add(new Foto(Image, i));
        }
        fotosGaleria = fotos;
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

    public ArrayList<Foto> getFotosGaleria() {
        return fotosGaleria;
    }

    public void setFotosGaleria(ArrayList<Foto> fotosGaleria) {
        this.fotosGaleria = fotosGaleria;
    }
}
