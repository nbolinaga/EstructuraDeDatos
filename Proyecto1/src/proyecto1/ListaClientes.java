/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1;

/**
 *
 * @author ricardocuriel
 */
public class ListaClientes {
    Nodo head;
    int size;

    
    class Nodo{
        Cliente data;
        Nodo next;
        
        public Nodo(Cliente data){
            this.data = data;
            this.next = null;
        }
    }
    
    public boolean isEmpty(){
        return head == null;
    }  
    public int getIndex(Cliente elem){
        if(head == null){
            return -1;
        }
        else{
            int count = 0;
            Nodo aux = head;
            while (aux.data != elem && aux.next != null){
                aux = aux.next;
                count++;
            }
            if (aux.data == elem){
                return count;
            }
            else{
                return -1;
            }
        }
    }
    public void insertLast(Cliente data){
        Nodo temp = new Nodo(data);
        
        if(isEmpty()){
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
    
    public String imprimirLista(){
        String resultado ="";
        for (int i = 0; i < this.size; i++) {
               if (i<this.size-1) {
                   resultado += this.obtainValue(i).nombrecliente + "->";
               }else{
                   resultado += this.obtainValue(i).nombrecliente + "\n";
               }
           }
        
        return resultado;
    }
    public Cliente obtainValue(int n){

        if(head == null){
            return null;
        }
        else{
            if (n == 0){
                return head.data;
            }
            else if (n < size){
                int count = 0;
                ListaClientes.Nodo aux = head;
                while(count < n){
                    aux = aux.next;
                    count++;
                }
                return aux.data;
            }
            else{
                return null;
            }
        }
    }
    public void removeElement(Cliente elem){
        if(isEmpty()){
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
}
