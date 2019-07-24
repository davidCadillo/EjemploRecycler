package com.tecavi.net;

import com.tecavi.clases.WrapperMago;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MagoAPI {

    @GET("characters")
    Call<ArrayList<WrapperMago>> loadMago();




}
