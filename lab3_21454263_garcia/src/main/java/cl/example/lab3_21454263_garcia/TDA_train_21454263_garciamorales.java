package cl.example.lab3_21454263_garcia;

import java.util.List;

public class TDA_train_21454263_garciamorales {
    int id;
    String trainMaker;
    int speed;
    int stationStayTime;
    List<TDA_pcar_21454263_garciamorales> carList;

    public TDA_train_21454263_garciamorales (int id, String trainMaker, int speed, int stationStayTime, List<TDA_pcar_21454263_garciamorales> carList){
        this.id = id;
        this.trainMaker = trainMaker;
        this.speed = speed;
        this.stationStayTime = stationStayTime;
        this.carList = carList;

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

    public void addCar(TDA_pcar_21454263_garciamorales car, int position) {
        if (position < 0) {
            System.out.println("La posición no puede ser negativa.");
        }

        if (position > carList.size()) {
            carList.add(car);  // Si la posición es mayor que el tamaño de la lista, se añade al final
        } else {
            carList.add(position, car);  // Añadir el carro en la posición especificada
        }
    }


}
