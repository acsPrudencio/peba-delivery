package br.com.pebas.pebasdelivery.Utils;

public class StringUsefulMethods {
    public static String removeNonNumber(String value){
        return value.replaceAll("[^0-9]", "");
    }
}
