package cl.example.lab3_21454263_garcia;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TDA_train_21454263_garciamorales {
    int id;
    String trainMaker;
    int speed;
    int stationStayTime;
    List<TDA_pcar_21454263_garciamorales> carList;
    List<TDA_driver_21454263_garciamorales> AssignedDrivers;
    Date departureTime;
    int departureStationId;
    int arrivalStationId;

    /**
     * Descripción: Genera un objeto de tipo Train con las restricciones estipuladas en el enunciado en base a una lista de carros entregada.
     * @param id
     * @param trainMaker
     * @param speed
     * @param stationStayTime
     * @param carList
     */
    public TDA_train_21454263_garciamorales (int id, String trainMaker, int speed, int stationStayTime, List<TDA_pcar_21454263_garciamorales> carList){
        this.id = id;
        this.trainMaker = trainMaker;
        this.speed = speed;
        this.stationStayTime = stationStayTime;
        this.carList = carList;
        this.AssignedDrivers= new ArrayList<>();

    }

    public int getId() {
        return id;
    }

    public String getTrainMaker() {
        return trainMaker;
    }

    public int getSpeed() {
        return speed;
    }

    public int getStationStayTime() {
        return stationStayTime;
    }

    public List<TDA_pcar_21454263_garciamorales> getCarList() {
        return carList;
    }

    /**
     * Descripción: Añade un carro de pasajeros en un tren en la posición establecida.
     * @param car
     * @param position
     */
    public void addCar(TDA_pcar_21454263_garciamorales car, int position) {
        if (position < 0) {
            System.out.println("La posición no puede ser negativa.");
        }

        if (position > carList.size()) {
            carList.add(car);
        } else {
            carList.add(position, car);
        }
    }

    /**
     * Descripción: Remueve un carro de pasajeros en un tren de la posición establecida.
     * @param position
     */
    public void removeCar(int position) {
        if (position < 0 || position >= carList.size()) {
            System.out.println("Posición fuera de los límites de la lista");
        }

        carList.remove(position);  // Remover el carro en la posición especificada
    }

    /**
     * Descripción: Dado un tren, verifica si este cumple con las especificaciones de los carros de pasajeros para un tren. Permite determinar siun elemento es un tren válido, si el elemeto tiene la estructura de tren
     * y los carros que lo conforman son compatibles (mismo modelo) y tienen una disposición coherente con carros terminales (tr) en los extremos y centrales (ct) en medio del convoy.
     * @return
     */
    public boolean isTrain(){
        if(carList.size()<2){
            return false;
        }
        if (!carList.get(0).getCarType().equals("t") || !carList.get(carList.size() - 1 ).getCarType().equals("t")){
            return false;
        }
        for(int i=1; i < carList.size() - 1; i++){
            if(!carList.get(i).getCarType().equals("c")){
                return false;
            }
        }
        String model = carList.get(0).getModel();
        for(int i = 1; i < carList.size(); i++ ){
            if(!carList.get(i).getModel().equals(model)){
                return false;
            }
        }
        return true;
    }


}
