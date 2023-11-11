package com.example.act_09_listview_personalizado;

public class GeometricFigure {
    private String name;
    private int imageResource;
    private String perimeterFormula;
    private String areaFormula;
    private String volumeFormula;

    public GeometricFigure(String name, int imageResource, String perimeterFormula, String areaFormula, String volumeFormula) {
        this.name = name;
        this.imageResource = imageResource;
        this.perimeterFormula = perimeterFormula;
        this.areaFormula = areaFormula;
        this.volumeFormula = volumeFormula;
    }

    public String getName() {
        return name;
    }

    public int getImageResource() {
        return imageResource;
    }

    public String getPerimeterFormula() {
        return perimeterFormula;
    }

    public String getAreaFormula() {
        return areaFormula;
    }

    public String getVolumeFormula() {
        return volumeFormula;
    }
}
