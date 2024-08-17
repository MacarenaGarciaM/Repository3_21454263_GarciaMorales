package cl.example.lab3_21454263_garcia;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class TDA_subway_21454263_garciamorales implements subwayInterface{
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
        this.combinaciones=new ArrayList<>();
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

    /**
     * Descripción: Añade uno o más conductores a una red de metro
     * @param driverList
     */
    public void addDriver (List<TDA_driver_21454263_garciamorales> driverList){
        boolean bandera = true;
        if(driverList == null || driverList.isEmpty()) {
            System.out.println("La lista no puede estar vacía");
        }
        for(TDA_driver_21454263_garciamorales nuevoDriver : driverList){
            for (TDA_driver_21454263_garciamorales driverExistente : drivers){
                if(driverExistente.id == nuevoDriver.id ){
                    System.out.println("El ID se encuentra repetido");
                    bandera = false;
                }
            }
            if(bandera){
                drivers.add(nuevoDriver);
            }

        }
    }

    /**
     * Descripción: Método que permite expresar una redde metro en formato String
     * @return
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Subway ID: ").append(id).append("\n");
        sb.append("Name: ").append(name).append("\n");

        sb.append("Lines:\n");
        for (TDA_line_21454263_garciamorales line : lines) {
            sb.append(line.toString()).append("\n");
        }
        sb.append("Trains:\n");
        for (TDA_train_21454263_garciamorales train : trains) {
            sb.append(train.toString()).append("\n");
        }
        sb.append("Drivers:\n");
        for (TDA_driver_21454263_garciamorales driver : drivers) {
            sb.append(driver.toString()).append("\n");
        }
        sb.append("\nCombinations:\n");
        for (combinaciones_21454263_garciamorales combination : combinaciones) {
            sb.append("Combinacion entre ")
                    .append(combination.getStation1().getName()).append(" y ").append(combination.getStation2().getName()).append("\n");
        }
        return sb.toString();
    }


    /**
     *Descripción:Asigna un tren a una línea.
     * @param train
     * @param line
     */
    public void assignTrainToLine(TDA_train_21454263_garciamorales train, TDA_line_21454263_garciamorales line){
        if(train == null || line == null){
            System.out.println("El tren o la linea son nulos");
        }else{
            line.assignTrain(train);
        }
    }


    /**
     * Descripción: Asigna un conductor a un tren considerando un tiempo de partida. una estación de partida y una de llegada.
     * @param train
     * @param driver
     * @param departureTime
     * @param departureStationid
     * @param arrivalStationid
     */
    public void assignDriverToTrain(TDA_train_21454263_garciamorales train, TDA_driver_21454263_garciamorales driver, Date departureTime, int departureStationid, int arrivalStationid) {
        if (!Objects.equals(train.getTrainMaker(), driver.getTrainMaker())) {
            System.out.println("El fabricante del tren y del conductor no coinciden");
        }else {
            train.assignDriver(driver);
            train.setDepartureTime(departureTime);
            train.setDepartureStation(departureStationid);
            train.setArrivalStation(arrivalStationid);
        }

    }

    /**
     * Descripción: Añade combinaciones a una lista
     * @param combinationList
     */
    public void addCombinations(List<combinaciones_21454263_garciamorales> combinationList) {
        if (combinationList == null || combinationList.isEmpty()) {
            System.out.println("La lista de combinaciones no puede ser nula o vacía");
        } else {
            combinaciones.addAll(combinationList);
        }
    }

    /**
     * Descripción: dado un ID busca un línea
     * @param lineId
     * @return
     */
    public TDA_line_21454263_garciamorales buscarLineaPorId(int lineId) {
        for (TDA_line_21454263_garciamorales line : lines) {
            if (line.getId() == lineId) {
                return line;
            }
        }
        return null;
    }

    /**
     * Descripción: dado un id busca un tren
     * @param trainId
     * @return
     */
    public TDA_train_21454263_garciamorales buscarTrenPorId(int trainId) {
        for (TDA_train_21454263_garciamorales train : trains) {
            if (train.getId() == trainId) {
                return train;
            }
        }
        return null;
    }

}