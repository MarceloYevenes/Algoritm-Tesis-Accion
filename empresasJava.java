/**
 * @author: Marcelo Yévenes Moreno
 * @version: 1.0 04 de diciembre del 2020
 */

public class empresasJava {

    public static void main(String[] args) {

        /*
         * Parametros aceptados Satisfacción del cliente Alta: 1 Media: 2 Baja: 3
         * Calidad Alta: 1 Media: 2 Baja: 3 Responde necesidades del cliente Alta: 1
         * Baja: 2 Comunicación permanente Alta: 1 Baja: 2 Precio Alta: 1 Media: 2 Baja:
         * 3 Accion ranking Sube: 1 Se mantiene: 2 Baja: 3
         */

        /*
         * Esta matriz representa la tabla que se debe extraer de la base de datos que
         * por motivos practivos se utiliza una matriz para evitar utilizar una bd, se
         * usara una matriz de int para poder llenar cada valor según corresponda
         */

        // [Satisfaccion][Calidad][Res. necesidades del cliente][Comunicacion]
        // [Precio][Accíon en el ranking]
        int[][] matrizValores = { { 1, 1, 1, 1, 1, 1, 2 }, { 2, 2, 2, 2, 2, 2, 2 }, { 3, 2, 2, 2, 2, 3, 2 },
                { 4, 3, 3, 2, 2, 3, 2 }, { 1, 1, 1, 1, 1, 1, 2 }, { 2, 2, 2, 1, 2, 2, 2 }, { 3, 2, 3, 2, 2, 3, 3 },
                { 4, 3, 1, 2, 2, 2, 1 }, { 1, 1, 1, 1, 1, 1, 2 }, { 2, 3, 2, 2, 2, 2, 3 }, { 3, 2, 3, 1, 2, 2, 1 },
                { 4, 3, 3, 2, 2, 3, 2 }, };

        // Parámetros que debe indicar el usuario que serán los que quiere averiguar
        int paramSatisfaccion = 3; // Alta
        int paramCalidad = 1; // Alta
        int paramResponde = 2; // Baja
        int paramComunicacion = 1; // Alta
        int paramPrecio = 2; // Media

        // Probabilidad de accion en el
        int cantidadSube;
        int cantidadSeMantiene;
        int cantidadBaja;

        cantidadSube = calcularCantidadAcciones(matrizValores, 1);
        cantidadSeMantiene = calcularCantidadAcciones(matrizValores, 2);
        cantidadBaja = calcularCantidadAcciones(matrizValores, 3);

        int i, j;

        double probabilidadSube;
        double probabilidadSeMantiene;
        double probabilidadBaja;

        probabilidadSube = Double.valueOf(cantidadSube) / Double.valueOf(matrizValores.length);
        probabilidadSeMantiene = Double.valueOf(cantidadSeMantiene) / Double.valueOf(matrizValores.length);
        probabilidadBaja = Double.valueOf(cantidadBaja) / Double.valueOf(matrizValores.length);

        System.out.printf("La probabilidad actual que suba en el ránking es: %f \n", probabilidadSube);
        System.out.printf("La probabilidad actual que se mantenga en el ránking es: %f \n", probabilidadSeMantiene);
        System.out.printf("La probabilidad actual que baje en el ránking es: %f \n", probabilidadBaja);

        // matrices de frecuencia para empresas
        double[][] matrizFrecuenciaSube = new double[3][5];
        double[][] matrizFrecuenciaSeMantiene = new double[3][5];
        double[][] matrizFrecuenciaBaja = new double[3][5];

        // Se llenan ambas matrices con 0 para evitar espacion con valores no definidos
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 5; j++) {
                matrizFrecuenciaSube[i][j] = 0.0;
                matrizFrecuenciaSeMantiene[i][j] = 0.0;
                matrizFrecuenciaBaja[i][j] = 0.0;
            }
        }

        // matrices de probabilidad
        double[][] matrizProbabilidadSube = new double[3][5];
        double[][] matrizProbabilidadSeMantiene = new double[3][5];
        double[][] matrizProbabilidadBaja = new double[3][5];

        // Satisfaccion Cliente - Sube
        double contadorSatisfaccionAltaSube = 0.0;
        double contadorSatisfaccionMediaSube = 0.0;
        double contadorSatisfaccionBajaSube = 0.0;

        // Satisfaccion Cliente - Se mantiene
        double contadorSatisfaccionAltaSeMantiene = 0.0;
        double contadorSatisfaccionMediaSeMantiene = 0.0;
        double contadorSatisfaccionBajaSeMantiene = 0.0;

        // Satisfaccion Cliente - Baja
        double contadorSatisfaccionAltaBaja = 0.0;
        double contadorSatisfaccionMediaBaja = 0.0;
        double contadorSatisfaccionBajaBaja = 0.0;

        // Calidad - Sube
        double contadorCalidadAltaSube = 0.0;
        double contadorCalidadMediaSube = 0.0;
        double contadorCalidadBajaSube = 0.0;

        // Calidad - Se mantiene
        double contadorCalidadAltaSeMantiene = 0.0;
        double contadorCalidadMediaSeMantiene = 0.0;
        double contadorCalidadBajaSeMantiene = 0.0;

        // Calidad - Baja
        double contadorCalidadAltaBaja = 0.0;
        double contadorCalidadMediaBaja = 0.0;
        double contadorCalidadBajaBaja = 0.0;

        // Responde - Sube
        double contadorRespondeAltaSube = 0.0;
        double contadorRespondeBajaSube = 0.0;

        // Responde - Se mantiene
        double contadorRespondeAltaSeMantiene = 0.0;
        double contadorRespondeBajaSeMantiene = 0.0;

        // Responde - Baja
        double contadorRespondeAltaBaja = 0.0;
        double contadorRespondeBajaBaja = 0.0;

        // Comunicacion - Sube
        double contadorComunicacionAltaSube = 0.0;
        double contadorComunicacionBajaSube = 0.0;

        // Comunicacion - Se Mantiene
        double contadorComunicacionAltaSeMantiene = 0.0;
        double contadorComunicacionBajaSeMantiene = 0.0;

        // Comunicacion - Baja
        double contadorComunicacionAltaBaja = 0.0;
        double contadorComunicacionBajaBaja = 0.0;

        // Precio Cliente - Sube
        double contadorPrecioAltaSube = 0.0;
        double contadorPrecioMediaSube = 0.0;
        double contadorPrecioBajaSube = 0.0;

        // Precio Cliente - Se mantiene
        double contadorPrecioAltaSeMantiene = 0.0;
        double contadorPrecioMediaSeMantiene = 0.0;
        double contadorPrecioBajaSeMantiene = 0.0;

        // Precio Cliente - Baja
        double contadorPrecioAltaBaja = 0.0;
        double contadorPrecioMediaBaja = 0.0;
        double contadorPrecioBajaBaja = 0.0;

        for (i = 0; i < matrizValores.length; i++) {

            // -----Sube(matrizValores[i][0]==1)-----

            // Satisfaccion - Alta
            if (matrizValores[i][1] == (1) && matrizValores[i][6] == (1)) {
                contadorSatisfaccionAltaSube++;
            }

            // Satisfaccion - Media
            if (matrizValores[i][1] == (2) && matrizValores[i][6] == (1)) {
                contadorSatisfaccionMediaSube++;
            }

            // Satisfaccion - Baja
            if (matrizValores[i][1] == (3) && matrizValores[i][6] == (1)) {
                contadorSatisfaccionBajaSube++;
            }

            // Calidad - Alta
            if (matrizValores[i][2] == (1) && matrizValores[i][6] == (1)) {
                contadorCalidadAltaSube++;
            }

            // Calidad - Media
            if (matrizValores[i][2] == (2) && matrizValores[i][6] == (1)) {
                contadorCalidadMediaSube++;
            }

            // Calidad - Baja
            if (matrizValores[i][2] == (3) && matrizValores[i][6] == (1)) {
                contadorCalidadBajaSube++;
            }

            // Responde - Alta
            if (matrizValores[i][3] == (1) && matrizValores[i][6] == (1)) {
                contadorRespondeAltaSube++;
            }

            // Responde - Baja
            if (matrizValores[i][3] == (2) && matrizValores[i][6] == (1)) {
                contadorRespondeBajaSube++;
            }

            // Comunicacion - Alta
            if (matrizValores[i][4] == (1) && matrizValores[i][6] == (1)) {
                contadorComunicacionAltaSube++;
            }

            // Comunicacion - Baja
            if (matrizValores[i][4] == (2) && matrizValores[i][6] == (1)) {
                contadorComunicacionBajaSube++;
            }

            // Precio - Alta
            if (matrizValores[i][5] == (1) && matrizValores[i][6] == (1)) {
                contadorPrecioAltaSube++;
            }

            // Precio - Media
            if (matrizValores[i][5] == (2) && matrizValores[i][6] == (1)) {
                contadorPrecioMediaSube++;
            }

            // Precio - Baja
            if (matrizValores[i][5] == (3) && matrizValores[i][6] == (1)) {
                contadorPrecioBajaSube++;
            }

            // -----Se Mantiene(matrizValores[i][0]==2)-----

            // Satisfaccion - Alta
            if (matrizValores[i][1] == (1) && matrizValores[i][6] == (2)) {
                contadorSatisfaccionAltaSeMantiene++;
            }

            // Satisfaccion - Media
            if (matrizValores[i][1] == (2) && matrizValores[i][6] == (2)) {
                contadorSatisfaccionMediaSeMantiene++;
            }

            // Satisfaccion - Baja
            if (matrizValores[i][1] == (3) && matrizValores[i][6] == (2)) {
                contadorSatisfaccionBajaSeMantiene++;
            }

            // Calidad - Alta
            if (matrizValores[i][2] == (1) && matrizValores[i][6] == (2)) {
                contadorCalidadAltaSeMantiene++;
            }

            // Calidad - Media
            if (matrizValores[i][2] == (2) && matrizValores[i][6] == (2)) {
                contadorCalidadMediaSeMantiene++;
            }

            // Calidad - Baja
            if (matrizValores[i][2] == (3) && matrizValores[i][6] == (2)) {
                contadorCalidadBajaSeMantiene++;
            }

            // Responde - Alta
            if (matrizValores[i][3] == (1) && matrizValores[i][6] == (2)) {
                contadorRespondeAltaSeMantiene++;
            }

            // Responde - Baja
            if (matrizValores[i][3] == (2) && matrizValores[i][6] == (2)) {
                contadorRespondeBajaSeMantiene++;
            }

            // Comunicacion - Alta
            if (matrizValores[i][4] == (1) && matrizValores[i][6] == (2)) {
                contadorComunicacionAltaSeMantiene++;
            }

            // Comunicacion - Baja
            if (matrizValores[i][4] == (2) && matrizValores[i][6] == (2)) {
                contadorComunicacionBajaSeMantiene++;
            }

            // Precio - Alta
            if (matrizValores[i][5] == (1) && matrizValores[i][6] == (2)) {
                contadorPrecioAltaSeMantiene++;
            }

            // Precio - Media
            if (matrizValores[i][5] == (2) && matrizValores[i][6] == (2)) {
                contadorPrecioMediaSeMantiene++;
            }

            // Precio - Baja
            if (matrizValores[i][5] == (3) && matrizValores[i][6] == (2)) {
                contadorPrecioBajaSeMantiene++;
            }

            // -----Baja (matrizValores[i][0]==3)-----

            // Satisfaccion - Alta
            if (matrizValores[i][1] == (1) && matrizValores[i][6] == (3)) {
                contadorSatisfaccionAltaBaja++;
            }

            // Satisfaccion - Media
            if (matrizValores[i][1] == (2) && matrizValores[i][6] == (3)) {
                contadorSatisfaccionMediaBaja++;
            }

            // Satisfaccion - Baja
            if (matrizValores[i][1] == (3) && matrizValores[i][6] == (3)) {
                contadorSatisfaccionBajaBaja++;
            }

            // Calidad - Alta
            if (matrizValores[i][2] == (1) && matrizValores[i][6] == (3)) {
                contadorCalidadAltaBaja++;
            }

            // Calidad - Media
            if (matrizValores[i][2] == (2) && matrizValores[i][6] == (3)) {
                contadorCalidadMediaBaja++;
            }

            // Calidad - Baja
            if (matrizValores[i][2] == (3) && matrizValores[i][6] == (3)) {
                contadorCalidadBajaBaja++;
            }

            // Responde - Alta
            if (matrizValores[i][3] == (1) && matrizValores[i][6] == (3)) {
                contadorRespondeAltaBaja++;
            }

            // Responde - Baja
            if (matrizValores[i][3] == (2) && matrizValores[i][6] == (3)) {
                contadorRespondeBajaBaja++;
            }

            // Comunicacion - Alta
            if (matrizValores[i][4] == (1) && matrizValores[i][6] == (3)) {
                contadorComunicacionAltaBaja++;
            }

            // Comunicacion - Baja
            if (matrizValores[i][4] == (2) && matrizValores[i][6] == (3)) {
                contadorComunicacionBajaBaja++;
            }

            // Precio - Alta
            if (matrizValores[i][5] == (1) && matrizValores[i][6] == (3)) {
                contadorPrecioAltaBaja++;
            }

            // Precio - Media
            if (matrizValores[i][5] == (2) && matrizValores[i][6] == (3)) {
                contadorPrecioMediaBaja++;
            }

            // Precio - Baja
            if (matrizValores[i][5] == (3) && matrizValores[i][6] == (3)) {
                contadorPrecioBajaBaja++;
            }

        }

        // Se llenan y muestran los datos de las tablas de frecuencia

        // Para sube
        matrizFrecuenciaSube[0][0] = contadorSatisfaccionAltaSube;
        matrizFrecuenciaSube[1][0] = contadorSatisfaccionMediaSube;
        matrizFrecuenciaSube[2][0] = contadorSatisfaccionBajaSube;

        matrizFrecuenciaSube[0][1] = contadorCalidadAltaSube;
        matrizFrecuenciaSube[1][1] = contadorCalidadMediaSube;
        matrizFrecuenciaSube[2][1] = contadorCalidadBajaSube;

        matrizFrecuenciaSube[0][2] = contadorRespondeAltaSube;
        matrizFrecuenciaSube[1][2] = contadorRespondeBajaSube;

        matrizFrecuenciaSube[0][3] = contadorComunicacionAltaSube;
        matrizFrecuenciaSube[1][3] = contadorComunicacionBajaSube;

        matrizFrecuenciaSube[0][4] = contadorPrecioAltaSube;
        matrizFrecuenciaSube[1][4] = contadorPrecioMediaSube;
        matrizFrecuenciaSube[2][4] = contadorPrecioBajaSube;

        // Empresa 1
        System.out.println("------------------------------------------");
        System.out.println("Tabla de frecuencia de sube:");
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 5; j++) {
                System.out.printf("%f ", matrizFrecuenciaSube[i][j]);
            }
            System.out.print("\n");
        }

        // Para se mantiene
        matrizFrecuenciaSeMantiene[0][0] = contadorSatisfaccionAltaSeMantiene;
        matrizFrecuenciaSeMantiene[1][0] = contadorSatisfaccionMediaSeMantiene;
        matrizFrecuenciaSeMantiene[2][0] = contadorSatisfaccionBajaSeMantiene;

        matrizFrecuenciaSeMantiene[0][1] = contadorCalidadAltaSeMantiene;
        matrizFrecuenciaSeMantiene[1][1] = contadorCalidadMediaSeMantiene;
        matrizFrecuenciaSeMantiene[2][1] = contadorCalidadBajaSeMantiene;

        matrizFrecuenciaSeMantiene[0][2] = contadorRespondeAltaSeMantiene;
        matrizFrecuenciaSeMantiene[1][2] = contadorRespondeBajaSeMantiene;

        matrizFrecuenciaSeMantiene[0][3] = contadorComunicacionAltaSeMantiene;
        matrizFrecuenciaSeMantiene[1][3] = contadorComunicacionBajaSeMantiene;

        matrizFrecuenciaSeMantiene[0][4] = contadorPrecioAltaSeMantiene;
        matrizFrecuenciaSeMantiene[1][4] = contadorPrecioMediaSeMantiene;
        matrizFrecuenciaSeMantiene[2][4] = contadorPrecioBajaSeMantiene;

        // Se mantiene
        System.out.println("------------------------------------------");
        System.out.println("Tabla de frecuencia de se mantiene:");
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 5; j++) {
                System.out.printf("%f ", matrizFrecuenciaSeMantiene[i][j]);
            }
            System.out.print("\n");
        }

        // Para Baja
        matrizFrecuenciaBaja[0][0] = contadorSatisfaccionAltaBaja;
        matrizFrecuenciaBaja[1][0] = contadorSatisfaccionMediaBaja;
        matrizFrecuenciaBaja[2][0] = contadorSatisfaccionBajaBaja;

        matrizFrecuenciaBaja[0][1] = contadorCalidadAltaBaja;
        matrizFrecuenciaBaja[1][1] = contadorCalidadMediaBaja;
        matrizFrecuenciaBaja[2][1] = contadorCalidadBajaBaja;

        matrizFrecuenciaBaja[0][2] = contadorRespondeAltaBaja;
        matrizFrecuenciaBaja[1][2] = contadorRespondeBajaBaja;

        matrizFrecuenciaBaja[0][3] = contadorComunicacionAltaBaja;
        matrizFrecuenciaBaja[1][3] = contadorComunicacionBajaBaja;

        matrizFrecuenciaBaja[0][4] = contadorPrecioAltaBaja;
        matrizFrecuenciaBaja[1][4] = contadorPrecioMediaBaja;
        matrizFrecuenciaBaja[2][4] = contadorPrecioBajaBaja;

        // Baja
        System.out.println("------------------------------------------");
        System.out.println("Tabla de frecuencia de baja:");
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 5; j++) {
                System.out.printf("%f ", matrizFrecuenciaBaja[i][j]);
            }
            System.out.print("\n");
        }

        // Comprobar si las matrices tienen algun valor 0 en caso que alguna tenga un
        // valor 0 se debe normalizar la matriz

        Boolean valorCeroSube = encontrarValorCero(matrizFrecuenciaSube);
        Boolean valorCeroSeMantiene = encontrarValorCero(matrizFrecuenciaSeMantiene);
        Boolean valorCeroBaja = encontrarValorCero(matrizFrecuenciaBaja);

        // Se deben normalizar las matrices de frecuencia si se encuentra un 0;
        if (valorCeroSube) {
            System.out.println("------------------------------------------");
            System.out.println("Matriz normalizada Sube");
            for (i = 0; i < 3; i++) {
                for (j = 0; j < 5; j++) {
                    matrizFrecuenciaSube[i][j] += 1;
                    System.out.printf("%f ", matrizFrecuenciaSube[i][j]);
                }
                System.out.print("\n");
            }
        }

        if (valorCeroSeMantiene) {
            System.out.println("------------------------------------------");
            System.out.println("Matriz normalizada Se mantiene");
            for (i = 0; i < 3; i++) {
                for (j = 0; j < 5; j++) {
                    matrizFrecuenciaSeMantiene[i][j] += 1;
                    System.out.printf("%f ", matrizFrecuenciaSeMantiene[i][j]);
                }
                System.out.print("\n");
            }
        }

        if (valorCeroBaja) {
            System.out.println("------------------------------------------");
            System.out.println("Matriz normalizada Baja");
            for (i = 0; i < 3; i++) {
                for (j = 0; j < 5; j++) {
                    matrizFrecuenciaBaja[i][j] += 1;
                    System.out.printf("%f ", matrizFrecuenciaBaja[i][j]);
                }
                System.out.print("\n");
            }
        }

        /*
         * Se debe obtener la suma de una columna de ambas matrices para obtener la
         * probabilidades respectivas para cada evento
         */
        double sumColMatrizSube = sumColumnas(matrizFrecuenciaSube);
        double sumColMatrizSeMantiene = sumColumnas(matrizFrecuenciaSeMantiene);
        double sumColMatrizBaja = sumColumnas(matrizFrecuenciaBaja);
        System.out.println("------------------------------------------");

        // Matriz de probabilida para Sube
        System.out.println("Matriz de probabilidad para Sube");
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 5; j++) {
                matrizProbabilidadSube[i][j] = (matrizFrecuenciaSube[i][j]) / (sumColMatrizSube);
                System.out.printf("%f ", matrizProbabilidadSube[i][j]);
            }
            System.out.print("\n");
        }
        System.out.println("------------------------------------------");

        // Matriz de probabilida para Se mantiene
        System.out.println("Matriz de probabilidad para Se mantiene");
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 5; j++) {
                matrizProbabilidadSeMantiene[i][j] = (matrizFrecuenciaSeMantiene[i][j]) / (sumColMatrizSeMantiene);
                System.out.printf("%f ", matrizProbabilidadSeMantiene[i][j]);
            }
            System.out.print("\n");
        }
        System.out.println("------------------------------------------");

        // Matriz de probabilida para Baja
        System.out.println("Matriz de probabilidad para Baja");
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 5; j++) {
                matrizProbabilidadBaja[i][j] = (matrizFrecuenciaBaja[i][j]) / (sumColMatrizBaja);
                System.out.printf("%f ", matrizProbabilidadBaja[i][j]);
            }
            System.out.print("\n");
        }
        System.out.println("------------------------------------------");

        // Determinar factor para Sube
        double factorSube = determinarFactorProbabilidad(paramSatisfaccion, paramCalidad, paramResponde,
                paramComunicacion, paramPrecio, matrizProbabilidadSube, probabilidadSube);

        // Determinar factor para se Mantiene
        double factorSeMantiene = determinarFactorProbabilidad(paramSatisfaccion, paramCalidad, paramResponde,
                paramComunicacion, paramPrecio, matrizProbabilidadSeMantiene, probabilidadSeMantiene);

        // Determinar factor para Baja
        double factorBaja = determinarFactorProbabilidad(paramSatisfaccion, paramCalidad, paramResponde,
                paramComunicacion, paramPrecio, matrizProbabilidadBaja, probabilidadBaja);

        double sumaTotalFactores = factorSube + factorSeMantiene + factorBaja;

        /* System.out.println(factorSube);
        System.out.println(factorSeMantiene);
        System.out.println(factorBaja); */

        double probabilidadFinalSube = (factorSube / sumaTotalFactores) * 100;
        double probabilidadFinalSeMantenga = (factorSeMantiene / sumaTotalFactores) * 100;
        double probabilidadFinalBaje = (factorBaja / sumaTotalFactores) * 100;

        System.out.printf("Probabilidad de que suba: %f por ciento \n", probabilidadFinalSube);
        System.out.printf("Probabilidad de que se mantenga: %f por ciento \n", probabilidadFinalSeMantenga);
        System.out.printf("Probabilidad de que suba: %f por ciento \n", probabilidadFinalBaje);

    }

    // Funcion que calcula la cantidad de partidos jugados
    public static int calcularCantidadAcciones(int[][] matrizDatos, int acccionBuscar) {
        int cantidadaccion = 0;
        for (int i = 0; i < matrizDatos.length; i++) {
            if (matrizDatos[i][6] == acccionBuscar) {
                cantidadaccion++;
            }
        }
        return cantidadaccion;
    }

    public static boolean encontrarValorCero(double[][] matrizObjetivo) {
        int row, colum;
        for (row = 0; row < matrizObjetivo.length; row++) {
            for (colum = 0; colum < matrizObjetivo[row].length; colum++) {
                if (matrizObjetivo[row][colum] == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public static double sumColumnas(double[][] matrizObjetivo) {
        int row;
        double total = 0.0;
        for (row = 0; row < matrizObjetivo.length; row++) {
            total += matrizObjetivo[row][0];
        }
        return total;
    }

    public static double determinarFactorProbabilidad(int paramSatisfaccion, int paramCalidad, int paramResponde,
            int paramComunicacion, int paramPrecio, double[][] matrizObjetivo, double probTotal) {

        double totalFactor;

        double proSatisfaccion = matrizObjetivo[paramSatisfaccion - 1][0];
        double probCalidad = matrizObjetivo[paramCalidad - 1][1];
        double probResponde = matrizObjetivo[paramResponde - 1][2];
        double probComunicacion = matrizObjetivo[paramComunicacion - 1][3];
        double probPrecio = matrizObjetivo[paramPrecio - 1][4];

        totalFactor = proSatisfaccion * probCalidad * probResponde * probComunicacion * probPrecio * probTotal;
        return totalFactor;
    }

}