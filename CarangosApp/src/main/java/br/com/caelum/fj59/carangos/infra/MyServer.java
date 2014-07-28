package br.com.caelum.fj59.carangos.infra;

public class MyServer {
    private static String uri = "http://carangos.herokuapp.com/%s";

    public static String uriFor(String value) {
        return String.format(uri, value);
    }
}
