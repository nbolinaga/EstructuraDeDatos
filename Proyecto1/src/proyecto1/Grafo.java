/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
//import java.lang.System.Logger;
//import java.lang.System.Logger.Level;
import javax.swing.JOptionPane;
import java.awt.Graphics;
import java.awt.Color;

/**
 *
 * @author ricardocuriel
 */
public class Grafo {
    private int matriAdya[][];
    private int numClientes = 0;
    private ListaClientes listaClientes = new ListaClientes();
    private ListaCaminos listaCaminos = new ListaCaminos();

    public Grafo() {
        matriAdya = new int [numClientes][numClientes];
        for (int i = 0; i < numClientes; i++) {
            for (int j = 0; j < numClientes; j++) {
                matriAdya[i][j] = 0;
            }
            
        }
    }
    public void refrescarGrafo(){
        numClientes += 1;
        int matriAux[][] = new int[numClientes][numClientes];
        for (int i = 0; i < numClientes; i++) {
            for (int j = 0; j < numClientes; j++) {
                if(i == numClientes-1 || j == numClientes-1){
                    matriAux[i][j] = 0;
                }else{
                    matriAux[i][j] = matriAdya[i][j];
                }
                
            }
            
        }
        matriAdya = matriAux;
        
        for (int i = 0; i < matriAdya.length; i++) {
                        for (int j = 0; j < matriAdya.length; j++) {
                            System.out.print(matriAdya[i][j] + "\t");
                        }
                        System.out.println("");
                    }
   
    }
    
