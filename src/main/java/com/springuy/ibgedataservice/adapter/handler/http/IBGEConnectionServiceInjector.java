package com.springuy.ibgedataservice.adapter.handler.http;

public class IBGEConnectionServiceInjector implements ConnectionServiceInjector {
    @Override
    public Consumer getConsumer() {
        return new IBGEConsumer(new IBGEConnectionService());
    }
}
