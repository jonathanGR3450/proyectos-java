/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoci;

/**
 *
 * @author PERSONAL
 */
class Nodo {

    private Nodo siguiente, anterior;
    private String dato;

    public Nodo(String dato) {
        this.dato = dato;
        siguiente = anterior = null;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }

    public Nodo getSiguiente() {
        return (siguiente);
    }

    public Nodo getAnterior() {
        return (anterior);
    }

    public String getDato() {
        return (dato);
    }
}

public class ListaCircular {

    private Nodo primero;

    public ListaCircular() {
        primero = null;
    }

    public boolean vacio() {
        return (primero == null);
    }

    public void insertarCabeza(String dato) {
        Nodo nuevo = new Nodo(dato);
        if (vacio()) {
            primero = nuevo;
            primero.setSiguiente(primero);
            primero.setAnterior(primero);
        } else {
            nuevo.setSiguiente(primero);
            primero.getAnterior().setSiguiente(nuevo);
            nuevo.setAnterior(primero.getAnterior());
            primero.setAnterior(nuevo);
            primero = nuevo;
        }
    }

    public void insertarCola(String dato) {
        Nodo nuevo = new Nodo(dato);
        if (vacio()) {
            primero = nuevo;
            primero.setSiguiente(primero);
            primero.setAnterior(primero);
        } else {
            primero.getAnterior().setSiguiente(nuevo);
            nuevo.setAnterior(primero.getAnterior());
            nuevo.setSiguiente(primero);
            primero.setAnterior(nuevo);

        }
    }

    public void insertar(int posicion, String dato) {
        if (posicion > 0 && posicion <= (cantidad() + 1)) {
            if (posicion == 1) {
                insertarCabeza(dato);
            } else if (posicion == cantidad() + 1) {
                insertarCola(dato);
            } else {
                Nodo nuevo = new Nodo(dato);
                Nodo recorrido = primero;
                for (int i = 1; i < posicion ; i++) {
                    recorrido = recorrido.getSiguiente();
                }
                nuevo.setSiguiente(recorrido);
                recorrido.getAnterior().setSiguiente(nuevo);
                nuevo.setAnterior(recorrido.getAnterior());
                recorrido.setAnterior(nuevo);
            }
        }
    }

    public String extraerCabeza() {
        String dato = "";
        if (!vacio()) {
            dato = primero.getDato();
            primero.getAnterior().setSiguiente(primero.getSiguiente());
            primero.getSiguiente().setAnterior(primero.getAnterior());
            primero = primero.getSiguiente();
        }
        return (dato);
    }

    public String extraerCola() {
        String dato = "";
        if (!vacio()) {
            dato = primero.getAnterior().getDato();
            primero.getAnterior().getAnterior().setSiguiente(primero);
            primero.setAnterior(primero.getAnterior().getAnterior());
        }
        return (dato);
    }

    public String extraer(int posicion) {
        String dato = "";
        if (posicion > 0 && posicion <= (cantidad() + 1)) {
            if (posicion == 1) {
                extraerCabeza();
            } else if (posicion == cantidad()) {
                extraerCola();
            } else {
                Nodo recorrer = primero;
                for (int i = 1; i < posicion - 1; i++) {
                    recorrer = recorrer.getSiguiente();
                }
                dato = recorrer.getSiguiente().getDato();
                recorrer.setSiguiente(recorrer.getSiguiente().getSiguiente());
                recorrer.getSiguiente().setAnterior(recorrer);
            }
        }
        return (dato);
    }

    public void modificarCabeza(String datos) {
        if (!vacio()) {
            extraerCabeza();
            insertarCabeza(datos);
        }
    }

    public void modificarCola(String datos) {
        if (!vacio()) {
            extraerCola();
            insertarCola(datos);
        }
    }

    public void modificar(int posicion, String datos) {
        if (posicion > 0 && posicion <= cantidad() + 1) {
            if (!vacio()) {
                if (posicion == 1) {
                    modificarCabeza(datos);
                } else if (posicion == cantidad() + 1) {
                    modificarCola(datos);
                } else {
                    extraer(posicion);
                    insertar(posicion, datos);
                }
            }
        }
    }

    public int cantidad() {
        int cont = 0;
        if (!vacio()) {
            Nodo recorrido = primero;
            do {
                recorrido = recorrido.getSiguiente();
                cont++;
            } while (recorrido != primero);
        }
        return cont;
    }

    public void mostrar() {
        if (!vacio()) {
            Nodo recorrido = primero;
            for (int i = 0; i < cantidad(); i++) {
                System.out.print(recorrido.getDato() + " ");
                recorrido = recorrido.getSiguiente();
            }
        }
    }
}
