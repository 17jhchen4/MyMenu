package com.example.mymenu;

import java.io.Serializable;

public class Steps implements Serializable
{
    private String img;
    private String step;

    public String getImg()
    {
        return img;
    }

    public void setImg(String img)
    {
        this.img = img;
    }

    public String getStep()
    {
        return step;
    }

    public void setStep(String step)
    {
        this.step = step;
    }
}
