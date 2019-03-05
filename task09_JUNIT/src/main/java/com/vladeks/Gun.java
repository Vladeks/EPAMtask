package com.vladeks;

public class Gun {
    protected final static int model = 1234;
    public int[] handy = {1,2};
    private String origin;
    private String material;
    private String ttc;

    public static int getModel() {
        return model;
    }

    public int[] getHandy() {
        return handy;
    }

    public void setHandy(int[] handy) {
        this.handy = handy;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getTtc() {
        return ttc;
    }

    public void setTtc(String ttc) {
        this.ttc = ttc;
    }
}
