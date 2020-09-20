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
public class ListaCaminos {
    Nodo head;
    int size;
    
    class Nodo{
        Camino data;
        Nodo next;
        
        public Nodo(Camino data){
            this.data = data;
            this.next = null;
        }
    }
    
    public boolean isEmpty(){
        return head == null;
    }  
    public int getIndex(Camino elem){
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
    public void insertLast(Camino data){
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
    public Camino obtainValue(int n){

        if(head == null){
            return null;
        }
        else{
            if (n == 0){
                return head.data;
            }
            else if (n < size){
                int count = 0;
                Nodo aux = head;
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
    
}
