package sanchez.daniel.examen1;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by daniel.rodriguez on 20/12/2016.
 */

public class MainActivity2 extends AppCompatActivity {
    public CategoriasFragment categoriasFragment;
    public NoticiasFragment noticiasFragment;
    public DetallesFragment detallesFragment;
    MainActivityController2 mainActivityController2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mainActivityController2 = new MainActivityController2(this);

        FragmentManager fm = getSupportFragmentManager(); //Referencia el objeto que gestiona los fragmentos

        categoriasFragment = (CategoriasFragment) fm.findFragmentById(R.id.fragmentoCategoria);//Acceder a variables internas
        noticiasFragment = (NoticiasFragment) fm.findFragmentById(R.id.fragmentoNoticias);
        detallesFragment = (DetallesFragment) fm.findFragmentById(R.id.fragmentoDetalles);

        categoriasFragment.setController(mainActivityController2);
        noticiasFragment.setController(mainActivityController2);
        detallesFragment.setController(mainActivityController2);

        cambiarFragment(1); //Pasa a pantalla de categorias
    }

    public void cambiarFragment(int ifrg) { //Recibe por parámetro el número del fragment al que se va a cambiar
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.hide(categoriasFragment);
        transaction.hide(noticiasFragment);
        transaction.hide(detallesFragment);

        if (ifrg == 1) { //Si lo que llega por parámetro es un 1 se muestra categoriasFragment
            transaction.show(categoriasFragment);
        } else if (ifrg == 2) {
            transaction.show(noticiasFragment);
        } else if (ifrg == 3) {
            transaction.show(detallesFragment);
        }

        transaction.commit();
    }
}

