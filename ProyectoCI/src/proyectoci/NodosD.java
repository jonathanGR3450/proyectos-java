package proyectoci;
public class NodosD {
    private String dato;
    private NodosD Adelante;
    private NodosD Atras;
    public NodosD( String dato ){
        this.dato = dato;
        this.Adelante = this.Atras = null;
    }
    
    public String getDato() {
        return dato;
    }
    public void setDato( String dato ) {
        this.dato = dato;
    }
    public NodosD getAdelante() {
        return Adelante;
    }
    public void setAdelante( NodosD Adelante ) {
        this.Adelante = Adelante;
    }
    public NodosD getAtras() {
        return Atras;
    }
    public void setAtras( NodosD Atras ) {
        this.Atras = Atras;
    }
}
