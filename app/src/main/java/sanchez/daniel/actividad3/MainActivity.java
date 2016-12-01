package sanchez.daniel.actividad3;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.quickblox.core.model.QBBaseCustomObject;
import com.quickblox.users.model.QBUser;
import java.util.ArrayList;
import sanchez.daniel.libreria.QBAdmin;
import sanchez.daniel.libreria.QBAdminListener;

public class MainActivity extends AppCompatActivity implements QBAdminListener {
    CreditosFragment creditosFragment;
    LoginFragment loginFragment;
    RegistroFragment registroFragment;
    QBAdmin qbAdmin;
    public EditText txtUsuario;
    public EditText txtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtUsuario=(EditText)this.findViewById(R.id.txtUsuario);
        txtPassword=(EditText)this.findViewById(R.id.txtPassword);

        FragmentManager fm = getSupportFragmentManager(); //Referencia el objeto que gestiona los fragmentos
        creditosFragment = (CreditosFragment) fm.findFragmentById(R.id.fragmentoCreditos); //Acceder a variables internas
        loginFragment = (LoginFragment) fm.findFragmentById(R.id.fragmentoLogin);
        registroFragment = (RegistroFragment) fm.findFragmentById(R.id.fragmentoRegistro);

        cambiarFragment(1);

        qbAdmin = new QBAdmin(this, this); //El 1º this es the MainActivity y el 2º this es de Activity
        qbAdmin.login("usuario", "password");
        qbAdmin.selectDeTabla(); //Se llama a método de QBAdmin
    }

    public void cambiarFragment(int ifrg) { //Recibe por parámetro el número del fragment al que se va a cambiar
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.hide(creditosFragment); //Se ocultan todos los fragments
        transaction.hide(loginFragment);
        transaction.hide(registroFragment);

        if (ifrg == 1) { //Si lo que llega por parámetro es un 1 se muestra creditosFragment
            transaction.show(creditosFragment);
        } else if (ifrg == 2) {
            transaction.show(loginFragment);
        } else if (ifrg == 3) {
            transaction.show(registroFragment);
        }
        transaction.commit();
    }

    @Override
    public void logeado(boolean blLogeado, QBUser user) {
        //syso(Me he logeado)
    }

    @Override
    public void datosDescargados(ArrayList<QBBaseCustomObject> datos) {

    }
}