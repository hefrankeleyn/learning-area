package com.hef.spittr.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hef.spittr.domain.Spitter;
import com.hef.spittr.service.SpittleService;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @Date 2019-04-22
 * @Author lifei
 */
@Component
public class SpittleServiceImpl implements SpittleService {

    /**
     *  原始的方法
     * @param id
     * @return
     */
    @Override
    public Spitter fetchSpitterById(Long id) {
        HttpClient httpClient = HttpClients.createDefault();
        HttpGet request = new HttpGet("http://localhost:8080/SpringRESTMessageConversionSpittr/spitters/" + id);
        request.setHeader("Accept", "application/json");
        try {
            HttpResponse response = httpClient.execute(request);
            HttpEntity entity = response.getEntity();
            // 使用
            ObjectMapper mapper = new ObjectMapper();
            InputStream content = entity.getContent();
            return mapper.readValue(content, Spitter.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public Spitter findSpitterById(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        Spitter spitter = null;
        // 方案一：
        /*Spitter spitter = restTemplate.getForObject("http://localhost:8080/SpringRESTMessageConversionSpittr/spitters/{id}",
                Spitter.class, id);*/
        // 方案二：
        Map<String, Long> urlVariables = new HashMap<>();
        urlVariables.put("id", id);
        spitter = restTemplate.getForObject("http://localhost:8080/SpringRESTMessageConversionSpittr/spitters/{id}",
                Spitter.class, urlVariables);
        return spitter;
    }

    @Override
    public Spitter getSpitterById(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        Spitter spitter = null;
        ResponseEntity<Spitter> response = restTemplate.getForEntity("http://localhost:8080/SpringRESTMessageConversionSpittr/spitters/{id}",
                Spitter.class, id);
        HttpStatus statusCode = response.getStatusCode();
        System.out.println(statusCode.toString());
        return response.getBody();
    }
}
