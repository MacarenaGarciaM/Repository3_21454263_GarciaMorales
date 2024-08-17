package cl.example.lab3_21454263_garcia;
import java.util.List;
public class TDA_section_21454263_garciamorales implements sectionInterface{
    TDA_station_21454263_garciamorales point1;
    TDA_station_21454263_garciamorales point2;
    int distance;
    int cost;

    /**
     * Descripción: Método constructor de una section.
     * @param point1
     * @param point2
     * @param distance
     * @param cost
     */
    public TDA_section_21454263_garciamorales (TDA_station_21454263_garciamorales point1, TDA_station_21454263_garciamorales point2, int distance, int cost){
        this.point1 = point1;
        this.point2 = point2;
        this.distance = distance;
        this.cost = cost;
    }

    /**
     * Descripción: Obtiene el costo de la section
     * @return
     */
    public int getCost() {
        return cost;
    }

    /**
     * Descripción:Obtiene la primera estación de la section
     * @return
     */
    public TDA_station_21454263_garciamorales getPoint1() {
        return point1;
    }

    /**
     * Descripción:Obtiene la segunda estación de la section
     * @return
     */
    public TDA_station_21454263_garciamorales getPoint2() {
        return point2;
    }

    /**
     * Descripción: Obtiene la distancia
     * @return
     */
    public int getDistance() {
        return distance;
    }

    /**
     * Descripción: Método para pasar la section a String
     * @return
     */
    public String toString(){
        return "Point 1: " + point1.getName() + ", Point 2: " + point2.getName() + ", Distance: " + distance + ", Cost: " + cost;
    }



}
