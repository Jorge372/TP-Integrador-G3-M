import PRODE.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Main {
    //Este programa recibe como dato la ubicacion de 2 archivos .CSV llamados pronostico y resultado, ubicados en la carpeta de ejecucion del mismo programa
    public static void main(String[] args) throws IOException {
        Path pronostico = Paths.get("pronostico.csv");
        Path resultado = Paths.get("resultado.csv");
        ArrayList<String> informacion = new ArrayList<>(); //Aca se almacenaran la informacion proveida por los archivos csv
        ArrayList<Equipo> equipos1 = new ArrayList<>(); //Aca se almacenaran los equipos 1 de los x partidos
        ArrayList<Equipo> equipos2 = new ArrayList<>(); //Aca se almacenaran los equipos 2 de los x partidos
        ArrayList<Partido> partidos = new ArrayList<>(); //Aca se almacenaran todos los partidos
        ArrayList<Pronostico> pronosticos = new ArrayList<>(); //Aca se almacenaran los pronosticos sobre los partidos de la persona

        //Se lee la informacion que contiene los resultados de los partidos
        for (String linea : Files.readAllLines(resultado)){
            informacion.add(linea);
            System.out.println(linea);
        }

        System.out.println("-------------------------------------------");

        //Creamos los equipos con la informacion obtenida
        for (int i=1;i<informacion.size();i++){
            equipos1.add(new Equipo(informacion.get(i).split(";")[0]));
        }

        for (int i=1;i<informacion.size();i++){
            equipos2.add(new Equipo(informacion.get(i).split(";")[3]));
        }

        //creamos los partidos con los equipos y los goles
        for (int i=0;i<equipos1.size();i++){
            partidos.add(new Partido(equipos1.get(i),equipos2.get(i)));
            partidos.get(i).setGoles1(Integer.parseInt(informacion.get(i+1).split(";")[1])); //Cargo los goles del equipo 1 del partido i
            partidos.get(i).setGoles2(Integer.parseInt(informacion.get(i+1).split(";")[2])); //Cargo los goles del equipo 2 del partido i
            partidos.get(i).setResultado(); //Una vez cargados los goles del partido i establezco el resultado del mismo
        }

        informacion.clear();
        //Ahora leemos la informacion de los pronosticos que hizo la persona
        for (String linea : Files.readAllLines(pronostico)){
            informacion.add(linea);
            System.out.println(linea);
        }

        System.out.println("-------------------------------------------");

        //Cargamos los pronosticos de cada uno de los partidos
        for (int i=0;i<partidos.size();i++){
            pronosticos.add(new Pronostico(partidos.get(i))); //le asignamos el partido sobre el cual hizo el pronostico
            pronosticos.get(i).setResultado(informacion.get(i+1).split(";")); //comparamos resultados
        }

        //creamos la ronda con todos los partidos
        Ronda ronda1= new Ronda();
        ronda1.setPartidos(partidos);

        //mostramos el resultado final
        for (int i=0;i<pronosticos.size();i++) {
            System.out.println("Encuentro nº"+(i+1)+": " + pronosticos.get(i));
            System.out.println("Resultado ("+partidos.get(i).getEquipo1()+ " - "+partidos.get(i).getEquipo2()+"): " + partidos.get(i).getResultado() +"\n");
        }
        System.out.println("    La persona sumo un total de "+ ronda1.getPuntos(pronosticos) +" PUNTO/S");


    }
}