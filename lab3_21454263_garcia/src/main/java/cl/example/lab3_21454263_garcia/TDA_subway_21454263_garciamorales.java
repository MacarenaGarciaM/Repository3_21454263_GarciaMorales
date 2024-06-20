package cl.example.lab3_21454263_garcia;

import java.util.ArrayList;
import java.util.List;

public class TDA_subway_21454263_garciamorales {
    int id;
    String name;
    List<TDA_line_21454263_garciamorales> lines;
    List<TDA_train_21454263_garciamorales> trains;
    List<TDA_driver_21454263_garciamorales> drivers;

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

}