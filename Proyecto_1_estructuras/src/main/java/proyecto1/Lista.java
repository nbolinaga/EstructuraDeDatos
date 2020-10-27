/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1;

/**
 *
 * @author ricar
 */
public class Lista<E> {
    Nodo primario;
    private int tamano;

    class Nodo {
	E data;
	Nodo siguiente;

	public Nodo(E data) {
            this.data = data;
            this.siguiente = null;
	}
    }
// --------------------------------------------------------------------------------------------
    public boolean isEmpty() {
        return primario == null;
    }
// --------------------------------------------------------------------------------------------
    // se crea un metodo de manera que la variable sea privada y no se pueda modificar por error.
    public int tamano(){
        return tamano;
    }
// --------------------------------------------------------------------------------------------
    // es necesario ?? 
    public int obtenerIndex(E elem) {
        if (primario == null) {
            return -1;
        } else {
            int count = 0;
            Nodo aux = primario;
            while (aux.data != elem && aux.siguiente != null) {
                aux = aux.siguiente;
                count++;
            }
            if (aux.data == elem) {
                return count;
            } else {
                return -1;
            }
        }
    }
// --------------------------------------------------------------------------------------------
    // inserta de ultimo 
    public void insertar(E data) {
        Nodo temp = new Nodo(data);

        if (isEmpty()) {
            primario = temp;
        } else {
            Nodo aux = primario;
            while (aux.siguiente != null) {
                aux = aux.siguiente;
            }
            aux.siguiente = temp;
        }

        tamano++;
    }
// --------------------------------------------------------------------------------------------
    // obtener elemento
    public E obtener(int n) {

        if (primario == null) {
            return null;
        } else {
            if (n == 0) {
                return primario.data;
            } else if (n < tamano) {
                int count = 0;
                Nodo aux = primario;
                while (count < n) {
                aux = aux.siguiente;
                count++;
                }
                return aux.data;
            } else {
                return null;
            }
        }
    }

// --------------------------------------------------------------------------------------------
    // faltaria eliminar elemento 
    //Eliminar elemento - revisar / faltaba restar 1 al tamano de la lista
    public void eliminar(E elemento) {
        if (isEmpty()) {
            return;
        } 
        Nodo aux = primario;
        Nodo aux2 = null;
        while (aux != null) {
            if (aux.data == elemento) {
                if (aux2 != null) {
                    if (aux.siguiente != null) {
                        Nodo temp = aux.siguiente;							
                        aux2.siguiente = temp;
                        aux.siguiente = null;
                        } else {
                            aux2.siguiente = null;
                        }
                } else {
                    primario = aux.siguiente;
                    aux.siguiente = null;
                }
                tamano--;
                return;	
            }
            aux2 = aux;
            aux = aux.siguiente;
        }
    }
}
