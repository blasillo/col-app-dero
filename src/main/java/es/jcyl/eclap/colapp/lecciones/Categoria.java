package es.jcyl.eclap.colapp.lecciones;

public enum Categoria {


    INTRODUCCION("Introducción", new Integer(5)),
    GENERAL("General", new Integer(100)),
    INYECTION("(A1) Inyección", new Integer(300));

    private String nombre;

    private Integer puntuacion;

    Categoria(String nombre, Integer punt) {
        this.nombre = nombre;
        this.puntuacion = punt;
    }

    public String getNombre () { return this.nombre; }
    public Integer getPuntuacion () { return this.puntuacion; }

}