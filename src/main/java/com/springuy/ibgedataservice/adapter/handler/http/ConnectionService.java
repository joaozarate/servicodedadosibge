package com.springuy.ibgedataservice.adapter.handler.http;

import javax.net.ssl.HttpsURLConnection;

interface ConnectionService {

    HttpsURLConnection connect(String urlParameter);

}
