package com.example.demo;

import cn.hutool.core.codec.Base64;
import org.springframework.stereotype.Service;

@Service
public class Base64Service {

    public String parse(String s) {
        return Base64.encode(s);
    }
}
