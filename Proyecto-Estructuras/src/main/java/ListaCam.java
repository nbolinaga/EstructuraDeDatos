/**
 *
 * @author ricardo micale
 */

public class ListaCam {
    
    Nodo first;
    Nodo last;
    int size;

    public ListaCam() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }
    
    class Nodo {
        Camino dato;
        Nodo siguiente;
        
        public Nodo(Camino dato){
            this.dato = dato;
            this.siguiente = null;
        }
        //getters y setters de los nodos
        public Camino getDato() {
            return dato;
        }

        public void setDato(Camino dato) {
            this.dato = dato;
        }

        public Nodo getSiguiente() {
            return siguiente;
        }

        public void setSiguiente(Nodo siguiente) {
            this.siguiente = siguiente;
        }
        
    }
    
    public boolean isEmpty(){
        return first == null;
    }
    //retorna el indice del elemento dado
    public int getIndice(Camino elemento){
        if (isEmpty()){
            return -1; //Indice por defecto de una lista vacia
        }else{
            int indice = 0;
            Nodo aux = first;
            while (aux.getDato() != elemento && aux.getSiguiente() != null){
                aux = aux.getSiguiente(); 
                //El nodo auxiliar cambia al valor siguietne despues de la iteracion
                indice++;
                //se le suma 1 a la variable indice
            }
            if (aux.dato == elemento){ 
            //Si el dato ingresado esta en la lista retrna el valor del indice al momento de romper el loop
                return indice;
            }else{ //Si el dato no esta en la lista de caminos
                return -1;
            }
        }
    }
    
    public void addFinal(Camino dato){
        Nodo nuevo = new Nodo(dato);
        if (isEmpty()){
            first = last = nuevo;
        }else{
            Nodo aux = first;
            while (aux.getSiguiente() != null){
                aux = aux.getSiguiente(); // itera hasta el final de la lista
            }
            aux.setSiguiente(nuevo); 
            // en el ultimo elemento se agrega un nuevo nodo como nuevo elemento final usando el Nodo nuevo
            last = nuevo; //se redefine last como nuevo
        }
        size++; //El tamaño de la lista aumenta por cada elemento
    }
    
    public Camino indexValue(int n){
        if (isEmpty()){
            return null; //No hay elementos
        }else if (n > size){ //El indice que se ingreso es mayor al tamaño de la lista
            return null;
        }else{
            if (n == 0){ //Si es 0 es el primer elemento
                return first.getDato();
            }else{
                int cuenta = 0; //variable auxiliar para contar el indice
                Nodo aux = first; //Nodo auxiliar para navegar por la lista
                while (aux.getDato() != null){
                    if (cuenta == n){
                        //revisa la variable cuenta, si es igual al indice que se busca se para la iteracion
                        break;
                    }
                    aux = aux.getSiguiente(); //El nodo auxiliar cambia al siguiente cada iteracion
                    cuenta++; //Se suma 1 a la cuenta del indice cada iteracion
                    
                }
                return aux.getDato(); 
                //Cuando se rompe el while aux queda como el Nodo del indice que se busca
            }
        }
    }
}
