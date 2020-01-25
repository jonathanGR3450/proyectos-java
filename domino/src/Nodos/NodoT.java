package Nodos;

import Listas.jugadores;

public class NodoT {
    private String nombre;
    private jugadores Lista;
    private NodoT Adelante;
    private NodoT Atras;
    public NodoT( String nombre, jugadores Lista ){
        this.nombre=nombre;
        this.Lista = Lista;
        this.Adelante = this.Atras = null;
    }
    public String GetNombre(){
        return this.nombre;
    }
    public NodoT getAdelante() {
        return Adelante;
    }
    public void setAdelante( NodoT Adelante ) {
        this.Adelante = Adelante;
    }
    public NodoT getAtras() {
        return Atras;
    }
    public void setAtras( NodoT Atras ) {
        this.Atras = Atras;
    }
    public jugadores getLista() {
        return Lista;
    }
    public void setLista( jugadores Lista ) {
        this.Lista = Lista;
    }
}
