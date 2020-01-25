package Listas;

import Nodos.NodoJ;

public class jugadores {
    private NodoJ Inicio;
    private int Cantidad;
    public jugadores(){
        this.Cantidad = 0;
        this.Inicio = null;
    }
    public NodoJ getInicio() {
        return Inicio;
    }
    public void setInicio( NodoJ Inicio ) {
        this.Inicio = Inicio;
    }
    public int getCantidad() {
        return Cantidad;
    }
    private boolean vacia(){
        return ( this.getCantidad() == 0 );
    }
    /*public void insertarJugador( int f,fichas lista ){
        NodoJ nuevo = new NodoJ( f , lista );
        if( this.vacia() ){
            this.setInicio( nuevo );
            this.Cantidad++;
        }else{
            NodoJ Aux = this.getInicio();
            while( Aux.getAdelante() != null )
                Aux =  Aux.getAdelante();
            nuevo.setAtras( Aux );
            Aux.setAdelante( nuevo );
            this.Cantidad++;
        }
    }*/
    
    public void insertarJugador(int f,fichas dato) {
        NodoJ nuevo = new NodoJ (f,dato);
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
    public fichas extraerCabeza() {
        fichas dato = null;
        if (!vacia()) {
            dato = Inicio.getLista();
            Inicio.getAtras().setAdelante(Inicio.getAdelante());
            Inicio.getAdelante().setAtras(Inicio.getAtras());
            Inicio=Inicio.getAdelante();
            this.Cantidad--;
        }
        return (dato);
    }

    public fichas extraerCola() {
        fichas dato = null;
        if (!vacia()) {
            dato = Inicio.getAtras().getLista();
            Inicio.getAtras().getAtras().setAdelante(Inicio);
            Inicio.setAtras(Inicio.getAtras().getAtras());
            this.Cantidad--;
        }
        return (dato);
    }

    public fichas extraer(int posicion) {
        fichas dato = null;
        if (posicion > 0 && posicion <= (Cantidad + 1)) {
            if (posicion == 1) {
                extraerCabeza();
            } else if (posicion == Cantidad) {
                extraerCola();
            } else {
                NodoJ recorrer = Inicio;
                for (int i = 1; i < posicion - 1; i++) {
                    recorrer = recorrer.getAdelante();
                }
                dato = recorrer.getAdelante().getLista();
                recorrer.setAdelante(recorrer.getAdelante().getAdelante());
                recorrer.getAdelante().setAtras(recorrer);
                this.Cantidad--;
            }
        }
        return (dato);
    }
    
    
    public void Mostrar() {
        if (!vacia()) {
            NodoJ recorrido = Inicio;
            for (int i = 0; i < Cantidad; i++) {
                System.out.println( "ficha: "+recorrido.GetF());
                recorrido.getLista().Mostrar();
                recorrido = recorrido.getAdelante();
            }
        }
    }
    
    
    /*public void Mostrar(){
        if( !this.vacia() ){
            NodoJ Aux = this.getInicio();
            while( Aux != null ){
                System.out.println( "ficha: "+Aux.GetF());
                Aux.getLista().Mostrar();
                Aux = Aux.getAdelante();
            }
        }else
            System.out.println( "vacia" );
    }*/
}
