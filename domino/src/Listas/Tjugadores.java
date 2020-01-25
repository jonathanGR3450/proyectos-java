package Listas;

import Nodos.NodoT;

public class Tjugadores {
    private NodoT Inicio;
    private int Cantidad;
    public Tjugadores(){
        this.Cantidad = 0;
        this.Inicio = null;
    }
    public NodoT getInicio() {
        return Inicio;
    }
    public void setInicio( NodoT Inicio ) {
        this.Inicio = Inicio;
    }
    public int getCantidad() {
        return Cantidad;
    }
    private boolean vacia(){
        return ( this.getCantidad() == 0 );
    }
    
    
    public void insertarT(String f,jugadores dato) {
        NodoT nuevo = new NodoT (f,dato);
        if (vacia()) {
            Inicio= nuevo;
            Inicio.setAdelante(Inicio);
            Inicio.setAtras(Inicio);
            this.Cantidad++;
        } else {
            Inicio.getAtras().setAdelante(nuevo);
            nuevo.setAtras(Inicio.getAtras());
            nuevo.setAdelante(Inicio);
            Inicio.setAtras(nuevo);
            this.Cantidad++;
        }
    }
    public void Mostrar() {
        if (!vacia()) {
            NodoT recorrido = Inicio;
            for (int i = 0; i < Cantidad; i++) {
                System.out.println( "Jugador: "+recorrido.GetNombre());
                recorrido.getLista().Mostrar();
                recorrido = recorrido.getAdelante();
            }
        }
    }
    
    /*public void insertarT( String nombre, jugadores lista ){
        NodoT nuevo = new NodoT( nombre, lista );
        
        if( this.vacia() ){
            this.setInicio( nuevo );
            this.Cantidad++;
        }else{
            NodoT Aux = this.getInicio();
            while( Aux.getAdelante() != null )
                Aux =  Aux.getAdelante();
            nuevo.setAtras( Aux );
            Aux.setAdelante( nuevo );
            this.Cantidad++;
        }
    }*/
    /*public void Mostrar(){
        if( !this.vacia() ){
            NodoT Aux = this.getInicio();
            while( Aux != null ){
                System.out.println( "jugador: "+Aux.GetNombre());
                System.out.println();
                Aux.getLista().Mostrar();
                System.out.println();
                Aux = Aux.getAdelante();
            }
        }else
            System.out.println( "vacia" );
    }*/
}
