package com.vladeks.model;

public class VisualParameters {

    private String color;
    private Integer transparency;
    private Integer diamondCut;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getTransparency() {
        return transparency;
    }

    public void setTransparency(Integer transparency) {
        this.transparency = transparency;
    }

    public Integer getDiamondCut() {
        return diamondCut;
    }

    public void setDiamondCut(Integer diamondCut) {
        this.diamondCut = diamondCut;
    }

    @Override
    public String toString() {
        return "VisualParameters{" +
                "color='" + color + '\'' +
                ", transparency=" + transparency +
                ", diamondCut=" + diamondCut +
                '}';
    }
}
