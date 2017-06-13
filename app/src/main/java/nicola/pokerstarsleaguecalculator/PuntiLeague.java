package nicola.pokerstarsleaguecalculator;

/**
 *
 * @author nicola
 */
    public class PuntiLeague {

        static int premiati;
        double puntiAssegnati;
        double percentuale;

        static int aPremio(int iscritti) {
            premiati = (iscritti * 15) / 100;
            return premiati;
        }

        double puntiAssegnati(int iscritti, int posizione) {
            puntiAssegnati = 10 * (Math.sqrt(iscritti) / Math.sqrt(posizione));
            return puntiAssegnati;
        }

        double percentuale(int iscritti, int posizione) {
            percentuale = ((double) posizione * 100) / (double) iscritti;
            return percentuale;
        }
    }
