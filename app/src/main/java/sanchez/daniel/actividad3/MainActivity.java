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

        FragmentTransaction transaction = fm.beginTransaction();
        transaction.hide(creditosFragment);
        transaction.show(loginFragment);
        transaction.commit();


    }
}