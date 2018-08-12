package com.example.mymenu;


import java.util.List;

public class Client_All
{
    private String resultcode;
    private String reason;
    private RESULT result;
    private String error_code;

    public class RESULT
    {
        private List<DATA> data;
        private String totalNum;
        private String pn;
        private String rn;


        public class DATA
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

            public String[] getAlbums()
            {
                return albums;
            }

            public void setAlbums(String[] albums)
            {
                this.albums = albums;
            }

            private List<Steps> steps;

            public List<Steps> getSteps()
            {
                return steps;
            }

            public void setSteps(List<Steps> steps)
            {
                this.steps = steps;
            }

        }

        public List<DATA> getData()
        {
            return data;
        }

        public void setData(List<DATA>data)
        {
            this.data = data;
        }

    }

    public String getresultcode()
    {
        return resultcode;
    }

    public void setresultcode(String resultcode)
    {
        this.resultcode = resultcode;
    }

    public String getReason()
    {
        return reason;
    }

    public void setReason(String reason)
    {
        this.reason = reason;
    }

    public RESULT getResult()
    {
        return result;
    }

    public void setResult(RESULT result)
    {
        this.result = result;
    }

}
