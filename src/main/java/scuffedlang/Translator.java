package main.java.scuffedlang;
public class Translator {
    public static void main(String[] args) throws Exception {
        GUI gui = new GUI(new Converter());
        gui.start();
    }
}