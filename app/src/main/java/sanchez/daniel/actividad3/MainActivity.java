package sanchez.daniel.actividad3;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    CreditosFragment creditosFragment;
    public LoginFragment loginFragment;
    RegistroFragment registroFragment;
    MainActivityController mainActivityController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainActivityController=new MainActivityController(this);

        FragmentManager fm = getSupportFragmentManager(); //Referencia el objeto que gestiona los fragmentos

        creditosFragment = (CreditosFragment) fm.findFragmentById(R.id.fragmentoCreditos); //Acceder a variables internas
        registroFragment = (RegistroFragment) fm.findFragmentById(R.id.fragmentoRegistro);
        loginFragment = (LoginFragment) fm.findFragmentById(R.id.fragmentoLogin);

        registroFragment.setController(mainActivityController); //Para conectar el registro con el controller
        loginFragment.setController(mainActivityController); //Para conectar el login con el controller

        cambiarFragment(1); //Pasa a pantalla de creditos
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
}