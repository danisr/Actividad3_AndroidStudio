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
public class MainActivityController implements View.OnClickListener, QBAdminListener {
    MainActivity vista;
    QBAdmin qbAdmin;

    public MainActivityController(MainActivity vista) {
        this.vista = vista;
        qbAdmin = new QBAdmin(this, vista);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnEntrar){ //Logearse en app
            qbAdmin.login(vista.loginFragment.txtUsuario.getText().toString(),
                    vista.loginFragment.txtPassword.getText().toString());
        }
        else if (view.getId() == R.id.btnIrRegistro){ //Se va a vista Registro
            vista.cambiarFragment(3);
        }
        else if(view.getId() == R.id.btnRegistrarse) { //Registrarse en app
            qbAdmin.registro(vista.registroFragment.txtUsuarioR.getText().toString(),
                    vista.registroFragment.txtEmailR.getText().toString(),
                    vista.registroFragment.txtPasswordR.getText().toString());
        }
        else if (view.getId() == R.id.btnIrLogin) { //Se va a vista Login
            vista.cambiarFragment(2);
        }
    }

    @Override
    public void registrado(boolean blRegistrado, QBUser User) {
        //syso(Registrado correctamente);
        if (blRegistrado) {
            vista.cambiarFragment(2);
        }
    }

    @Override
    public void logeado(boolean blLogeado, QBUser User) {
        if(blLogeado) {
            //cambio a 2ª mainactivity
        }
    }

    @Override
    public void datosDescargados(ArrayList<QBBaseCustomObject> datos) {
    }
}