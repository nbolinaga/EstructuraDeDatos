package com.proyecto;

public class Camino {
    int origen, destino, distancia;
    public int cantidadFerormonas;

    public Camino (Ciudad origen, Ciudad destino, int distancia){
        this.origen = origen.id;
        this.destino = destino.id;
        this.cantidadFerormonas = 0;
        this.distancia = distancia;
    }

    // for loop (i numero de camino)
    //  n = 1/numeroCiudades;
    // 	listaCamnios.obtener(i).cantidadFerormonas = n;
}
