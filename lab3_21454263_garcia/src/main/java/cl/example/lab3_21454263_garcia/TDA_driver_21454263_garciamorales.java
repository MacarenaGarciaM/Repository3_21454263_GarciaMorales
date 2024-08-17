package cl.example.lab3_21454263_garcia;

public class TDA_driver_21454263_garciamorales implements driverInterface{
    int id;
    String name;
    String trainMaker;

    /**
     * Descripción:Funcionalidad que permite crear un conductor cuya habilitación de conducción depende del fabricante de tren
     * @param id
     * @param name
     * @param trainMaker
     */
    public TDA_driver_21454263_garciamorales(int id, String name, String trainMaker){
        this.id = id;
        this.name = name;
        this.trainMaker = trainMaker;
    }

    /**
     * Descripción: obtiene el trainmaker
     * @return
     */
    public String getTrainMaker() {
        return trainMaker;
    }

    /**
     * Descripción: Método que pasa el driver a String
     * @return
     */
    @Override
    public String toString() {
        return "Driver id: " + id + ", name: " + name + ", trainMaker" + trainMaker;
    }
}
