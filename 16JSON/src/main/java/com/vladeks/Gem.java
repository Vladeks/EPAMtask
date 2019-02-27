package com.vladeks;

public class Gem {

    public class VisualParameters {
        private String color;

        private String transparency;

        private String diamondCut;

        public String getColor ()
        {
            return color;
        }

        public void setColor (String color)
        {
            this.color = color;
        }

        public String getTransparency ()
        {
            return transparency;
        }

        public void setTransparency (String transparency)
        {
            this.transparency = transparency;
        }

        public String getDiamondCut ()
        {
            return diamondCut;
        }

        public void setDiamondCut (String diamondCut)
        {
            this.diamondCut = diamondCut;
        }

        @Override
        public String toString()
        {
            return "[color = "+color+", transparency = "+transparency+", diamondCut = "+diamondCut+"]";
        }
    }

    private String preciousness;

    private String origin;

    private String name;

    private VisualParameters visualParameters;

    private String value;

    public String getPreciousness ()
    {
        return preciousness;
    }

    public void setPreciousness (String preciousness)
    {
        this.preciousness = preciousness;
    }

    public String getOrigin ()
    {
        return origin;
    }

    public void setOrigin (String origin)
    {
        this.origin = origin;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public VisualParameters getVisualParameters ()
    {
        return visualParameters;
    }

    public void setVisualParameters (VisualParameters visualParameters)
    {
        this.visualParameters = visualParameters;
    }

    public String getValue ()
    {
        return value;
    }

    public void setValue (String value)
    {
        this.value = value;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [preciousness = "+preciousness+", origin = "+origin+", name = "+name+", visualParameters = "+visualParameters+", value = "+value+"]";
    }
}
