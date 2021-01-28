package com.example.androidreto2.Retrofit;

import com.example.androidreto2.Interface.UsuarioAPI;
import com.example.androidreto2.Interface.UsuarioesAPI;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class UsuarioesFacadeREST {
    private static UsuarioesAPI API_SERVER;
    private static String BASE_URL = "http://192.168.20.157:8080/Reto2Servidor/webresources/";

    public static UsuarioesAPI getClient(){
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);


        OkHttpClient.Builder hatClient = new OkHttpClient.Builder();
        hatClient.addInterceptor(logging);


        if (API_SERVER == null){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(SimpleXmlConverterFactory.create())
                    .client(hatClient.build())
                    .build();
            API_SERVER = retrofit.create(UsuarioesAPI.class);
        }
        return API_SERVER;

    }
}
