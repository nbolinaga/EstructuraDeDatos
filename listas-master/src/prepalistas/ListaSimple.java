package prepalistas;

import javax.swing.JOptionPane;

/**
 *
 * @author carlo
 */
public class ListaSimple {
    
    Nodo head;
    int size;
    
    class Nodo{
        
        Object data;
        Nodo next;
        
        public Nodo(Object data){
            this.data = data;
            this.next = null;
        }
    }
    
    public boolean vacia(){
        return head == null;
    }
    
    public void insertarPrimero(Object data){
        Nodo temp = new Nodo(data);
        
        if(vacia()){
            head = temp;
        }
        else{
            temp.next = head;
            head = temp;
        }
        
        size++;
    }
    
    public void insertarUltimo(Object data){
        Nodo temp = new Nodo(data);
        
        if(vacia()){
            head = temp;
        } 
        else{
            Nodo aux = head;
            while(aux.next != null){
                aux = aux.next;
            }
            aux.next = temp;
        }
        
        size++;
    }
    
    public void añadir(){
        int num;
        int cuenta = 1;
        num = Integer.parseInt(JOptionPane.showInputDialog("Inserte el número de componentes que desea añadir a la lista."));
        for(int i=0;i<num;i++){
            Object data;
            data = JOptionPane.showInputDialog("Inserte el elemento número "+cuenta);
            insertarUltimo(data);
            cuenta ++;
        }
    }
    
    public void borrarElemento(Object elem){
        if(vacia()){
            return;
        }
        
        Nodo aux = head;
        Nodo aux2 = null;
        while(aux != null){
            if(aux.data == elem){
                if(aux2 != null){
                    if(aux.next != null){
                        Nodo temp = aux.next;
                        aux2.next = temp;
                        aux.next = null;
                    }
                    else{
                        aux2.next = null;
                    }    
                }
                else{
                    head = aux.next;
                    aux.next = null;
                    
                }
                size--;
                return;
            }
            aux2 = aux;
            aux = aux.next;
            
        }
        System.out.println("No se encontró el elemento");
    }

    public void print(){
        if(vacia()){
            return;
        }
        Nodo aux = head;
        while(aux != null){
            System.out.print(aux.data + " -> ");
            aux = aux.next;
        }
    }
    
    Nodo reverse(Nodo nodo){
        Nodo prev = null;
        Nodo curr = nodo;
        Nodo aux;
        while(curr != null){
            aux = curr.next;
            curr.next = prev;
            prev = curr;
            curr = aux;
        }
        head = prev;
        return prev;
    }
}
/* 
    public void imprimirVentana(){
        if(vacia()){
            return;
        }
        Nodo aux = head;
        while(aux != null){
            //Imprime por tantos nodos haya
            JOptionPane.showMessageDialog(null,aux.data + " -> ");
            aux = aux.next;
        }      
}
    */  