package cl.example.lab3_21454263_garcia;

public class TDA_pcar_21454263_garciamorales implements pcarInterface{
    int id;
    int passengerCapacity;
    String model;
    String trainMaker;
    String carType;

    /**
     * Descripción: Genera un objeto de tipo PassengerCar
     * @param id
     * @param passengerCapacity
     * @param model
     * @param trainMaker
     * @param carType
     */
    public TDA_pcar_21454263_garciamorales (int id, int passengerCapacity, String model, String trainMaker, String carType){
        this.id = id;
        this.passengerCapacity = passengerCapacity;
        this.model = model;
        this.trainMaker = trainMaker;
        this.carType = carType;
    }

    /**
     * Descripción: obtiene la capacidad de pasajeros
     * @return
     */
    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    /**
     * Descripción:Obtiene el modelo
     * @return
     */
    public String getModel() {
        return model;
    }

    /**
     * Descripción: Obtiene el tipo de car
     * @return
     */
    public String getCarType() {
        return carType;
    }

    /**
     * Descripción: Método para pasar el pcar a String
     * @return
     */
    public String toString(){
        return "Pcar id: " + id + ", passangerCapacity: " + passengerCapacity + ", Model: " + model + ", trainMaker: " + trainMaker + ", carType: " + carType;
    }
}
