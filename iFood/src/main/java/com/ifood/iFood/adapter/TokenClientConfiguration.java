package com.ifood.iFood.adapter;

import feign.codec.Encoder;
import feign.form.FormEncoder;
import org.springframework.context.annotation.Bean;

public class TokenClientConfiguration {

    @Bean
    public Encoder feignEncoder(){
        return new FormEncoder();
    }
}
