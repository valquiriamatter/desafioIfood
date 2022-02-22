package com.ifood.iFood.client;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import feign.codec.Encoder;
import feign.form.FormEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;


public class TokenClientConfiguration implements RequestInterceptor{

    @Bean
    public Encoder feignEncoder(){
        return new FormEncoder();
    }

//    @Override
//    public void apply(RequestTemplate template) {
//
//        Autorizacao autorizacao = new Autorizacao();
//        template.header("Authorization", "Bearer" + autorizacao.getTokenAcesso());
//    }

    @Override
    public  void  apply (RequestTemplate requestTemplate) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //Add token
        requestTemplate.header( "Access-Token" , request.getHeader( "Access-Token" ));
    }



    }


//    @Bean
//    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
//        return new BasicAuthRequestInterceptor("49d292b20296473e9c1a71d6905e8ac6", "ff8490e260304c34a2b9c5ba402153d3");
//    }

//    @Autowired
//    public TokenClientConfiguration(Encoder encoder, Client client) {
//        this.tokenClient = Feign.builder().client(client)
//                .encoder(encoder)
//                .requestInterceptor(new BasicAuthRequestInterceptor("user", "user"));
////        this.adminClient = Feign.builder().client(client)
//                .encoder(encoder)
//                .decoder(decoder)
//                .contract(contract)
//                .requestInterceptor(new BasicAuthRequestInterceptor("admin", "admin"))
//                .target(FooClient.class, "http://PROD-SVC");







