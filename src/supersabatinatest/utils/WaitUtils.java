package supersabatinatest.utils;

public class WaitUtils {

    /**
     * Aguarda por um número especificado de segundos.
     *
     * @param seconds O tempo de espera em segundos.
     */
    public static void esperar(int seconds) {
        try {
            Thread.sleep(seconds * 1000L); // Convertendo segundos para milissegundos
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restaura o estado interrompido
            throw new RuntimeException("A espera foi interrompida.", e);
        }
    }
}
