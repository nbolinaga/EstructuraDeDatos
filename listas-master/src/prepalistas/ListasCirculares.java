package prepalistas;

public class ListasCirculares {
    Nodo head;
    Nodo tail;
    int size;
    
    class Nodo {
        Object data;
        Nodo next;
        
        public Nodo(Object data){
            this.data = data;
            this.next = null;
        }
        
    }
    
    public boolean isEmpty(){
        return head == null;
    }
    
    public void insertFirst(Object data){
        Nodo temp = new Nodo(data);
        
        if(isEmpty()){
            head = temp;

        }
        else{
            if(size == 1){
                tail = head;
                head = temp;
                head.next = tail;
                tail.next = head;
            }
            else{
                Nodo aux = head;
                head = temp;
                temp.next = aux;
                tail.next = head;
            }
           
        }
        size++;
    }
    
    public void insertLast(Object data){
        Nodo temp = new Nodo(data);
        
        if(isEmpty()){
            head = temp;
        }
        else{
            if(size == 1){
                tail = temp;
                tail.next = head;
                head.next = tail;
            }
            else{
               Nodo aux = tail;
                tail = temp;
                tail.next = head;
                aux.next = tail; 
            }
            
        }
        size++;
    }
    
    public void removeElement(Object elem){
        if(isEmpty()){
            return;
        }
        Nodo aux = head;
        Nodo aux2 = null;
        for (int i = 0; i < size; i++) {
            if(aux.data == elem){
                if(aux2 != null){
                    if(aux == tail){
                        tail = aux2;
                        tail.next = head;
                        aux.next = null;
                    }
                    else{
                        aux2.next = aux.next;
                        aux.next = null;
                    }
                }
                else{
                    head = aux.next;
                    tail.next = head;
                    aux.next = null;
                }
                size--;
                return;
            }
            aux2 = aux;
            aux = aux.next;
        }
        
        System.out.println("No se encontro el elemento " + elem);
    }
    
    public void printList(){
        int i = 0;
        Nodo aux = head;
        while(i < size){
            System.out.print(aux.data + " -> ");
            aux = aux.next;
            i++;
        }
    }
}
