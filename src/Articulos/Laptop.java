package Articulos;

import Inentario.Articulos;

public class Laptop extends ArticulosDispo{

    public Laptop(Articulos articulos, String tipo, float precioBase) {
        super(articulos, tipo, precioBase);
    }
    public float obtenerPrecio(){
        return precioBase;
    }
}
