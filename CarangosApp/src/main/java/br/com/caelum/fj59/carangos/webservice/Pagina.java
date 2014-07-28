package br.com.caelum.fj59.carangos.webservice;

/**
 * Created by erich on 7/16/13.
 */
public class Pagina {
    private int tamanho = 25;
    private int numero = 0;

    public Pagina proxima() {
        Pagina proxima = new Pagina();
        proxima.numero = numero+1;
        proxima.tamanho = tamanho;

        return proxima;
    }

    @Override
    public String toString() {
        return String.format("pagina.tamanho=%d&pagina.numero=%d", this.tamanho, this.numero);
    }

    public int getInicio() {
        return numero * tamanho;
    }

    public int getFim() {
        return (numero+1)*tamanho;
    }

    public int getNumero() {
        return numero;
    }

    public int getTamanho() {
        return tamanho;
    }

}
