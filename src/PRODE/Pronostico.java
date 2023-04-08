package PRODE;

public class Pronostico {

    private Partido partido;
    private ResultadoEnum resultado;

    public Pronostico(Partido p){
        partido=p;
    }

    public void setResultado(String[] s) { //Verifica en que "celda" la persona marco para apostar por dicho equipo y lo establece como resultado en un Enum

        if (!s[1].equals(""))
            resultado = ResultadoEnum.ganaEquipo1;
        else if (!s[3].equals(""))
            resultado = ResultadoEnum.ganaEquipo2;
        else
            resultado = ResultadoEnum.empate;
    }
    @Override
    public String toString(){
        String cadena = "La persona aposto por ";
        ResultadoEnum r = getResultado();
        if (r==ResultadoEnum.ganaEquipo1)
            cadena += "el equipo 1 ("+partido.getEquipo1()+")";
        else if (r==ResultadoEnum.ganaEquipo2)
            cadena += "el equipo 2 ("+partido.getEquipo2()+")";
        else
            cadena += "empate";
        return cadena;
    }
    public ResultadoEnum getResultado() {
        return resultado;
    }

}
