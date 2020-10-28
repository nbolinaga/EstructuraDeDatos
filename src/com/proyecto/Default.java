package com.proyecto;

public class Default {
    public Lista<Ciudad> listaCiudades = new Lista();
    public Lista<Camino> listaCaminos = new Lista();

    public void Settings(){
        // se crean las primeras 4 ciudades; nido,comida y dos ciudades temporales (de manera de cumplir el minimo de 4)
        Ciudad comida = new Ciudad(0, "Comida");
        Ciudad nido = new Ciudad(1, "Nido");
        Ciudad ciudad1 = new Ciudad(2, "Ciudad 1");
        Ciudad ciudad2 = new Ciudad(3, "Ciudad 2");

        // se agregan las ciudades creadas a una lista llamada "ciudades"
        listaCiudades.insertar(comida);
        listaCiudades.insertar(nido);
        listaCiudades.insertar(ciudad1);
        listaCiudades.insertar(ciudad2);

        // se crean los primeros caminos (estos son temporales)
        Camino uno = new Camino(nido, ciudad1, 10);
        Camino dos = new Camino(nido, ciudad2, 15);
        Camino tres = new Camino(ciudad1, comida, 24);
        Camino cuatro = new Camino(ciudad2, comida, 18);
        Camino cinco = new Camino(ciudad1, ciudad2 , 20);

        // se agregan los caminos creados a una lista llamada "caminos"
        listaCaminos.insertar(uno);
        listaCaminos.insertar(dos);
        listaCaminos.insertar(tres);
        listaCaminos.insertar(cuatro);
        listaCaminos.insertar(cinco);
    }
}
