package Nodos;

import Listas.fichas;

public class NodoJ {
    private fichas Lista;
    private NodoJ Adelante;
    private NodoJ Atras;
    private int f;
    public NodoJ(int f , fichas Lista ){
        this.Lista = Lista;
        this.f=f;
        this.Adelante = this.Atras = null;
    }
    public int GetF(){
        return f;
    }
    public NodoJ getAdelante() {
        return Adelante;
    }
    public void setAdelante( NodoJ Adelante ) {
        this.Adelante = Adelante;
    }
    public NodoJ getAtras() {
        return Atras;
    }
    public void setAtras( NodoJ Atras ) {
        this.Atras = Atras;
    }
    public fichas getLista() {
        return Lista;
    }
    public void setLista( fichas Lista ) {
        this.Lista = Lista;
    }
}
