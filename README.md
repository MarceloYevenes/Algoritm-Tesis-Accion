# Ejemplo-Empresa-Acción en el ranking  
## Instrucciones   
1. Para usar el código simplemente ejecutar en la misma carpeta del código <strong>javac golfJava.java</strong> 
2. Luego ejecutar <strong>java golfJava</strong> 

Nota: El código puede ser abierto con algún IDE que soporte el lenguaje, en este caso fue ejecutado con la terminal de Mac 11.2 Big Sur  

### Edición de párametros  
Para buscar la probabilidad de que ocurra otro evento simplemente se deben modificar los párametros ubicados en la lineas 31 a 35, en donde las varaibles son:   
* paramSatisfaccion 
* paramCalidad 
* paramResponde 
* paramComunicacion 
* paramPrecio  

Cada una de estas variables tiene opciones válidas para que el código funcione, las opciones disponibles por variable son:  
* paramSatisfaccion = 1(Alta), 2(Media), 3(Baja).
* paramCalidad = 1(Alta), 2(Media), 3(Baja).  
* paramResponde =  1(Alta), 2(Baja). 
* paramComunicacion = 1(Alta), 2(Baja).
* paramPrecio = 1(Alta), 2(Media), 3(Baja).

Cada combinación producira una probabilidad distinta de sucesos, que determinara si la empresa sube, baja o se mantiene en el ranking, si se desea modificar los datos de entrenamiento, simplemente se debe modificar la matriz inicial llamada matrizValores, agregando filas extras o borrando algunas.  
