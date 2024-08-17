package cl.example.lab3_21454263_garcia;

public class TDA_station_21454263_garciamorales implements stationInterface{
    int id;
    String name;
    String stationType;
    int stopTime;

    /**
     * Descripción:Método constructor de una estación de metro
     * @param id
     * @param name
     * @param stationType
     * @param stopTime
     */
    public TDA_station_21454263_garciamorales (int id, String name, String stationType, int stopTime){
        this.id = id;
        this.name = name;
        this.stationType = stationType;
        this.stopTime = stopTime;
    }

    /**
     * Descripción: Obtiene el nombre de la estación
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Descripción: Obtiene el tipo de la estación
     * @return
     */
    public String getStationType() {
        return stationType;
    }

    /**
     * Descripción: Método para pasar la estación a String
     * @return
     */
    public String toString (){
        return "Station id: " + id + ", name: " + name + ", stationType: " + stationType + ", stopTime" + stopTime;
    }
}

