package com.hef.spittr.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hef.spittr.domain.Spitter;
import com.hef.spittr.service.SpittleService;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
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
            org.apache.http.HttpEntity entity = response.getEntity();
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

    @Override
    public void updateSpitter(Spitter spitter) {
        assert spitter.getId() != null;
        assert getSpitterById(spitter.getId()) != null;
        //updateSpitterObj(spitter);
        //updateSpitterObj02(spitter);
        updateSpitterObj03(spitter);
    }
    // 方案一：
    private void updateSpitterObj(Spitter spitter){
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/SpringRESTMessageConversionSpittr/spitters/updateSpitter/"
                + spitter.getId();
        restTemplate.put(URI.create(url), spitter);
    }

    //方案二：
    private void updateSpitterObj02(Spitter spitter){
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/SpringRESTMessageConversionSpittr/spitters/updateSpitter/{id}";
        restTemplate.put(url, spitter, spitter.getId());
    }
    // 方案三：
    private void updateSpitterObj03(Spitter spitter){
        RestTemplate restTemplate = new RestTemplate();
        Map<String, Long> params = new HashMap<>();
        params.put("id", spitter.getId());
        String url = "http://localhost:8080/SpringRESTMessageConversionSpittr/spitters/updateSpitter/{id}";
        restTemplate.put(url, spitter, params);
    }


    @Override
    public void deleteSpitterById(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/SpringRESTMessageConversionSpittr/spitters/deleteSpitter/{id}";
        restTemplate.delete(url, id);
    }

    @Override
    public Spitter saveSpitter(Spitter spitter) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/SpringRESTMessageConversionSpittr/spitters/saveSpitter";
        Spitter saveSpitter = restTemplate.postForObject(url, spitter, Spitter.class);
        return saveSpitter;
    }

    @Override
    public ResponseEntity<Spitter> saveSpitterEntity(Spitter spitter) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/SpringRESTMessageConversionSpittr/spitters/saveSpitter";
        ResponseEntity<Spitter> responseEntity = restTemplate.postForEntity(url, spitter, Spitter.class);
        return responseEntity;
    }

    @Override
    public String saveSpitterAndFetchLocation(Spitter spitter) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/SpringRESTMessageConversionSpittr/spitters/saveSpitter";
        URI uri = restTemplate.postForLocation(url, spitter);
        return uri.toString();
    }

    @Override
    public ResponseEntity<Spitter> findSpitterByIdByExchange(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/SpringRESTMessageConversionSpittr/spitters/{id}";
//        ResponseEntity<Spitter> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null, Spitter.class, id);

        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Accept", "application/json");
        HttpEntity<Object> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<Spitter> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Spitter.class, id);
        return responseEntity;
    }
}
