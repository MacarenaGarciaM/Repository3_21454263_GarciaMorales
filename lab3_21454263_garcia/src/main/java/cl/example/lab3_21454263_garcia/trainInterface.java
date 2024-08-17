package cl.example.lab3_21454263_garcia;

public interface trainInterface {
    void addCar(TDA_pcar_21454263_garciamorales car, int position);
    void removeCar(int position);
    boolean isTrain();
    int fetchCapacity();
    void assignDriver(TDA_driver_21454263_garciamorales driver);
}
