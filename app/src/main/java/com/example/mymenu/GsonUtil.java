package com.example.mymenu;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public class GsonUtil
{
    public static <T> T parseJsonWithGson(String jsonData , Class<T> tClass)
    {
        Gson gson = new Gson();
        T result = gson.fromJson(jsonData, tClass);
        return result;
    }

    public static <T> List<T> parseJsonArrayWithGson(String jsonData, Class<T> type)
    {
        Gson gson = new Gson();
        List<T> result = gson.fromJson(jsonData, new TypeToken<List<T>>() {}.getType());
        return result;
    }
}
