package prepalistas;

public class ListasDobles {
    Nodo head;
    Nodo tail;
    int size;
    
    class Nodo {
        Object data;
        Nodo next;
        Nodo prev;
        
        public Nodo(Object data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    
    public boolean isEmpty(){
        return head == null;
    }
    
    public void insertFirst(Object data){
        Nodo temp = new Nodo(data);
        
        if(head == null){
            head = temp;
            tail = temp;
            head.next = tail;
            tail.prev = head;
            
        }
        else{
            Nodo aux = head;
            head = temp;
            head.next = aux;
            aux.prev = head;
        }
        size++;
    }
    
    public void insertLast(Object data){
        Nodo temp = new Nodo(data);
        
        if(head == null){
            head = temp;
            tail = temp;
            head.next = tail;
            tail.prev = head;
        }
        else{
            Nodo aux = tail;
            tail = temp;
            tail.prev = aux;
            aux.next = tail;
        }
        size++;
    }
    
    public void removeElement(Object elem){
        if(head == null){
            return;
        }
        
        Nodo temp = head;
        while(temp != null){
            if(temp.data == elem){
                if(head == temp){
                    Nodo nextOne = temp.next;
                    head = nextOne;
                    head.prev = null;
                    temp.next = null;
                }
                else if(tail == temp){
                    Nodo prevOne = temp.prev;
                    tail = prevOne;
                    tail.next = null;
                    temp.prev = null;
                }
                else{
                    Nodo prevOne = temp.prev;
                    Nodo nextOne = temp.next;
                    prevOne.next = nextOne;
                    nextOne.prev = prevOne;
                    temp.next = null;
                temp.prev = null;
                }
                
                size--;
                return;
            }
            temp = temp.next;
        }
        
        System.out.println("No se encontró el elemento " + elem);
    }
    
    public void printList(){
        Nodo aux = head;
        while(aux != null){
            System.out.print(aux.data + " <-> ");
            aux = aux.next;
        }
    }
}
