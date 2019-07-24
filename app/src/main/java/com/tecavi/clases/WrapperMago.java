package com.tecavi.clases;

public class WrapperMago extends Mago {

    public WrapperMago() {
        super();
    }

    @Override
    public String getGender() {
        return super.getGender().equals("male") ? "Masculino" : "Femenino";
    }
}
