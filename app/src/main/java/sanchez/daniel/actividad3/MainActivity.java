package sanchez.daniel.actividad3;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import junit.framework.Test;

public class MainActivity extends AppCompatActivity {
    CreditosFragment creditosFragment;
    LoginFragment loginFragment;
    RegistroFragment registroFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getSupportFragmentManager(); //Referencia el objeto que gestiona los fragmentos
        creditosFragment = (CreditosFragment) fm.findFragmentById(R.id.fragmentoCreditos); //Acceder a variables internas
        loginFragment = (LoginFragment) fm.findFragmentById(R.id.fragmentoLogin);
        registroFragment = (RegistroFragment) fm.findFragmentById(R.id.fragmentoRegistro);

        cambiarFragment(1);
    }

    public void cambiarFragment(int ifrg) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.hide(creditosFragment);
        transaction.hide(loginFragment);
        transaction.hide(registroFragment);

        if (ifrg == 1) {
            transaction.show(creditosFragment);
        } else if (ifrg == 2) {
            transaction.show(loginFragment);
        } else if (ifrg == 3) {
            transaction.show(registroFragment);
        }
        transaction.commit();
    }
}