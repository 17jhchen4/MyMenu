package com.example.mymenu;


import java.util.List;

public class Client_class
{
    private String resultcode;
    private String reason;
    private List<RESULT> result;

    public class RESULT
    {
        private String id;
        private String type;
        private String tid;

        public String getId()
        {
            return id;
        }

        public void setId(String id)
        {
            this.id = id;
        }

        public String getType()
        {
            return type;
        }

        public void setType(String type)
        {
            this.type = type;
        }

        public String getTid()
        {
            return tid;
        }

        public void setTid(String tid)
        {
            this.tid = tid;
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

    public List<RESULT> getResult()
    {
        return result;
    }

    public void setResult(List<RESULT> result)
    {
        this.result = result;
    }
}
