package com.proyecto;

import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;
import org.graphstream.ui.view.Viewer;

public class Dibujar {

    public static void main(String args[]) {
        // se establece que forma de visualizar se usara, en este caso se utiliza swing
        System.setProperty("org.graphstream.ui", "swing");

        // se establecen las variables(Predeterminado, Matriz, Listas y Grafo)
        Default runDefault = new Default();
        Matriz matriz = new Matriz();
        Lista<Ciudad> ciudades = new Lista<>();
        Lista<Camino> caminos = new Lista<>();
        Graph grafo = new SingleGraph("Simulacion");

        // se establece los atributos de estilo
        grafo.setAttribute("ui.antialias");
        Css(grafo);
        Viewer viewer = grafo.display();
        viewer.disableAutoLayout();

        // se llama a las listas predeterminadas y se pasan a las variables
        runDefault.Settings();
        ciudades = runDefault.listaCiudades;
        caminos = runDefault.listaCaminos;

        // se crea y se imprime la matriz en la consola
        matriz.Crear(ciudades, caminos);
        System.out.println("\n");

        // se crear el grafo con dos for loops uno para cada dimension de la matriz
        for(int i = 0; i < matriz.matriAdya.length; i++){
            // se agregan las ciudades al grafo
            Node agregarCiudad = grafo.addNode(ciudades.obtener(i).nombre);
            agregarCiudad.setAttribute("ui.label", ciudades.obtener(i).nombre);
            for(int j = 0; j < matriz.matriAdya.length; j++){
                // se agregan los caminos al grafo
                if(matriz.matriAdya[i][j] != 0 && j < i) {
                    Edge agregarCamino = grafo.addEdge(ciudades.obtener(i).nombre + ciudades.obtener(j).nombre, ciudades.obtener(i).nombre, ciudades.obtener(j).nombre);
                    agregarCamino.setAttribute("ui.label", "Distancia: " + matriz.matriAdya[i][j]);
                }
            }
        }

				/*el if statement anterior evita que se creen caminos vacios y evita que se repitan los ya creados con j<i

				EJEMPLO;

				| 00 | 00 | 24 | 18
 				| 00 | 00 | 10 | 15
 				| 24 | 10 | 00 | 20
 				| 18 | 15 | 20 | 00

				| --- | --- |  24 |  18
 				| --- | --- |  10 |  15
 				| J<I | J<I | --- |  20
 				| J<I | J<I | J<I | --- */

        //se llama al metodo para mostrar el grafo
        grafo.display();
    }

    // no llamar metodo en caso de que este prohibido usar CSS
    // si no se llama este metodo, el grafo sera en blanco y negro pero igual corre
    private static void Css(Graph grafo){
        grafo.setAttribute("ui.stylesheet","graph {\n" +
                "\tfill-color: #9BC53D;\n" +
                "}\n" +
                "\n" +
                "node {\n" +
                "    text-background-mode: rounded-box;\n" +
                "    text-background-color: #697268;\n" +
                "    text-color: white;\n" +
                "    fill-color: #D1495B;\n" +
                "    text-style: bold;\n" +
                "    text-size: 10px;\n" +
                "    z-index: 100;\n" +
                "    text-alignment: under;\n" +
                "    text-padding: 5px;\n" +
                "}\n" +
                "edge {\n" +
                "    shape: line;\n" +
                "    fill-color: black;\n" +
                "    stroke-mode: dots;\n" +
                "    stroke-width: 1px;\n" +
                "    stroke-color: black;\n" +
                "    text-style: bold;\n" +
                "    text-offset: 0px, 20px;\n" +
                "    text-size: 10px;\n" +
                "    text-background-mode: rounded-box;\n" +
                "    text-alignment: along;\n" +
                "    text-padding: 5px;\n" +
                "}\n" +
                "\n" +
                "node:clicked {\n" +
                "\tfill-color: #2E86AB;\n" +
                "\ttext-size: 20px;\n" +
                "}");
    }
}