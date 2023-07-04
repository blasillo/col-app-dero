package es.jcyl.eclap.colapp.utiles;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RespuestaGenerica <T> {

    @JsonProperty("contenido")
    private T contentenido;


    @JsonProperty("esValido")
    private boolean esValido;


    public RespuestaGenerica(T contentenido, boolean esValido) {
        this.contentenido = contentenido;
        this.esValido = esValido;
    }

    public RespuestaGenerica(){}


    public T getContentenido() {
        return contentenido;
    }

    public boolean isEsValido() {
        return esValido;
    }

    public void setContentenido(T contentenido) {
        this.contentenido = contentenido;
    }

    public void setEsValido(boolean esValido) {
        this.esValido = esValido;
    }
}
