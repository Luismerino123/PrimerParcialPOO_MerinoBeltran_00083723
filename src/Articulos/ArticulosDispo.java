package Articulos;

import Inentario.Articulos;

public abstract class ArticulosDispo extends Articulos  {
    private String tipo;
    protected float precioBase;

    public ArticulosDispo(Articulos articulos, String tipo, float precioBase) {
        super(articulos);
        this.tipo = tipo;
        this.precioBase = precioBase;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public float getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(float precioBase) {
        this.precioBase = precioBase;
    }
}
