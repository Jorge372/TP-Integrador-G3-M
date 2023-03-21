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
        ArrayList<String> informacion = new ArrayList<>();

        for (String linea : Files.readAllLines(resultado)){
            informacion.add(linea);
            System.out.println(linea);
        }

        System.out.println("---------------------------------");

        String[] infoPartido1 = informacion.get(1).split(";");
        String[] infoPartido2 = informacion.get(2).split(";");

        Equipo equipo11 = new Equipo(infoPartido1[0]);
        Equipo equipo12 = new Equipo(infoPartido1[3]);
        Equipo equipo21 = new Equipo(infoPartido2[0]);
        Equipo equipo22 = new Equipo(infoPartido2[3]);

        Partido partido1 = new Partido(equipo11,equipo12);
        partido1.setGoles1(Integer.parseInt(infoPartido1[1]));
        partido1.setGoles2(Integer.parseInt(infoPartido1[2]));
        partido1.setResultado();

        Partido partido2 = new Partido(equipo21,equipo22);
        partido2.setGoles1(Integer.parseInt(infoPartido2[1]));
        partido2.setGoles2(Integer.parseInt(infoPartido2[2]));
        partido2.setResultado();

        for (String linea : Files.readAllLines(pronostico)){
            informacion.add(linea);
            System.out.println(linea);
        }

        System.out.println("---------------------------------");

        String[] infoPronostico1 = informacion.get(4).split(";");
        String[] infoPronostico2 = informacion.get(5).split(";");

        Pronostico pronostico1 = new Pronostico(partido1);
        pronostico1.setResultado(infoPronostico1);
        Pronostico pronostico2 = new Pronostico(partido2);
        pronostico2.setResultado(infoPronostico2);

        Ronda ronda1= new Ronda();
        ronda1.setEncuentro(partido1, pronostico1);
        ronda1.setEncuentro(partido2, pronostico2);

        System.out.println("Encuentro nº1: " + pronostico1
                +"\nEncuentro nº2: "+ pronostico2);

        System.out.println("Encuentro nº1: " + partido1.getResultado()
                +"\nEncuentro nº2: "+ partido2.getResultado() );
        System.out.println("\n    La persona sumo un total de "+ ronda1.getPuntos() +" punto/s");

    }
}