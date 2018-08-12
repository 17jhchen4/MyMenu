package com.example.mymenu;


import java.io.Serializable;
import java.util.List;

public class Client_1 implements Serializable
{
    private String id;
    private String title;
    private String tags;
    private String imtro;
    private String ingredients;
    private String burden;
    private String[] albums;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getTags()
    {
        return tags;
    }

    public void setTags(String tags)
    {
        this.tags = tags;
    }

    public String getImtro()
    {
        return imtro;
    }

    public void setImtro(String imtro)
    {
        this.imtro = imtro;
    }

    public String getIngredients()
    {
        return ingredients;
    }

    public void setIngredients(String ingredients)
    {
        this.ingredients = ingredients;
    }

    public String getBurden()
    {
        return burden;
    }

    public void setBurden(String burden)
    {
        this.burden = burden;
    }

    public String getAlbums()
    {
        return albums[0];
    }

    public void setAlbums(String[] albums)
    {
        this.albums = albums;
    }


//    public class Steps
//    {
//        private String img;
//        private String step;
//
//        public String getImg()
//        {
//            return img;
//        }
//
//        public void setImg(String img)
//        {
//            this.img = img;
//        }
//
//        public String getStep()
//        {
//            return step;
//        }
//
//        public void setStep(String step)
//        {
//            this.step = step;
//        }
//
//    }

    private List<Steps> steps;

    public  List<Steps> getSteps()
    {
        return steps;
    }

    public void setSteps(List<Steps> steps)
    {
        this.steps = steps;
    }

}
