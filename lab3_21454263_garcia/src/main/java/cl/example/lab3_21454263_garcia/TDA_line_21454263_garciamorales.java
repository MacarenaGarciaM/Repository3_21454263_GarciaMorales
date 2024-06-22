package cl.example.lab3_21454263_garcia;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class TDA_line_21454263_garciamorales {
    int id;
    String name;
    String railType;
    List<TDA_section_21454263_garciamorales> sections;
    List<TDA_train_21454263_garciamorales> AssignedTrains;

    /**
     * Descripción: Método constructor de una línea
     * @param id
     * @param name
     * @param railType
     * @param sections
     */
    public TDA_line_21454263_garciamorales (int id,String name, String railType, List<TDA_section_21454263_garciamorales> sections){
        this.id = id;
        this.name = name;
        this.railType = railType;
        this.sections = sections;
        this.AssignedTrains = new ArrayList<>();
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

    /**
     * Descripción: Método que permite determinar el largo total de una línea
     * @return
     */
    public int lineLength() {
        int acum = 0;
        for (TDA_section_21454263_garciamorales sections: this.sections) {
            acum= acum + sections.getDistance();
        }
        return acum;
    }

    /**
     * Descripción: Método que permite determinar el trayecto entre una estación origen y una final (largo total entre una estación origen y una estación destino).
     * @param station1Name
     * @param station2Name
     * @return
     */
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

    /**
     * Descripción: Función que permite determinar el costo total (monetario) de recorrer una línea.
     * @return
     */
    public int lineCost() {
        int totalCost = 0;
        for (TDA_section_21454263_garciamorales section : sections) {
            totalCost += section.getCost();
        }
        return totalCost;
    }

    /**
     * Descripción:  Método que permite determinar el costo de un trayecto entre una estación origen y una final.
     * @param station1Name
     * @param station2Name
     * @return
     */

    public int lineSectionCost(String station1Name, String station2Name) {
        for (TDA_section_21454263_garciamorales section : sections) {
            if ((section.getPoint1().getName().equals(station1Name) && section.getPoint2().getName().equals(station2Name)) ||
                    (section.getPoint1().getName().equals(station2Name) && section.getPoint2().getName().equals(station1Name))) {
                return section.getCost();
            }
        }

        return -1;
    }

    /**
     * Descripción: Método que permite añadir tramos a una línea.
     * @param sections
     */

    public void lineAddSection(List<TDA_section_21454263_garciamorales> sections) {
        for(TDA_section_21454263_garciamorales section : sections){
            if(!this.sections.contains(section)){
                this.sections.add(section);
            }

        }
    }


    /**
     * Método que verifica si una línea es circular
     * @return
     */
    public boolean isCircular() {
        if (sections.isEmpty()) {
            return false; // Si la lista de secciones está vacía, la línea no puede ser circular.
        }

        TDA_section_21454263_garciamorales primeraSection = sections.get(0);
        TDA_section_21454263_garciamorales ultimaSection = sections.get(sections.size() - 1);

        return primeraSection.getPoint1().equals(ultimaSection.getPoint2());
    }

    /**
     * Descripción:  Método que permite determinar si un elemento cumple con las restricciones señaladas en apartados anteriores en relación a las estaciones y tramos para poder conformar una línea.
     * @return
     */
    public boolean isLine(){
        for (int i = 0; i < this.sections.size() - 1 ; i++){
            TDA_section_21454263_garciamorales sectionActual= this.sections.get(i);
            TDA_station_21454263_garciamorales stationActual= sectionActual.getPoint2();
            TDA_section_21454263_garciamorales nextsection = this.sections.get(i + 1);
            TDA_station_21454263_garciamorales nextstation = nextsection.getPoint1();
            if(! Objects.equals(stationActual, nextstation)){
                return false;
            }
        }
        TDA_section_21454263_garciamorales sectionInicial = this.sections.get(0);
        TDA_section_21454263_garciamorales sectionFinal = this.sections.get(this.sections.size() - 1 );
        TDA_station_21454263_garciamorales stationInicial = sectionInicial.getPoint1();
        TDA_station_21454263_garciamorales stationFinal = sectionFinal.getPoint2();
        if (isCircular()) {
            if (!Objects.equals(stationInicial.getStationType(), "t") || !Objects.equals(stationFinal.getStationType(), "t")) {
                return false;
            }
        } else {
            if (!Objects.equals(stationInicial.getStationType(), "t") || !Objects.equals(stationFinal.getStationType(), "t")) {
                return false;
            }
        }

        return true;
    }

    /**
     *
     * @param train
     */

    public void assignTrain(TDA_train_21454263_garciamorales train){
        if(train == null){
            System.out.println("El tren es nulo");
        }else{
            this.AssignedTrains.add(train);
        }
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Line id: ").append(id).append(", Name: ").append(name).append(", Type: ").append("\n");
        sb.append("Sections: \n");
        for(TDA_section_21454263_garciamorales section : sections){
            sb.append(section.toString()).append("\n");
        }
        return sb.toString();
    }



}
