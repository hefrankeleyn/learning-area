package com.hef.spittr.jaxws;

import com.hef.spittr.jaxws.client.Spitter;
import com.hef.spittr.jaxws.client.SpitterService;
import com.hef.spittr.jaxws.client.SpitterServiceEndpoint;

/**
 * @Date 2019-04-20
 * @Author lifei
 */
public class SpitterClient {

    public static void main(String[] args) {
        SpitterService spitterService = new SpitterService();
        SpitterServiceEndpoint spitterServiceEndpointPort = spitterService.getSpitterServiceEndpointPort();
        Spitter spitter = spitterServiceEndpointPort.findSpitterById(1l);
        System.out.println(spitter);
    }
}
