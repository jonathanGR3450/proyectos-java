package Nodos;


public class NodoF {
    //private int Nficha;
    private int [] Lista;
    private NodoF Adelante;
    private NodoF Atras;
    public NodoF( int [] Lista ) {
        this.Lista = Lista;
        this.Adelante = this.Atras = null;
    }
    /*public int getNficha() {
        return Nficha;
    }
    public void setNficha( int Nficha ) {
        this.Nficha = Nficha;
    }*/
    public int [] getLista() {
        return Lista;
    }
    public void setLista( int [] Lista ) {
        this.Lista = Lista;
    }
    public NodoF getAdelante() {
        return Adelante;
    }
    public void setAdelante( NodoF Adelante ) {
        this.Adelante = Adelante;
    }
    public NodoF getAtras() {
        return Atras;
    }
    public void setAtras( NodoF Atras ) {
        this.Atras = Atras;
    }
}
