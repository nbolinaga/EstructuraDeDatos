package com.proyecto;

public class Matriz {
    // variables
    public int matriAdya[][];
    private Lista<Ciudad> ciudades;
    private Lista<Camino> caminos;
    private int numCiudades;
    private int numCaminos;

    // constructor
    public void Crear(Lista<Ciudad> ciudades, Lista<Camino> caminos) {
        this.ciudades = ciudades;
        this.caminos = caminos;
        this.numCiudades = ciudades.tamano();
        this.numCaminos = caminos.tamano();

        // se crea una matriz de dos dimensiones donde x, y son el numero de ciudades
        matriAdya = new int [numCiudades][numCiudades];

        // se recorren las dos listas
        for (int i = 0; i < numCiudades; i++) {
            for(int j = 0; j < numCaminos; j++){
                // si la ciudad de origen del camino es igual a la ciudad actual se crean dos puntos en la matriz ya que los caminos son bidireccionales
                if(caminos.obtener(j).origen == i){
                    matriAdya[i][caminos.obtener(j).destino] = caminos.obtener(j).distancia;
                    matriAdya[caminos.obtener(j).destino][i] = caminos.obtener(j).distancia;
                }
            }
        }

        // se imprime la matriz con dos for loops, uno recorre x y el otro y
        for(int i = 0; i < matriAdya.length; i++){
            System.out.print("\n");
            for(int j = 0; j < matriAdya.length; j++){
                System.out.print(" | ");
                if(matriAdya[i][j] == 0){
                    System.out.print("--");
                } else {
                    System.out.print(matriAdya[i][j]);
                }
            }
        }
    }
}
