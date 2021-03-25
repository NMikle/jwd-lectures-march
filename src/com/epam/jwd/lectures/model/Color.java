package com.epam.jwd.lectures.model;

public enum Color {
    //        public static final Color BLUE;
    RED("FF0000"),
    GREEN("00FF00"),
    BLUE("0000FF"),
    WHITE("000000");

    private final String hexValue;

    Color(String hexValue) {
        System.out.println("Initialised " + name());
        this.hexValue = hexValue;
    }

    public String getHexValue() {
        return hexValue;
    }

    public static Color of(String hexValue) {
        System.out.println("in Color.of method");
        for (Color color : values()) {
            if (color.getHexValue().equalsIgnoreCase(hexValue)) {
                return color;
            }
        }
        throw new IllegalArgumentException(String.format("Wrong hex value for enum Color: %s", hexValue));
    }
}
