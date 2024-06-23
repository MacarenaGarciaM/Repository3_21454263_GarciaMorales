package cl.example.lab3_21454263_garcia;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class TDA_subway_21454263_garciamorales {
    int id;
    String name;
    List<TDA_line_21454263_garciamorales> lines;
    List<TDA_train_21454263_garciamorales> trains;
    List<TDA_driver_21454263_garciamorales> drivers;
    List<combinaciones_21454263_garciamorales> combinaciones;

    /**
     * Descripción: Crea una nueva red de metro
     * @param id
     * @param name
     */
    public TDA_subway_21454263_garciamorales(int id, String name){
        this.id=id;
        this.name=name;
        this.lines=new ArrayList<>();
        this.trains=new ArrayList<>();
        this.drivers=new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<TDA_line_21454263_garciamorales> getLines() {
        return lines;
    }

    public List<TDA_train_21454263_garciamorales> getTrains() {
        return trains;
    }

    public List<TDA_driver_21454263_garciamorales> getDrivers() {
        return drivers;
    }

    /**
     * Descripción: Añade uno o más trenes a una red de metro
     * @param trainList
     */
    public void addTrain(List<TDA_train_21454263_garciamorales> trainList) {
        boolean bandera = true;
        if(trainList == null || trainList.isEmpty()) {
            System.out.println("La lista no puede estar vacía");
        }
        for(TDA_train_21454263_garciamorales nuevoTren : trainList){
            for (TDA_train_21454263_garciamorales trenExistente : trains){
                if(trenExistente.id == nuevoTren.id ){
                    System.out.println("El ID se encuentra repetido");
                    bandera = false;
                }
            }
            if(bandera){
                trains.add(nuevoTren);
            }
        }
    }


    /**
     * Descripción: Añade una o más lineas a una red de metro
     * @param lineList
     */
    public void addLine(List<TDA_line_21454263_garciamorales> lineList){
        boolean bandera = true;
        if(lineList == null || lineList.isEmpty()) {
            System.out.println("La lista no puede estar vacía");
        }
        for(TDA_line_21454263_garciamorales nuevaLinea : lineList){
            for (TDA_line_21454263_garciamorales LineaExistente : lines){
                if(LineaExistente.id == nuevaLinea.id ){
                    System.out.println("El ID se encuentra repetido");
                    bandera = false;
                }
            }
            if(bandera){
                lines.add(nuevaLinea);
            }
        }
    }

}