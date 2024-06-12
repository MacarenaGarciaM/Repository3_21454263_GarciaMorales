package cl.example.lab3_21454263_garcia;

public class TDA_section_21454263_garciamorales {
    TDA_station_21454263_garciamorales point1;
    TDA_station_21454263_garciamorales point2;
    int distance;
    int cost;

    public TDA_section_21454263_garciamorales (TDA_station_21454263_garciamorales point1, TDA_station_21454263_garciamorales point2, int distance, int cost){
        this.point1 = point1;
        this.point2 = point2;
        this.distance = distance;
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    public TDA_station_21454263_garciamorales getPoint1() {
        return point1;
    }

    public TDA_station_21454263_garciamorales getPoint2() {
        return point2;
    }

    public int getDistance() {
        return distance;
    }

}
