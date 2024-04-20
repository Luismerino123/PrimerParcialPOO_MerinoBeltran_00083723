package Inentario;

public class Articulos {
    private String nombre;
    private String modelo;
    private String descripcion;
    private float precio;

    public Articulos(){}

    public Articulos(String nombre, String modelo, String descripcion, float precio) {
        this.nombre = nombre;
        this.modelo = modelo;
        this.descripcion = descripcion;
        this.precio = precio;
    }
    public Articulos (Articulos articulos){
        nombre= articulos.nombre;
        modelo= articulos.modelo;
        descripcion= articulos.descripcion;
        precio=articulos.precio;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
}
