package org.factoriaf5.acatest; //...f5.elnombredelacarpetaenlazada

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

// import org.assertj.core.util.Arrays; si no lo comento choca con la línea anterior, y si no pongo lo anterior falla el test 4
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ExercisesAcaTest {

    private ExercisesAca exercises; // crea una instancia privada llamada exercises, que al ser privada solo se
                                    // puede utilizar dentro de la clase padre --> ExercisesAcaTest

    @BeforeEach // indica que antes de cada test el contenido de este public void, que es
                // instanciar exercises
    public void init() {
        this.exercises = new ExercisesAca(); // crea la instancia exercises ??
    }

    @Test // esto es una anotación en spring boot, es decir indicarle que tiene que hacer
          // eso... un test

    // test método 1
    public void testSumar() {

        // crear la instancia de la clase de donde está el fichero origen
        // ExercisesAca exercises = new ExercisesAca(); comento esta línea pq la
        // sustituyo por las líneas desde la 12 a la 19
        // para no tener que instanciarlas cada vez que hago un test

        // Given (solo si es positivo, en caso de negativo sería otra forma)
        int num1 = 35; // parametros
        int num2 = 79;

        // When (si es negativo, se juntan when y then)
        int result = exercises.sumar(num1, num2); // instanciacreada.metodousadoenficheroorigen

        // Then
        assertEquals(114, result);
        assertTrue(result > 100);
        assertFalse(result > 120);
        assertNotNull(result);
        assertInstanceOf(Integer.class, result);
    }

    @Test
    // test método 2
    public void testCheckPositivo() {

        // given
        int num = 5;

        // when
        boolean result = exercises.checkPositivo(num);

        // when
        assertTrue(result);
    }

    @Test
    // test método 2, caso negativo
    public void testCheckPositivoError() {
        // given
        int num = -4;

        // when & then
        assertThrows(IllegalArgumentException.class, () -> { // la flecha es una expresión lambda, se usa para separar
                                                             // los parametros de una expresión (a izq y dch de la
                                                             // flecha)
            exercises.checkPositivo(num);
        });
    }

    @Test
    // test método 3, solo cuenta las minúsculas
    public void testContarLetrasA() {
        String texto = "Acacia";
        int result = exercises.contarLetrasA(texto);
        // la siguiente línea convierte el texto a minúsculas antes de pasarlo al
        // método, así contaría tanto mayusc como minusc
        // int result = exercises.contarLetrasA(texto.toLowerCase());
        assertEquals(2, result);
        assertTrue(result > 1);
        assertFalse(result < 1);
    }

    @Test
    // test método 4 -->> ESTE NO LO ACABO DE ENTENDER BIEN, TIENE MUCHAS
    // INSTRUCCIONES NUEVAS PARA MI
    public void testContieneElemento() {
        String texto = "hola mundo";
        List<String> lista = Arrays.asList("hola", "mundo", "hola mundo");
        boolean result = exercises.contieneElemento(lista, texto);
        assertTrue(result);
    }

    @Test
    // test método 5
    public void testRevertirCadena() {
        String texto = "hola mundo";
        String result = exercises.revertirCadena(texto);
        assertEquals(result, "odnum aloh");
    }

    @Test
    // test método 6
    public void testFactorial() {
        int num = 20;
        long result = exercises.factorial(num);
        assertEquals(2432902008176640000L, result);
        assertThrows(IllegalArgumentException.class, () -> {  // test si negativo
            exercises.factorial(-1);
        });
    }

    @Test
    // test método 7
    public void testEsPrimo() {
        int num = 4;
        boolean result = exercises.esPrimo(num);
        // assertTrue(result);
        assertFalse(result);

        assertFalse(exercises.esPrimo(0)); // No es primo
        assertTrue(exercises.esPrimo(3));  // Es primo
        assertFalse(exercises.esPrimo(-1)); // No es primo

        // Número no primo (15), el bucle debe encontrar que 15 es divisible por 3
        num = 15;
        result = exercises.esPrimo(num);
        assertFalse(result);
    }

    @Test
    // test método 8 -->> ESTE NO LO ACABO DE ENTENDER BIEN, TIENE MUCHAS
    // INSTRUCCIONES "RARAS" PARA MI
    public void testMensajeConRetraso() throws InterruptedException {
        // como no usa variables, no se ponen aquí...
        String result = exercises.mensajeConRetraso();
        assertEquals("Listo después de retraso", result);
        assertTrue(result.contains("Listo"));
    }

    @Test
    // test método 9
    public void testConvertirAString() {
        List<Integer> num = Arrays.asList(5, 4, 3);
        List<String> lista = exercises.convertirAString(num);
        List<String> result = Arrays.asList("5", "4", "3");
        assertEquals(result, lista);
    }

    @Test
    // test método 10
    public void testCalcularMedia() {
        List<Integer> listanum = Arrays.asList(5, 3, 1);
        double result = exercises.calcularMedia(listanum);
        assertEquals(3, result);
        assertNotNull(result);

        
    }


        // 10. Método que calcula la media de una lista de enteros
        public double calcularMedia(List<Integer> lista) {
            if (lista == null || lista.isEmpty()) {
                throw new IllegalArgumentException("La lista no puede ser nula o vacía");
            }
            return lista.stream()
                    .mapToInt(Integer::intValue)
                    .average()
                    .getAsDouble();
        }

        

    @Test
    // test método 11 ¡¡ the last one !! lol
    public void testConvertirListaAString() {
        List<String> lista = Arrays.asList("uno", null, "dos", "tres");
        String result = exercises.convertirListaAString(lista);
        String expected = "UNO,NULL,DOS,TRES";
        assertEquals(expected, result);
    }

}
