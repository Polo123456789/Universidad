package com.poo2;

public class Mensaje {
    private String usuario;
    private String texto;

    public Mensaje(final String usuario, final String texto) {
        this.usuario = usuario;
        this.texto = texto;
    }

    @Override
    public String toString() {
        return usuario + ": " + texto;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(final String usuario) {
        this.usuario = usuario;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(final String texto) {
        this.texto = texto;
    }
}
