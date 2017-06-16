package nicola.pokerstarsleaguecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText JTIscritti = (EditText)findViewById(R.id.JTIscritti);
        final EditText JTRimasti = (EditText)findViewById(R.id.JTRimasti);
        final TextView JLPremiati = (TextView) findViewById(R.id.JLPremiati);
        final TextView JLPercentuale = (TextView) findViewById(R.id.JLPercentuale);
        final TextView JLPunti = (TextView) findViewById(R.id.JLPunti);
        final TextView mancanti = (TextView) findViewById(R.id.mancanti);

        JTIscritti.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                premiati();

            }
            public void premiati() {
                if (JTIscritti.getText().length()!=0) {
                    PuntiLeague aPunti = new PuntiLeague();
                    String strIscritti = String.valueOf(JTIscritti.getText());
                    int iscritti = Integer.parseInt((strIscritti));
                    int premiati = aPunti.aPremio(iscritti);
                    String strPremiati = Integer.toString(premiati);
                    JLPremiati.setText(strPremiati);
                }
                else JLPremiati.setText("0");
            }
        });

        JTRimasti.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                punti();

            }
            public void punti() {

                if (JTRimasti.getText().length() !=0) {
                    PuntiLeague aPunti = new PuntiLeague();
                    String strIscritti = String.valueOf(JTIscritti.getText());
                    int iscritti = Integer.parseInt(strIscritti);
                    int premiati = aPunti.aPremio(iscritti);
                    String strPosizione = String.valueOf(JTRimasti.getText());
                    int posizione = Integer.parseInt(strPosizione);
                    double percentuale = aPunti.percentuale(iscritti, posizione);
                    String strPercentuale = String.format("%.4g%n", percentuale);
                    JLPercentuale.setText(strPercentuale);
                    if (posizione <= premiati) {
                        double puntiAssegnati = aPunti.puntiAssegnati(iscritti, posizione);
                        String strPuntiAssegnati = String.format("%.4g%n", puntiAssegnati);
                        JLPunti.setText(strPuntiAssegnati);
                        mancanti.setText("0");
                       }
                    else {
                        JLPunti.setText("0");
                        mancanti.setText(aPunti.mancanti(premiati,posizione));
                    }

                }
                else {
                    JLPunti.setText("0");
                    mancanti.setText("");
                }

            }
        });



    }


}
