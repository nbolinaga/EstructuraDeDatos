/**
 *
 * @author ricardo micale
 */

public class ListaCliente {
    Nodo first;
    Nodo last;
    int size;

    public ListaCliente() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }
    
    class Nodo {
        Cliente dato;
        Nodo siguiente;
        
        public Nodo(Cliente dato){
            this.dato = dato;
            this.siguiente = null;
        }

        public Cliente getDato() {
            return dato;
        }

        public void setDato(Cliente dato) {
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
    //Retorna el indice del elemento que se pone de parametro
    public int getIndice(Cliente elemento){
        if (isEmpty()){
            return -1;
        }else{
            int indice = 0;
            Nodo aux = first;
            while (aux.getDato() != elemento && aux.getSiguiente() != null){
                aux = aux.getSiguiente(); //Siguiente dato en la lista
                indice++; //Se suma 1
            }
            if (aux.dato == elemento){
                return indice;
            }else{
                return -1; //No existe el elemento ingresado
            }
        }
    }
    
    public void addFinal(Cliente persona){
        Nodo nuevo = new Nodo(persona);
        if (isEmpty()){
            first = last = nuevo;
        }else{
            Nodo aux = first;
            while (aux.getSiguiente() != null){
                aux = aux.getSiguiente(); // busca el final de la lista
            }
            aux.setSiguiente(nuevo);
            last = nuevo;
        }
        size++;
    }
    
    public Cliente indexValue(int n){
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
