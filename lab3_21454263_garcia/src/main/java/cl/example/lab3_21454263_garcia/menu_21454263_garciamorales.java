package cl.example.lab3_21454263_garcia;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.Date;
import java.util.Scanner;


public class menu_21454263_garciamorales {

    public static TDA_subway_21454263_garciamorales subway;

    public static void main(String[] args) {
        subway = new TDA_subway_21454263_garciamorales(1, "Metro");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("### Sistema Metro - Inicio ###");
            System.out.println("1. Cargar información del sistema de metro");
            System.out.println("2. Visualizar estado actual del sistema de metro");
            System.out.println("3. Interactuar con el sistema de metro");
            System.out.println("4. Salir del programa");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    cargarInformacion(scanner);
                    break;
                case 2:
                    visualizarEstadoActual();
                    break;
                case 3:
                    interactuarSistemaMetro(scanner);
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    public static void cargarInformacion(Scanner scanner) {
        System.out.println("### Sistema Metro - Cargar información del sistema de metro ###");
        System.out.println("1. Creación de una línea de metro básica (cargar archivo lineas.txt)");
        System.out.println("2. Combinaciones entre estaciones entre Líneas  (cargar archivo combinaciones.txt)");
        System.out.println("3. Definición de trenes con distintos número de carros (cargar archivo trenes.txt)");
        System.out.println("4. Conductores asignados a una Línea (cargar archivo conductores.txt)");
        System.out.println("5. Retorno al menú de Inicio");
        int option = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (option) {
            case 1:
                cargarLineas();
                break;
            case 2:
                cargarCombinaciones();
                break;
            case 3:
                cargarTrenes();
                break;
            case 4:
                cargarConductores();
                break;
            case 5:
                return;
            default:
                System.out.println("Opción no válida. Intente de nuevo.");
        }
    }

    public static void cargarLineas() {
        try {
            File file = new File("lineas.txt");
            Scanner fileScanner = new Scanner(file);
            List<TDA_line_21454263_garciamorales> lineList = new ArrayList<>();

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] data = line.split(";");
                int id = Integer.parseInt(data[0]);
                String name = data[1];
                String railType = data[2];
                List<TDA_section_21454263_garciamorales> sections = new ArrayList<>();

                for (int i = 3; i < data.length; i++) {
                    String[] sectionData = data[i].split(":");

                    //primera estación
                    String[] station1Data = sectionData[0].split(", ");
                    int station1Id = Integer.parseInt(station1Data[0]);
                    String station1Name = station1Data[1].replace("\"", "");
                    String station1Type = station1Data[2];
                    int station1StopTime = Integer.parseInt(station1Data[3]);

                    //segunda estación
                    String[] station2Data = sectionData[1].split(", ");
                    int station2Id = Integer.parseInt(station2Data[0]);
                    String station2Name = station2Data[1].replace("\"", "");
                    String station2Type = station2Data[2];
                    int station2StopTime = Integer.parseInt(station2Data[3]);

                    int distance = Integer.parseInt(sectionData[2]);
                    int cost = Integer.parseInt(sectionData[3]);

                    TDA_station_21454263_garciamorales station1 = new TDA_station_21454263_garciamorales(station1Id, station1Name, station1Type, station1StopTime);
                    TDA_station_21454263_garciamorales station2 = new TDA_station_21454263_garciamorales(station2Id, station2Name, station2Type, station2StopTime);

                    TDA_section_21454263_garciamorales section = new TDA_section_21454263_garciamorales(station1, station2, distance, cost);
                    sections.add(section);

                }

                TDA_line_21454263_garciamorales nuevaLinea = new TDA_line_21454263_garciamorales(id, name, railType, sections);
                nuevaLinea.lineAddSection(sections);
                lineList.add(nuevaLinea);
            }
            fileScanner.close();
            subway.addLine(lineList);
            System.out.println("Lineas cargadas.");
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado.");
        }
    }

    public static void cargarCombinaciones() {
        try {
            File file = new File("combinaciones.txt");
            Scanner fileScanner = new Scanner(file);
            List<combinaciones_21454263_garciamorales> combinationList = new ArrayList<>();

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] data = line.split(":");

                // Datos de la primera estación
                String[] station1Data = data[0].split(",");
                int station1Id = Integer.parseInt(station1Data[0]);
                String station1Name = station1Data[1].replace("\"", "");
                String station1Type = station1Data[2];
                int station1StopTime = Integer.parseInt(station1Data[3]);


                // Datos de la segunda estación
                String[] station2Data = data[1].split(",");
                int station2Id = Integer.parseInt(station2Data[0]);
                String station2Name = station2Data[1].replace("\"", "");
                String station2Type = station2Data[2];
                int station2StopTime = Integer.parseInt(station2Data[3]);

                TDA_station_21454263_garciamorales station1 = new TDA_station_21454263_garciamorales(station1Id, station1Name, station1Type, station1StopTime);
                TDA_station_21454263_garciamorales station2 = new TDA_station_21454263_garciamorales(station2Id, station2Name, station2Type, station2StopTime);

                combinaciones_21454263_garciamorales combination = new combinaciones_21454263_garciamorales(station1, station2);
                combinationList.add(combination);
            }

            fileScanner.close();
            subway.addCombinations(combinationList);
            System.out.println("Combinaciones cargadas exitosamente.");

        } catch (FileNotFoundException e) {
            System.out.println("Archivo combinaciones.txt no encontrado.");
        }

    }
    public static void cargarConductores() {
        try {
            File file = new File("conductores.txt");
            Scanner fileScanner = new Scanner(file);

            List<TDA_driver_21454263_garciamorales> driverList = new ArrayList<>();

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] data = line.split(";");

                // Leer los campos del conductor
                int driverId = Integer.parseInt(data[0]);
                String driverName = data[1];
                int trainId = Integer.parseInt(data[2]);
                Date departureTime = new Date(Long.parseLong(data[3]));
                int departureStationId = Integer.parseInt(data[4]);
                int arrivalStationId = Integer.parseInt(data[5]);

                TDA_train_21454263_garciamorales train = subway.buscarTrenPorId(trainId);

                if (train == null) {
                    System.out.println("No se encontró el tren con ID " + trainId + " para asignar el conductor.");
                    continue;
                }

                TDA_driver_21454263_garciamorales driver = new TDA_driver_21454263_garciamorales(driverId, driverName, train.getTrainMaker());
                subway.assignDriverToTrain(train, driver, departureTime, departureStationId,arrivalStationId);

                driverList.add(driver);
            }

            fileScanner.close();
            subway.addDriver(driverList);
            System.out.println("Conductores cargados exitosamente.");
        } catch (FileNotFoundException e) {
            System.out.println("Archivo conductores.txt no encontrado.");
        }
    }



    public static void cargarTrenes() {
        try {
            File file = new File("trenes.txt");
            Scanner fileScanner = new Scanner(file);
            List<TDA_train_21454263_garciamorales> trainList = new ArrayList<>();

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] data = line.split(";");
                int id = Integer.parseInt(data[0]);
                String trainMaker = data[1];
                int speed = Integer.parseInt(data[2]);
                int stationStayTime = Integer.parseInt(data[3]);
                int idLine = Integer.parseInt(data[4]);

                // Buscar la línea por su ID en el subway
                TDA_line_21454263_garciamorales lineT = subway.buscarLineaPorId(idLine);
                if (lineT == null) {
                    System.out.println("No se encontró la línea con ID: " + idLine + ". No se puede asignar el tren.");
                    continue; // Saltar este tren si la línea no existe
                }

                List<TDA_pcar_21454263_garciamorales> carList = new ArrayList<>();

                // Iterar sobre los carros del tren
                for (int i = 5; i < data.length; i++) {
                    String[] carData = data[i].split(",");
                    int carId = Integer.parseInt(carData[0]);
                    int passengerCapacity = Integer.parseInt(carData[1]);
                    String model = carData[2];
                    String carTrainMaker = carData[3];
                    String carType = carData[4];

                    TDA_pcar_21454263_garciamorales car = new TDA_pcar_21454263_garciamorales(carId, passengerCapacity, model, carTrainMaker, carType);
                    carList.add(car);
                }

                TDA_train_21454263_garciamorales nuevoTren = new TDA_train_21454263_garciamorales(id, trainMaker, speed, stationStayTime, carList);
                trainList.add(nuevoTren);

                // Asignar el tren a la línea encontrada
                subway.assignTrainToLine(nuevoTren, lineT);
            }

            subway.addTrain(trainList);
            fileScanner.close();
            System.out.println("Trenes cargados exitosamente.");
        } catch (FileNotFoundException e) {
            System.out.println("Archivo trenes.txt no encontrado.");
        }

    }



    public static void visualizarEstadoActual() {
        System.out.println("### Sistema Metro - Visualización del estado actual del sistema de metros ###");
        System.out.println(subway.toString());
        System.out.println("1. Retorno al menú de Inicio");
        // Esperar a que el usuario presione una tecla para continuar
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    public static void interactuarSistemaMetro(Scanner scanner) {
        System.out.println("### Sistema Metro - Interactuar con el sistema de metros ###");
        System.out.println("1. lineLength: obtener el largo total de una línea.");
        System.out.println("2. lineSectionLength: determinar el tracto entre una estación origen y final.");
        System.out.println("3. lineCost: determinar el costo total de recorrer una línea.");
        System.out.println("4. lineSectionCost: determinar el costo de un trayecto entre estación origen y final.");
        System.out.println("5. isLine: verificar si una línea cumple con las restricciones especificadas.");
        System.out.println("6. Train - addCar: añade un carro de pasajeros a un tren en la posición establecida.");
        System.out.println("7. Train - removeCar: remueve un carro de pasajeros de un tren en la posición establecida.");
        System.out.println("8. Train - isTrain: verifica si un tren cumple con las especificaciones de los carros de pasajeros.");
        System.out.println("9. Train - fetchCapacity: entrega la capacidad máxima de pasajeros de un tren.");
        System.out.println("10. Subway - whereIsTrain: determina la ubicación de un tren a partir de una hora indicada del día.");
        System.out.println("11. Subway - trainPath: armar el recorrido del tren a partir de una hora especificada y que retorna la lista de estaciones futuras por recorrer.");
        System.out.println("12. Retorno al menú de Inicio");
        int option = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (option) {
            // Implementar las acciones correspondientes a cada opción
            case 1:
                // Opción 1: lineLength
                System.out.println("Ingrese el ID de la línea para obtener su largo:");
                int lineId = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                TDA_line_21454263_garciamorales selectedLine = subway.buscarLineaPorId(lineId);
                if (selectedLine != null) {
                    int totalLength = selectedLine.lineLength();
                    System.out.println("El largo de la línea " + selectedLine.getName() + " es: " + totalLength + " metros.");
                } else {
                    System.out.println("No se encontró la línea con ID " + lineId + ". Intente nuevamente.");
                }
                break;
            case 2:
                // Implementar lineSectionLength
                System.out.println("Ingrese el ID de la línea");
                int lineId2 = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Ingrese el nombre estación 1");
                String section1 = scanner.nextLine();


                System.out.println("Ingrese el nombre estación 2:");
                String section2 = scanner.nextLine();


                TDA_line_21454263_garciamorales selectedLine2 = subway.buscarLineaPorId(lineId2);

                if (selectedLine2 != null) {
                    int totalSectionLength = selectedLine2.lineSectionLength(section1, section2);
                    System.out.println("El largo de las secciones es: " + totalSectionLength + " metros.");
                } else {
                    System.out.println("No se encontró la línea con ID " + lineId2 + ". Intente nuevamente.");
                }
                break;
            case 3:
                // Implementar lineCost
                System.out.println("Ingrese el ID de la línea para obtener su costo:");
                int lineId3 = scanner.nextInt();
                scanner.nextLine();

                TDA_line_21454263_garciamorales selectedLine3 = subway.buscarLineaPorId(lineId3);
                if (selectedLine3 != null) {
                    int totalCost = selectedLine3.lineCost();
                    System.out.println("El costo de la línea " + selectedLine3.getName() + " es: " + totalCost);
                } else {
                    System.out.println("No se encontró la línea con ID " + lineId3 + ". Intente nuevamente.");
                }
                break;
            case 4:
                // Implementar lineSectionCost
                System.out.println("Ingrese el ID de la línea");
                int lineId4 = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Ingrese el nombre de la estación 1");
                String station14 = scanner.nextLine();
                System.out.println("Ingrese el nombre de la estación 2:");
                String station24 = scanner.nextLine();

                TDA_line_21454263_garciamorales selectedLine4 = subway.buscarLineaPorId(lineId4);

                if (selectedLine4 != null) {
                    int totalSectiontotalCost = selectedLine4.lineSectionCost(station14, station24);
                    System.out.println("El costo de las secciones es: " + totalSectiontotalCost);
                } else {
                    System.out.println("No se encontró la línea con ID " + lineId4 + ". Intente nuevamente.");
                }
                break;
            case 5:
                System.out.println("Ingrese el ID de la línea:");
                int lineId5 = scanner.nextInt();
                scanner.nextLine(); // Consume newline after nextInt()

                // Buscar la línea por su ID
                TDA_line_21454263_garciamorales selectedLine5 = subway.buscarLineaPorId(lineId5);

                if (selectedLine5 != null) {
                    System.out.println("Línea encontrada: " + selectedLine5.getName());

                    if (selectedLine5.isLine()) {
                        System.out.println("La línea es válida.");
                    } else {
                        System.out.println("La línea no es válida.");
                    }
                } else {
                    System.out.println("No se encontró la línea con ID " + lineId5 + ". Intente nuevamente.");
                }
                break;




            case 6:
                // Implementar addCar
                System.out.println("Ingrese el ID del tren:");
                int trainId = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                System.out.println("Ingrese el ID del carro:");
                int carId = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                System.out.println("Ingrese la capacidad de pasajeros del carro:");
                int passengerCapacity = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                System.out.println("Ingrese el modelo del carro:");
                String model = scanner.nextLine();

                System.out.println("Ingrese el fabricante del carro:");
                String carTrainMaker = scanner.nextLine();

                System.out.println("Ingrese el tipo de carro (t o c):");
                String carType = scanner.nextLine();

                System.out.println("Ingrese la posición en la que desea agregar el carro:");
                int position = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                // Buscar el tren por su ID
                TDA_train_21454263_garciamorales selectedTrain = subway.buscarTrenPorId(trainId);

                if (selectedTrain != null) {
                    TDA_pcar_21454263_garciamorales newCar = new TDA_pcar_21454263_garciamorales(carId, passengerCapacity, model, carTrainMaker, carType);
                    selectedTrain.addCar(newCar, position);
                    System.out.println("Carro añadido exitosamente en la posición " + position + ".");
                } else {
                    System.out.println("No se encontró el tren con ID " + trainId + ". Intente nuevamente.");
                }
                break;

            case 7:
                // Implementar removeCar
                System.out.println("Ingrese el ID del tren:");
                int trainId7 = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Ingrese la posicion que quiere borrar:");
                int pos = scanner.nextInt();
                scanner.nextLine();
                TDA_train_21454263_garciamorales selectedTrain7 = subway.buscarTrenPorId(trainId7);
                selectedTrain7.removeCar(pos);
                break;
            case 8:
                // Implementar isTrain
                System.out.println("Ingrese el ID del tren:");
                int trainId8 = scanner.nextInt();
                scanner.nextLine();
                TDA_train_21454263_garciamorales selectedTrain8 = subway.buscarTrenPorId(trainId8);
                if (selectedTrain8.isTrain()){
                    System.out.println("El tren es valido");
                }else{
                    System.out.println("El tren no es valido");
                }
                break;
            case 9:
                // Implementar fetchCapacity
                System.out.println("Ingrese el ID del tren:");
                int trainId9 = scanner.nextInt();
                scanner.nextLine();
                TDA_train_21454263_garciamorales selectedTrain9 = subway.buscarTrenPorId(trainId9);
                int capacity=selectedTrain9.fetchCapacity();
                System.out.println("La capacidad del tren es: " + capacity);

                break;
            case 10:
                // Implementar whereIsTrain
                System.out.println("No implementada");
                break;
            case 11:
                // Implementar trainPath
                System.out.println("No implementada");
                break;
            case 12:
                return;
            default:
                System.out.println("Opción no válida. Intente nuevamente.");
        }
    }
}