package com.vladeks;

public class Gem {
    public enum Preciousness {
        PRECIOUSNESS, SEMIPRECIOUSNESS
    }

    public enum Color {
        COLORLESS, WHITE, BLACK, PINK, RED, BLUE, GREEN, YELLOW
    }

    public class VisualParameters {
        private Color color;
        private int transparency;
        private int diamondCut;

        public Color getColor() {
            return color;
        }

        public void setColor(Color color) {
            this.color = color;
        }

        public int getTransparency() {
            return transparency;
        }

        public void setTransparency(int transparency) {
            this.transparency = transparency;
        }

        public int getDiamondCut() {
            return diamondCut;
        }

        public void setDiamondCut(int diamondCut) {
            this.diamondCut = diamondCut;
        }

        @Override
        public String toString() {
            return "VisualParameters{" +
                    "color=" + color +
                    ", transparency=" + transparency +
                    ", diamondCut=" + diamondCut +
                    '}';
        }
    }

    private  String name;
    private Preciousness preciousness;
    private String origin;
    private VisualParameters  visualParameters = new VisualParameters();
    private int value;

    public Gem() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Preciousness getPreciousness() {
        return preciousness;
    }

    public void setPreciousness(Preciousness preciousness) {
        this.preciousness = preciousness;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public VisualParameters getVisualParameters() {
        return visualParameters;
    }

    public void setVisualParameters(VisualParameters visualParameters) {
        this.visualParameters = visualParameters;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Color getColor() {
        return visualParameters.getColor();
    }

    public void setColor(Color color) {
        visualParameters.setColor(color);
    }

    public int getTransparency() {
        return visualParameters.getTransparency();
    }

    public void setTransparency(int transparency) {
        visualParameters.setTransparency(transparency);
    }

    public int getDiamondCut() {
        return visualParameters.getDiamondCut();
    }

    public void setDiamondCut(int diamondCut) {
        visualParameters.setDiamondCut(diamondCut);
    }


    @Override
    public String toString() {
        return "Gem{" +
                "name='" + name + '\'' +
                ", preciousness=" + preciousness +
                ", origin='" + origin + '\'' +
                ", visualParameters=" + visualParameters.toString() +
                ", value=" + value +
                '}';
    }
}
