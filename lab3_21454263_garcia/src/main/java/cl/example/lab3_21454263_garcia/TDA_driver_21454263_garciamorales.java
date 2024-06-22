package cl.example.lab3_21454263_garcia;

public class TDA_driver_21454263_garciamorales {
    int id;
    String name;
    String trainMaker;

    public TDA_driver_21454263_garciamorales(int id, String name, String trainMaker){
        this.id = id;
        this.name = name;
        this.trainMaker = trainMaker;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTrainMaker() {
        return trainMaker;
    }

    @Override
    public String toString() {
        return "Driver id: " + id + ", name: " + name + ", trainMaker" + trainMaker;
    }
}
