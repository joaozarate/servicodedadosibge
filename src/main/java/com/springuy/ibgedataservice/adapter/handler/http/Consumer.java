package com.springuy.ibgedataservice.adapter.handler.http;

import java.lang.reflect.Type;

public interface Consumer {

    <T> T retrieveData(String urlParameter, Type typeOfT);

}
