package cl.example.lab3_21454263_garcia;
import java.util.ArrayList;
import java.util.List;

public class main_21454263_garciamorales {
    public static void main(String[] args) {
        // Crear instancias de estaciones
        TDA_station_21454263_garciamorales station1 = new TDA_station_21454263_garciamorales(1, "Station 1", "t", 5);
        TDA_station_21454263_garciamorales station2 = new TDA_station_21454263_garciamorales(2, "Station 2", "c", 5);
        TDA_station_21454263_garciamorales station3 = new TDA_station_21454263_garciamorales(3, "Station 3", "t", 5);

        // Crear instancias de secciones
        TDA_section_21454263_garciamorales section1 = new TDA_section_21454263_garciamorales(station1, station2, 10, 100);
        TDA_section_21454263_garciamorales section2 = new TDA_section_21454263_garciamorales(station2, station3, 20, 200);

        // Crear lista de secciones y agregar secciones
        List<TDA_section_21454263_garciamorales> sections = new ArrayList<>();
        sections.add(section1);
        sections.add(section2);

        // Crear instancia de la línea del metro
        TDA_line_21454263_garciamorales line = new TDA_line_21454263_garciamorales(1, "Line 1", "Type A", sections);

        // Pruebas
        System.out.println("Longitud total de la línea: " + line.lineLength()); // Debería imprimir 30
        System.out.println("Costo total de la línea: " + line.lineCost()); // Debería imprimir 300
        System.out.println("Longitud de la sección entre Station 1 y Station 3: " + line.lineSectionLength("Station 1", "Station 3")); // Debería imprimir 30
        System.out.println("Costo de la sección entre Station 1 y Station 2: " + line.lineSectionCost("Station 1", "Station 2")); // Debería imprimir 100


        // Crear carros para el tren
        TDA_pcar_21454263_garciamorales car1 = new TDA_pcar_21454263_garciamorales(1, 100, "Model X", "TrainMaker", "t");
        TDA_pcar_21454263_garciamorales car2 = new TDA_pcar_21454263_garciamorales(2, 150, "Model X", "TrainMaker", "c");
        TDA_pcar_21454263_garciamorales car3 = new TDA_pcar_21454263_garciamorales(3, 100, "Model X", "TrainMaker", "t");

        // Crear lista de carros y agregar carros
        List<TDA_pcar_21454263_garciamorales> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);

        // Crear instancia del tren
        TDA_train_21454263_garciamorales train = new TDA_train_21454263_garciamorales(1, "TrainMaker", 120, 5, cars);

    }
}