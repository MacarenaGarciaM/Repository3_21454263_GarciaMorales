package cl.example.lab3_21454263_garcia;

public class TDA_station_21454263_garciamorales {
    int id;
    String name;
    String stationType;
    int stopTime;
    public TDA_station_21454263_garciamorales (int id, String name, String stationType, int stopTime){
        this.id = id;
        this.name = name;
        this.stationType = stationType;
        this.stopTime = stopTime;
    }

    public int getId() {
        return id;
    }

    public int getStopTime() {
        return stopTime;
    }

    public String getName() {
        return name;
    }

    public String getStationType() {
        return stationType;
    }

    public String toString (){
        return "Station id: " + id + ", name: " + name + ", stationType: " + stationType + ", stopTime" + stopTime;
    }
}

