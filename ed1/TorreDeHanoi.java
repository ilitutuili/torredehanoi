import java.util.concurrent.TimeUnit;

public class TorreDeHanoi {

    private static long movimentos;

    public static void main(String[] args) {
        int[] discosArray = {1, 10, 20, 30, 40, 41}; // Array de discos para teste

        for (int numDiscos : discosArray) {
            movimentos = 0;
            long startTime = System.nanoTime();
            resolverTorreDeHanoi(numDiscos, 'A', 'C', 'B');
            long endTime = System.nanoTime();

            long durationInMillis = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);
            String tempoFormatado = formatarTempo(durationInMillis);
            System.out.println("Número de discos: " + numDiscos);
            System.out.println("Número de movimentos: " + movimentos);
            System.out.println("Tempo gasto: " + tempoFormatado);
            System.out.println("-----------------------------");
        }
    }

    private static void resolverTorreDeHanoi(int n, char origem, char destino, char auxiliar) {
        if (n == 1) {
            movimentos++;
            return;
        }

        resolverTorreDeHanoi(n - 1, origem, auxiliar, destino);
        movimentos++;
        resolverTorreDeHanoi(n - 1, auxiliar, destino, origem);
    }

    private static String formatarTempo(long millis) {
        long horas = TimeUnit.MILLISECONDS.toHours(millis);
        millis -= TimeUnit.HOURS.toMillis(horas);

        long minutos = TimeUnit.MILLISECONDS.toMinutes(millis);
        millis -= TimeUnit.MINUTES.toMillis(minutos);

        long segundos = TimeUnit.MILLISECONDS.toSeconds(millis);
        millis -= TimeUnit.SECONDS.toMillis(segundos);

        return String.format("%02d:%02d:%02d:%03d", horas, minutos, segundos, millis);
    }
} 
