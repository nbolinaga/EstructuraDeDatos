/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

/**
 *
 * @author ricar
 */
public class ArbolB {
    private Nodo root;
    
    public ArbolB() {
        this.root = null;
    }

    public Nodo getRoot() {
        return root;
    }

    public void setRoot(Nodo root) {
        this.root = root;
    }
    
    public void addRoot(String info) {
        Nodo aux = new Nodo(info);
        root = aux;
    }
    
    public boolean isEmpty() { //revisa que el arbol este vacio
        return root == null;
    }
    
    public boolean isLeaf(Nodo node) {
        if(node != null) {
            if(node.getLeft() == null && node.getRight() == null) { //Si no tiene hijos se considera el nodo como hoja
            return true;
            }
        }
        return false;
    }
    
    public void addHijo(Nodo nuevo, Nodo actual, boolean confirmacion) {
        if(isEmpty()) { //Si el arbol no existe se crea usando el nodo aux
            root = nuevo;
        } else {
            if(confirmacion) { //Como se especifica el nodo padre (actual), se revisa el booleano y dependiendo de su valor pone el nodo a la derecha o izquierda
                nuevo.setPadre(actual);
                actual.setLeft(nuevo);
            } else {
                nuevo.setPadre(actual);
                actual.setRight(nuevo);
            }
        }
    }
    
    public Nodo actualizarNodo(String nuevo, Nodo antiguo) {
        antiguo.setInfo(nuevo); //Se actualiza el nodo con el nuevo string
        return antiguo;
    }
    
    public void actualizar(String respCorrecta, String newPreg, Nodo actual, int confirmar) {
        boolean confirm;
        if(confirmar == 0) { //Revisa el panel de confirmacion de la interfaz para revisar hacia donde debe poner el nodo nuevo
            confirm = true;
        } else {
            confirm = false;
        }
        Nodo temp = actual; //Se guarda el nodo en el que esta ubicado como temp
        Nodo respNueva = new Nodo(respCorrecta); //Se crea nuevo nodo con la informacion de la nueva respuesta
        Nodo preg = actualizarNodo(newPreg, actual); //Se llama a la funcion de actualizar el nodo para cambiarle el contenido
        addHijo(temp, preg, confirm); //Se agrega el hijo del nodo donde esta ubicado con el confirm para saber a que lado se agrega
        addHijo(respNueva, preg, !confirm); //Se agrega el otro hijo con el valor contrario de confirm para que quede del otro lado
    } 
    
    public void vaciarArbol() { //Vacia el arbol
        root = null;
    }
}
