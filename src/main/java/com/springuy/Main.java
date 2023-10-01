package com.springuy;

import com.springuy.ibgedataservice.adapter.handler.http.ConnectionServiceInjector;
import com.springuy.ibgedataservice.adapter.handler.http.Consumer;
import com.springuy.ibgedataservice.adapter.handler.http.IBGEConnectionServiceInjector;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        ConnectionServiceInjector injector = new IBGEConnectionServiceInjector();
        Consumer app = injector.getConsumer();
        
        Object data = app.retrieveData("/paises/indicadores/77819|77820", Object.class);
    }
}