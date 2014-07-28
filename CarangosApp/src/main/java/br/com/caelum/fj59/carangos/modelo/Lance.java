package br.com.caelum.fj59.carangos.modelo;

import java.util.Calendar;

/**
 * Created by erich on 8/8/13.
 */
public class Lance implements Comparable<Lance>{
    private Usuario usuario;
    private double valor;
    private Calendar horario;

    public Lance() {
    }

    public Lance(Usuario usuario, Calendar data, double valor) {
        this.usuario = usuario;
        this.horario = data;
        this.valor = valor;
    }

    @Override
    public String toString() {
        return this.usuario + " R$"+this.valor;
    }

    @Override
    public int compareTo(Lance o) {
        return o.horario.compareTo(this.horario);
    }

    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
    public Calendar getHorario() {
        return horario;
    }


}
