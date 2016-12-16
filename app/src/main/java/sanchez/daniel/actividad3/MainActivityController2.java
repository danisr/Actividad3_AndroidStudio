package sanchez.daniel.actividad3;

import android.view.View;
import com.quickblox.users.model.QBUser;
import java.util.HashMap;
import sanchez.daniel.libreria.QBAdmin;
import sanchez.daniel.libreria.QBAdminListener;

/**
 * Created by daniel.rodriguez on 13/12/2016.
 */
public class MainActivityController2 implements View.OnClickListener, View.OnFocusChangeListener, QBAdminListener {//Para gestionar todos los eventos del MainActivity
    MainActivity2 vista;//MainActivity
    QBAdmin qbAdmin;

    public MainActivityController2(MainActivity2 vista) {//Constructor
        this.vista = vista;//Pasar referencia a la Vista
        qbAdmin = new QBAdmin(this, vista);
    }

    @Override
    public void onClick(View bntPulsado) {
        if (bntPulsado.getId() == R.id.btnSpanish) {//Detectar que boton ha sido presionado
            //Se manda por parámetro a método descargarDatosQuickblox() de QBAdmin el idioma de quickblox
            qbAdmin.descargarDatosQuickblox("es");

        } else if (bntPulsado.getId() == R.id.btnEnglish) {
            qbAdmin.descargarDatosQuickblox("en");
        }
    }

    @Override
    public void onFocusChange(View view, boolean b) {
    }
    @Override
    public void registrado(boolean blRegistrado, QBUser User) {
    }
    @Override
    public void logeado(boolean blLogeado, QBUser User) {
    }

    @Override
    public void idiomasDescargados(HashMap<Integer, String> datosDesc) {

    }

}