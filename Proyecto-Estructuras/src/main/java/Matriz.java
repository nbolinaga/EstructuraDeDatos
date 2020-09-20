
import javax.swing.JOptionPane;
import java.util.*;
/**
 *
 * @author ricardo micale
 */

public class Matriz {
    
    int numClientes = 0;
    int numVertices = 0;
    ListaCliente clientes = new ListaCliente();
    ListaCam caminos = new ListaCam();
    int adjMatrix[][];
    
    public void Grafo(int vertice){
        this.numVertices = vertice;
        adjMatrix = new int[numVertices][numVertices];
    }
    
    public void agregarCliente(){
        int idCliente = numClientes + 1;
        String nombreCliente = JOptionPane.showInputDialog(null,"Nombre del cliente");
        while ("".equals(nombreCliente) || " ".equals(nombreCliente)){//|| Integer.parseInt(nombreCliente) == type()
            JOptionPane.showMessageDialog(null,"Nombre no valido, inglresar otro");
            nombreCliente = JOptionPane.showInputDialog(null,"Nombre del cliente");
        }
        if (nombreCliente != null){
            String urbanizacion = JOptionPane.showInputDialog(null,"Urbanizacion de la direccion");
            while ("".equals(urbanizacion) || " ".equals(urbanizacion)){
                JOptionPane.showMessageDialog(null,"Urbanizacion no valida, inglresar de nuevo");
                urbanizacion = JOptionPane.showInputDialog(null,"Urbanizacion de la direccion");
            }
            if (urbanizacion != null){
                String calle = JOptionPane.showInputDialog(null,"Calle de la direccion");
                while ("".equals(calle) || " ".equals(calle)){
                    JOptionPane.showMessageDialog(null,"Calle no valida, inglresar de nuevo");
                    calle = JOptionPane.showInputDialog(null,"Calle de la direccion");
                }
                if (calle != null){
                    JOptionPane.showMessageDialog(null,"Cliente agregado correctamente");
                    Cliente cliente = new Cliente(idCliente,nombreCliente,urbanizacion,calle);
                    clientes.addFinal(cliente);
                }
            }
        }
        numClientes++;
    }
    
    public void agregarCamino(){
        if (numClientes >= 2){
            int id[] = new int[numClientes];
            for (int i = 0; i < clientes.size; i++){
                id[i] = clientes.indexValue(i).idCliente;
            }
            int origen;
            origen = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el numero de id del cliente origen"));
            while(origen < 1){
                origen = Integer.parseInt(JOptionPane.showInputDialog(null,"Numero de id no valido, por favor ingresar de nuevo"));
            }
            if (origen > 0){
                int destino;
                destino = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el numero de id del cliente destino"));
                while(destino < 1 && destino != origen){
                    destino = Integer.parseInt(JOptionPane.showInputDialog(null,"Numero de id no valido, por favor ingresar de nuevo"));
                }
                if (destino > 0){
                    String distancia;
                    distancia = JOptionPane.showInputDialog("Ingrese la distancia entre ambos clientes");
                    while(!isInt(distancia) || Integer.parseInt(distancia) <= 0){
                        distancia = JOptionPane.showInputDialog("Distancia no valida. Ingrese la distancia entre ambos clientes");
                    }
                    boolean existe = false;
                    for (int k = 0; k < caminos.size; k++){
                        if (origen == caminos.indexValue(k).origen.idCliente && destino == caminos.indexValue(k).destino.idCliente){
                            existe = false;
                            break;
                        }
                    }
                    if (!existe){
                        JOptionPane.showMessageDialog(null, "El camino ingresado ya estaregistrado");
                    }else{
                        Cliente salida = null;
                        Cliente llegada = null;
                        int l = 0;
                        while (l < clientes.size){
                            if (clientes.indexValue(l).idCliente == origen){
                                salida = clientes.indexValue(l);
                            }
                            if (clientes.indexValue(l).idCliente == destino){
                                llegada = clientes.indexValue(l);
                            }
                            l++;
                        }
                        int peso = Integer.parseInt(distancia);
                        Camino aux = new Camino(salida,llegada,peso);
                        caminos.addFinal(aux);
                        adjMatrix[origen][destino] = 1;
                        JOptionPane.showMessageDialog(null, "Camino agregado exitosamente");
                    }
                }
            }
        }else{
            JOptionPane.showMessageDialog(null,"Debe agregar al menos 2 clientes para formar un camino");
        }
    }
    
    public boolean isInt(String x){
        try{
            Integer.parseInt(x);
        }catch (NumberFormatException e){
            return false;
        }
        return true;
    }
    
    public int[] caminoMasCorto(int inicio){
        if (caminos.isEmpty()){
            int[] distancia = new int[0];
            JOptionPane.showMessageDialog(null, "No hay caminos registrados todavía");
            return distancia;
        }else{
            int cuentaVertices = adjMatrix.length;
            boolean[] verticeVisitado = new boolean[cuentaVertices];
            int[] distancia = new int[cuentaVertices];
            for (int i = 0; i < cuentaVertices; i++){
                int j = encontrarDistancia(distancia, verticeVisitado);
                verticeVisitado[j] = true;
                for (int k = 0; k < cuentaVertices; k++){
                    if ((adjMatrix[j][k] < distancia[j]) && !verticeVisitado[k] && (adjMatrix[j][k] != 0) && (distancia[j] <distancia[j])){
                        distancia[k] = distancia[j] + adjMatrix[j][k];
                    }
                }
            }
            return distancia;
        }
    }
    
    public int encontrarDistancia(int[] distancia, boolean[] verticeVisitado){
        int minDistancia = Integer.MAX_VALUE;
        int distanciaMinima = -1;
        for (int i = 0; i < distancia.length; i++){
            if (!verticeVisitado[i] && distancia[i] < minDistancia){
                minDistancia = distancia[i];
                distanciaMinima = i;
            }
        }
        return distanciaMinima;
    }
    
}
