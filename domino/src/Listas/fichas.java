package Listas;

import Nodos.NodoF;

public class fichas {
    private NodoF Inicio;
    private int Catidad;
    public fichas(){
        this.Catidad = 0;
        this.Inicio = null;
    }
    public NodoF getInicio() {
        return Inicio;
    }
    public int getCatidad() {
        return Catidad;
    }
    public void setInicio( NodoF Inicio ) {
        this.Inicio = Inicio;
    }
    private boolean vacia(){
        return ( this.getCatidad() == 0 );
    }
   /* public void insertarfichas(  int a, int b ){
        int [] valores= {a,b};
        NodoF nuevo = new NodoF( valores );
        if( this.vacia() ){
            this.setInicio( nuevo );
            this.Catidad++;
        }else{
            NodoF Aux = this.getInicio();
            while( Aux.getAdelante() != null )
                Aux =  Aux.getAdelante();
            nuevo.setAtras( Aux );
            Aux.setAdelante( nuevo );
            this.Catidad++;
        }
    }*/
    
    public void insertarfichas(int a, int b ) {
        int [] valores= {a,b};
        NodoF nuevo = new NodoF( valores );
        if (vacia()) {
            Inicio= nuevo;
            Inicio.setAdelante(Inicio);
            Inicio.setAtras(Inicio);
            this.Catidad++;
        } else {
            Inicio.getAtras().setAdelante(nuevo);
            nuevo.setAtras(Inicio.getAtras());
            nuevo.setAdelante(Inicio);
            Inicio.setAtras(nuevo);
            this.Catidad++;
        }
    }
    
    
    /*public void Mostrar(){
        if( !this.vacia() ){
            NodoF Aux = this.getInicio();
            while( Aux != null ){
                System.out.println( "["+Aux.getLista()[0]+","+Aux.getLista()[1]+"]\t" );
                System.out.println();
                Aux = Aux.getAdelante();
            }
        }else
            System.out.println( "vacia" );
    }*/
    
    public void Mostrar() {
        if (!vacia()) {
            NodoF recorrido = Inicio;
            for (int i = 0; i < this.Catidad; i++) {
                System.out.println( "["+recorrido.getLista()[0]+","+recorrido.getLista()[1]+"]\t" );
                recorrido = recorrido.getAdelante();
            }
        }
    }
}
