package sanchez.daniel.actividad3;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;

import com.quickblox.core.model.QBBaseCustomObject;
import com.quickblox.users.model.QBUser;
import java.util.ArrayList;

import sanchez.daniel.libreria.QBAdmin;
import sanchez.daniel.libreria.QBAdminListener;

/**
 * Created by daniel.rodriguez on 01/12/2016.
 */
public class MainActivityController extends Activity implements View.OnClickListener, QBAdminListener {
    MainActivity vista;
    QBAdmin qbAdmin;

    public MainActivityController(MainActivity vista) {
        this.vista = vista;
        qbAdmin = new QBAdmin(this, this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == vista.loginFragment.btnRegistro.getId()) {
            //qbAdmin.login(vista.loginFragment.txtUsuario.getText().toString(),
                    //vista.loginFragment.txtPassword.getText().toString());
        }
    }

    @Override
    public void logeado(boolean blLogeado, QBUser User) {
        if(blLogeado == true) {

        }
    }

    @Override
    public void datosDescargados(ArrayList<QBBaseCustomObject> datos) {

    }
}
