package main.java.scuffedlang;
public class Converter {
    private static final String BASE = "qwertyuiopasdfghjklzxcvbnm1234567890";
    private static final String SCUFFED = "poiuytrewqlkjhgfdsamnbvcxz0987654321";

    boolean flipped;

    public Converter() {
        flipped = false;
    }

    public String convert(String inText) {
        int atIndex = 0;
        String outText = "";
        Boolean uppercase = false;

        for (String s : inText.split("")) {
            // check if the string is uppercase by comparing it to a list of lovercase chars
            if (!BASE.contains(s)) uppercase = true;

            // translate the char
            if (!flipped) {
                atIndex = BASE.indexOf(s.toLowerCase());
                if (atIndex != -1) {
                    s = SCUFFED.substring(atIndex, atIndex + 1);
                }
            } else {
                atIndex = SCUFFED.indexOf(s.toLowerCase());
                if (atIndex != -1) {
                    s = BASE.substring(atIndex, atIndex + 1);
                }
            }

            // check if the char was uppercase, and if it was then make the new char uppercase
            if (uppercase) s = s.toUpperCase();

            // add char to text
            outText += s;

            uppercase = false;
        }

        return outText;
    }

    public void flip() {
        flipped = !flipped;
    }
}
