# Laboratorio3_paradigmas
El menú se compila y ejecuta mediante: gradlew.bat build y gradlew.bat run, respectivamente, en la consola (CMD), con la dirección en la que se encuentra el código y los archivos txt. 
Una vez ejecutado el código se presentará el menú de inicio donde se encuentran las siguientes opciones:
1. Cargar información del sistema de metro
2. Visualizar estado actual del sistema de metro
3. Interactuar con el sistema de metro
4. Salir del programa
Si se desea cargar información se presenta el siguiente menú con las siguientes opciones:
	1. Creación de una línea de metro básica (cargar archivo lineas.txt)
  2. Combinaciones entre estaciones entre Líneas  (cargar archivo combinaciones.txt)
  3. Definición de trenes con distintos número de carros (cargar archivo trenes.txt)
  4. Conductores asignados a una Línea (cargar archivo conductores.txt)
  5. Retorno al menú de Inicio
Si se desea visualizar el estado del sistema de metro, se despliega directamente el metro con toda la información que sí ha sido cargada con las opciones anteriores, y se da como opción retornar al menú de inicio para seguir interactuando con el sistema.
En caso de querer interctuar con el sistema de metro se presenta el siguiente menú con las opciones para poder interactuar con la información cargada en el metro:
1. lineLength: obtener el largo total de una línea.
2. lineSectionLength: determinar el tracto entre una estación origen y final.
3. lineCost: determinar el costo total de recorrer una línea.
4. lineSectionCost: determinar el costo de un trayecto entre estación origen y final.
5. isLine: verificar si una línea cumple con las restricciones especificadas.
6. Train - addCar: añade un carro de pasajeros a un tren en la posición establecida.
7. Train - removeCar: remueve un carro de pasajeros de un tren en la posición establecida
8. Train - isTrain: verifica si un tren cumple con las especificaciones de los carros de pasajeros.
9. Train - fetchCapacity: entrega la capacidad máxima de pasajeros de un tren.
10. Subway - whereIsTrain: determina la ubicación de un tren a partir de una hora indicada del día.
11. Subway - trainPath: armar el recorrido del tren a partir de una hora especificada y que retorna la lista de estaciones futuras por recorrer.
12. Retorno al menú de Inicio

Finalmente, si en el menú de inicio se escogió la opción 1, 2 o 3, todos los menús presentan la opción de volver al menú de inicio para poder salir del programa con la opción 4.
