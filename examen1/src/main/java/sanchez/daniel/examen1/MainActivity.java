package sanchez.daniel.examen1;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * Created by daniel.rodriguez on 20/12/2016.
 */

public class MainActivity extends AppCompatActivity {
    public LoginFragment loginFragment;
    public RegistroFragment registroFragment;
    MainActivityController mainActivityController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainActivityController = new MainActivityController(this);

        FragmentManager fm = getSupportFragmentManager(); //Referencia el objeto que gestiona los fragmentos

        registroFragment = (RegistroFragment) fm.findFragmentById(R.id.fragmentoRegistro);//Acceder a variables internas
        loginFragment = (LoginFragment) fm.findFragmentById(R.id.fragmentoLogin);

        registroFragment.setController(mainActivityController); //Para conectar el registro con el controller
        loginFragment.setController(mainActivityController); //Para conectar el login con el controller

        cambiarFragment(1); //Pasa a pantalla de login
    }

    public void cambiarFragment(int ifrg) { //Recibe por parámetro el número del fragment al que se va a cambiar
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.hide(loginFragment);
        transaction.hide(registroFragment);

        if (ifrg == 1) { //Si lo que llega por parámetro es un 1 se muestra loginFragment
            transaction.show(loginFragment);
        } else if (ifrg == 2) {
            transaction.show(registroFragment);
        }
        transaction.commit();
    }
}
