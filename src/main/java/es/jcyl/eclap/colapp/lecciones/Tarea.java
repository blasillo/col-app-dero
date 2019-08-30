package es.jcyl.eclap.colapp.lecciones;

import java.util.*;

public class Tarea {

    private Long id;
    private String nombre;
    private String path;

    private List<String> pistas;


    public Tarea (String nombre, String path, List<String> pistas ) {
        this.nombre = nombre;
        this.path = path;
        this.pistas = pistas;
    }

    public Tarea (String nombre, String path ) {
        this( nombre, path , new ArrayList<String>() );
    }

    

}