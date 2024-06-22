package cl.example.lab3_21454263_garcia;

public class TDA_pcar_21454263_garciamorales {
    int id;
    int passengerCapacity;
    String model;
    String trainMaker;
    String carType;

    public TDA_pcar_21454263_garciamorales (int id, int passengerCapacity, String model, String trainMaker, String carType){
        this.id = id;
        this.passengerCapacity = passengerCapacity;
        this.model = model;
        this.trainMaker = trainMaker;
        this.carType = carType;
    }

    public int getId() {
        return id;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public String getModel() {
        return model;
    }

    public String getTrainMaker() {
        return trainMaker;
    }

    public String getCarType() {
        return carType;
    }

    public String toString(){
        return "Pcar id: " + id + ", passangerCapacity: " + passengerCapacity + ", Model: " + model + ", trainMaker: " + trainMaker + ", carType: " + carType;
    }
}