    public void agregarCliente(){
        int id = numClientes + 1;
        String nombreCliente = JOptionPane.showInputDialog(null,"Ingrese el nombre del cliente","Agregar nombre cliente",JOptionPane.INFORMATION_MESSAGE);
        while(nombreCliente.equals("")){
            JOptionPane.showMessageDialog(null,"Ingrese un nombre valido.","ERROR: Nombre invalido.",JOptionPane.ERROR_MESSAGE);
            nombreCliente = JOptionPane.showInputDialog(null,"Ingrese el nombre del cliente","Agregar nombre cliente",JOptionPane.INFORMATION_MESSAGE);
        }
        if(nombreCliente!=null){
            String urb = JOptionPane.showInputDialog(null,"Ingrese el nombre de la urbanizacion","Agregar nombre urbanizacion",JOptionPane.INFORMATION_MESSAGE);
            while(urb.equals("")){
                JOptionPane.showMessageDialog(null,"Ingrese un nombre valido.","ERROR: Nombre invalido.",JOptionPane.ERROR_MESSAGE);
                urb = JOptionPane.showInputDialog(null,"Ingrese el nombre de la urbanizacion","Agregar nombre de la urbanizacion.",JOptionPane.INFORMATION_MESSAGE);
            }
            if(urb!=null){
                String calle = JOptionPane.showInputDialog(null,"Ingrese el nombre de la calle/avenida","Agregar nombre de la calle/avenida",JOptionPane.INFORMATION_MESSAGE);
                while(calle.equals("")){
                    JOptionPane.showMessageDialog(null,"Ingrese un nombre valido.","ERROR: Nombre invalido.",JOptionPane.ERROR_MESSAGE);
                    calle = JOptionPane.showInputDialog(null,"Ingrese el nombre de la calle/avenida","Agregar nombre de la calle/avenida.",JOptionPane.INFORMATION_MESSAGE);
                }
                if(calle!=null){
                    //mensaje de exito
                    Cliente aux = new Cliente(id,nombreCliente,urb,calle);
                    // Si se puede validar que no sean iguales dos persones comparando los nodos 
                    listaClientes.insertLast(aux);
                    refrescarGrafo();
                    
                    
                }
            }
        }
        
        
    }
    public void agregarCamino(){
        if(numClientes>=2){
            String Clientes[] = new String [numClientes];
            for (int i = 0; i < numClientes; i++) {
                Clientes[i] = listaClientes.obtainValue(i).nombrecliente;
            }
            String origen = (String) JOptionPane.showInputDialog(null,"Ingrese el nombre del cliente de origen.","Agregar nombre cliente de origen.",JOptionPane.INFORMATION_MESSAGE,null,Clientes,Clientes[0]);
            if(origen!=null){
                String destino = (String) JOptionPane.showInputDialog(null,"Ingrese el nombre del cliente de destino.","Agregar nombre del cliente de destino.",JOptionPane.INFORMATION_MESSAGE,null,Clientes,Clientes[0]);
                if(destino!=null){
                    if (origen.equals(destino)) {
                        JOptionPane.showMessageDialog(null,"No se puede realizar.","ERROR: Mismo origen y destino.",JOptionPane.ERROR_MESSAGE);
                    }else{
                        String km = JOptionPane.showInputDialog(null,"Ingrese la cantidad de Km.","Agregar cantidad de Km.",JOptionPane.INFORMATION_MESSAGE);
                        while(km.equals("") || !isInteger(km)){
                            JOptionPane.showMessageDialog(null,"Ingrese un un kilometraje valido.","ERROR: Kilometraje invalido.",JOptionPane.ERROR_MESSAGE);
                            km = JOptionPane.showInputDialog(null,"Ingrese la cantidad de Km.","Agregar cantidad de Km.",JOptionPane.INFORMATION_MESSAGE);
                        }
                        if(km!=null){
              
                            boolean flag= true;
                            for (int i = 0; i < listaCaminos.size; i++) {
                                if (listaCaminos.obtainValue(i).origen.nombrecliente==origen && listaCaminos.obtainValue(i).destino.nombrecliente==destino) {
                                    flag = false;
                                    break;
                                }
                                
                            }
                            if (flag) {
                                Cliente clienteOrigen = null;
                                Cliente clienteDestino = null;
                                for (int i = 0; i < listaClientes.size; i++) {
                                    if (listaClientes.obtainValue(i).nombrecliente==origen) {
                                        clienteOrigen = listaClientes.obtainValue(i);
                                    }
                                    if (listaClientes.obtainValue(i).nombrecliente==destino) {
                                        clienteDestino = listaClientes.obtainValue(i);                                      
                                    }
                                }
                                int kmFinal = Integer.parseInt(km);
                                Camino aux = new Camino(clienteOrigen,clienteDestino,kmFinal);
                                listaCaminos.insertLast(aux);
                                addCamino(aux);
                                JOptionPane.showMessageDialog(null,"Camino Agregado.","Camino agregado.",JOptionPane.WARNING_MESSAGE);
                                for (int i = 0; i < matriAdya.length; i++) {
                        for (int j = 0; j < matriAdya.length; j++) {
                            System.out.print(matriAdya[i][j] + "\t");
                        }
                        System.out.println("");
                    }
                               
                            }else{
                                JOptionPane.showMessageDialog(null,"Este camino ya existe.","ERROR: Camino ya existe.",JOptionPane.ERROR_MESSAGE);
                            }
                        
                        }
                        
                    }
                    
                }
            }
        }else{
            JOptionPane.showMessageDialog(null,"No se encontro ningun cliente registrado.","ERROR: No existen clientes.",JOptionPane.ERROR_MESSAGE);
        }
        
}
    public boolean isInteger(String duracion){
            try{
                Integer.parseInt(duracion);
            }
            catch (NumberFormatException e){
                return false;
            }
            return true;
        }
    
    public void addCamino(Camino camino){
        Cliente origen = camino.origen;
        Cliente destino = camino.destino;
        int posOrigen = 0;
        int posDestino = 0;
        for (int i = 0; i < listaClientes.size; i++) {
            if (listaClientes.obtainValue(i)==origen) {
                posOrigen = i;
            }
            if (listaClientes.obtainValue(i)==destino) {
                posDestino = i;
            }            
        }
        matriAdya[posOrigen][posDestino] = 1;
    }
    
