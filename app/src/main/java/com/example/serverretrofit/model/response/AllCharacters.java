package com.example.serverretrofit.model.response;

import java.util.Date;
import java.util.List;

public class AllCharacters {
    public Info info;
    public List<Character> results;

    public class Root{
        public Info info;
        public List<Character> results;
    }
}
