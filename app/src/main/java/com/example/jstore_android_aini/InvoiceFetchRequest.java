package com.example.jstore_android_aini;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

public class InvoiceFetchRequest extends StringRequest {
    private static final String BASE_URL = "http://192.168.43.212:8080/invoice";
    public InvoiceFetchRequest(int id, Response.Listener<String> listener){
        super(Method.GET, BASE_URL+id, listener, null);
    }
}