    public void actualizarArchivo(File file) throws IOException{
        String line;
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            
            bw.write("clientes");
            bw.newLine();
            for (int i = 0; i < listaClientes.size; i++) {
                line = listaClientes.obtainValue(i).id + ", " + listaClientes.obtainValue(i).nombrecliente + ", " + listaClientes.obtainValue(i).urb + ", " + listaClientes.obtainValue(i).calle;
                bw.write(line);
                bw.newLine();
            }
            bw.write("caminos");
            bw.newLine();
            for (int i = 0; i < listaCaminos.size; i++) {
                line = listaCaminos.obtainValue(i).origen.id + "," + listaCaminos.obtainValue(i).destino.id + "," + listaCaminos.obtainValue(i).km;
                bw.write(line);
                bw.newLine();
            }
            bw.close();   
    }
    public void posiblesRutas(){
        if (numClientes<2) {
           JOptionPane.showMessageDialog(null,"No se encontro el numero cliente registrados necesario.","ERROR:.",JOptionPane.ERROR_MESSAGE);
        }else{
            String Clientes[] = new String [numClientes];
            for (int i = 0; i < numClientes; i++) {
                Clientes[i] = listaClientes.obtainValue(i).nombrecliente;
            }
            String origen = (String) JOptionPane.showInputDialog(null,"Ingrese el nombre del cliente de origen.","Agregar nombre cliente de origen.",JOptionPane.INFORMATION_MESSAGE,null,Clientes,Clientes[0]);
            if(origen!=null){
                String destino = (String) JOptionPane.showInputDialog(null,"Ingrese el nombre del cliente de destino.","Agregar nombre del cliente de destino.",JOptionPane.INFORMATION_MESSAGE,null,Clientes,Clientes[0]);
                if(destino!=null){
                    if (origen.equals(destino)) {
                        JOptionPane.showMessageDialog(null,"No se puede realizar.","ERROR: Mismo origen y destino.",JOptionPane.ERROR_MESSAGE);
                    }else{
                        Cliente clienteOrigen = null;
                        Cliente clienteDestino = null;
                        for (int i = 0; i < listaClientes.size; i++) {
                            if (listaClientes.obtainValue(i).nombrecliente==origen) {
                                clienteOrigen = listaClientes.obtainValue(i);
                            }
                            if (listaClientes.obtainValue(i).nombrecliente==destino) {
                                clienteDestino = listaClientes.obtainValue(i);                                      
                            }
                        }
                        System.out.println(clienteOrigen.nombrecliente);
                        System.out.println(clienteDestino.nombrecliente);
                        System.out.println(numClientes);
                       
                        imprimirCamino(clienteOrigen, clienteDestino);
                    }
                }
            
        }
        }
    }
    
   public void imprimirCamino(Cliente origen, Cliente destino){
       ListaClientes rutas = new ListaClientes();
       boolean clientesVisitados[] = new boolean [numClientes];
       rutas.insertLast(origen);
       imprimirCaminos2(origen, destino, clientesVisitados, rutas);
   }
   public void imprimirCaminos2(Cliente origen, Cliente destino, boolean clientesVisitados[],ListaClientes rutas){
       String resultado = "";
       if (origen.equals(destino)) {
//           String aux = "";
           resultado = rutas.imprimirLista();
//         resultado = aux;
         clientesVisitados[listaClientes.getIndex(origen)] = false;
           System.out.println(resultado);
           return;
       }
       
       int posOrigen = -1;
       for (int i = 0; i < listaClientes.size; i++) {
           if (listaClientes.obtainValue(i) == origen) {
               clientesVisitados[i] = true;
               posOrigen = i;
               break;
           }
       }
       for (int i = 0; i < matriAdya.length; i++) {
           if (matriAdya[posOrigen][i] != 0 && !clientesVisitados[i]) {
               rutas.insertLast(listaClientes.obtainValue(i));
               imprimirCaminos2(listaClientes.obtainValue(i),destino,clientesVisitados,rutas);
               rutas.removeElement(listaClientes.obtainValue(i));
           }
       }
       clientesVisitados[posOrigen] = false;
    }
   public void paint(Graphics g){
       g.setColor(Color.CYAN);
       g.drawOval(200, 200,60 , 60);
   }
}
