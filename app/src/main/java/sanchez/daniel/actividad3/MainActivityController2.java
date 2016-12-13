package sanchez.daniel.actividad3;

import android.view.View;

/**
 * Created by daniel.rodriguez on 13/12/2016.
 */
public class MainActivityController2 implements View.OnClickListener, View.OnFocusChangeListener {//Para gestionar todos los eventos del MainActivity
    MainActivity2 vista;//MainActivity

    public MainActivityController2(MainActivity2 vista) {//Constructor
        this.vista = vista;//Pasar referencia a la Vista
    }

    @Override
    public void onClick(View bntPulsado) {
        if (bntPulsado.getId() == R.id.btnSpanish) {//Detectar que boton ha sido presionado
            vista.btnSpanish.setText("Español");
            vista.btnEnglish.setText("Ingles");

            //Descargar datos de quickblox, hacer la Select


        } else if (bntPulsado.getId() == R.id.btnEnglish) {
            vista.btnSpanish.setText("Spanish");
            vista.btnEnglish.setText("English");

            //Descargar datos de quickblox, hacer la Select

        }
    }

    @Override
    public void onFocusChange(View view, boolean b) {

    }
}
