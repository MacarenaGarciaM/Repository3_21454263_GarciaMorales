package cl.example.lab3_21454263_garcia;

import java.util.List;
import java.util.Objects;


public class TDA_line_21454263_garciamorales {
    int id;
    String name;
    String railType;
    List<TDA_section_21454263_garciamorales> sections;

    public TDA_line_21454263_garciamorales (int id,String name, String railType, List<TDA_section_21454263_garciamorales> sections){
        this.id = id;
        this.name = name;
        this.railType = railType;
        this.sections = sections;
    }

    public String getName() {

        return name;
    }

    public int getId() {
        return id;
    }

    public String getRailType() {
        return railType;
    }

    public List<TDA_section_21454263_garciamorales> getSections() {
        return sections;
    }


    public int lineLength() {
        int acum = 0;
        for (TDA_section_21454263_garciamorales sections: this.sections) {
            acum= acum + sections.getDistance();
        }
        return acum;
    }
    public int lineSectionLength(String station1Name, String station2Name) {
        boolean bandera = false;
        int totalDistance = 0;

        for (TDA_section_21454263_garciamorales section : this.sections) {
            if (section.getPoint1().getName().equals(station1Name)) {
                bandera = true;
                totalDistance += section.getDistance();
            } else if (bandera) {
                totalDistance += section.getDistance();
                if (section.getPoint2().getName().equals(station2Name)) {
                    break;
                }
            } else if (section.getPoint2().getName().equals(station2Name)) {
                bandera = true;
                totalDistance += section.getDistance();
            }
        }


        return totalDistance;
    }
    public int lineCost() {
        int totalCost = 0;
        for (TDA_section_21454263_garciamorales section : sections) {
            totalCost += section.getCost();
        }
        return totalCost;
    }

    public int lineSectionCost(String station1Name, String station2Name) {
        for (TDA_section_21454263_garciamorales section : sections) {
            if ((section.getPoint1().getName().equals(station1Name) && section.getPoint2().getName().equals(station2Name)) ||
                    (section.getPoint1().getName().equals(station2Name) && section.getPoint2().getName().equals(station1Name))) {
                return section.getCost();
            }
        }

        return -1;
    }


}
