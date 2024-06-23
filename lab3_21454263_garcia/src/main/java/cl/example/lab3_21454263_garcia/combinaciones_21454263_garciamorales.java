package cl.example.lab3_21454263_garcia;

public class combinaciones_21454263_garciamorales {
    public TDA_station_21454263_garciamorales station1;
    public TDA_station_21454263_garciamorales station2;


    public combinaciones_21454263_garciamorales (TDA_station_21454263_garciamorales station1, TDA_station_21454263_garciamorales station2) {
        this.station1 = station1;
        this.station2 = station2;

    }
    public TDA_station_21454263_garciamorales getStation2() {
        return station2;
    }

    public TDA_station_21454263_garciamorales getStation1() {
        return station1;
    }

    @Override
    public String toString() {
        return "Combinación entre " + station1.getName() + " y " + station2.getName();
    }


}
