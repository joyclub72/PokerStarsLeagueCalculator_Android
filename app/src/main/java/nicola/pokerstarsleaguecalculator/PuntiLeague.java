package nicola.pokerstarsleaguecalculator;

/**
 *
 * @author nicola
 */
    public class PuntiLeague {

        static int premiati;
        static int mancanti;
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
        String mancanti(int premiati, int posizione) {
            mancanti = posizione-premiati;
            String strMancanti = String.valueOf(mancanti);
            return strMancanti;
    }
    }
