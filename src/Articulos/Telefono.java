package Articulos;

import Inentario.Articulos;
public class Telefono extends ArticulosDispo  {
    public Telefono(Articulos articulos, String tipo, float precioBase) {
        super(articulos, tipo, precioBase);
    }
    public float obtenerPrecio(){
        return precioBase;
    }
}
