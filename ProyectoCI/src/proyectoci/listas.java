package proyectoci;


public class listas {
    private NodosD Inicio;
    private int cantidad;
    public listas(){
        this.Inicio = null;
        this.cantidad = 0;
    }
    private boolean vacia(){
        return ( this.getCantidad() == 0 );
    }
    public void setInicio(NodosD Inicio) {
        this.Inicio = Inicio;
    }
    public NodosD getInicio() {
        return Inicio;
    }
    public int getCantidad() {
        return cantidad;
    }
    public void insertarLista( String Dato ){
        NodosD nuevo = new NodosD( Dato );
        if( this.vacia() ){
            this.setInicio( nuevo );
            this.cantidad++;
        }else{
            NodosD Aux = this.getInicio();
            while( Aux.getAdelante() != null )
                Aux =  Aux.getAdelante();
            nuevo.setAtras( Aux );
            Aux.setAdelante( nuevo );
            this.cantidad++;
        }
    }
    public void Mostrar(){
        if( !this.vacia() ){
            NodosD Aux = this.getInicio();
            System.out.println( "null" );
            while( Aux != null ){
                System.out.print( " <--- " );
                System.out.print( "Dia: "+Aux.getDato()+"," );
                System.out.println( " ---> " );
                Aux = Aux.getAdelante();
            }
            System.out.println( "null" );
        }else
            System.out.println( "vacia" );
    }
}
