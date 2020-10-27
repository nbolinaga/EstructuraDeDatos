/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1;

/**
 *
 * @author ricar
 */
public class Camino {
    int origen, destino, distancia;
    public int cantidadFerormonas;

    public Camino (Ciudad origen, Ciudad destino, int distancia){
        this.origen = origen.id;
        this.destino = destino.id;
        this.cantidadFerormonas = 0;
        this.distancia = distancia;
    }
}
