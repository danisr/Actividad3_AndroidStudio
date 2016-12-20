package sanchez.daniel.examen1;

import android.view.View;
import android.widget.EditText;

import com.quickblox.users.model.QBUser;

import java.util.HashMap;

import sanchez.daniel.libreria.QBAdmin;
import sanchez.daniel.libreria.QBAdminListener;

/**
 * Created by daniel.rodriguez on 20/12/2016.
 */

public class MainActivityController2 implements View.OnClickListener, QBAdminListener {
    MainActivity2 vista2;
    QBAdmin qbAdmin;
    String [] titulos;
    String [] textos;
    int i = 0;

    public MainActivityController2(MainActivity2 vista2) {
        this.vista2 = vista2;
        qbAdmin = new QBAdmin(this, vista2);

        titulos = new String[] {
                vista2.getResources().getString(R.string.titulo1),
                vista2.getResources().getString(R.string.titulo2),
                vista2.getResources().getString(R.string.titulo3),
                vista2.getResources().getString(R.string.titulo4)
        };

        textos = new String[] {
                vista2.getResources().getString(R.string.texto1)
        };
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnCat1){ //Se va NoticiasFragment
            vista2.cambiarFragment(2);
            vista2.noticiasFragment.txtTitulo.setText(titulos[i]);
        } if (view.getId() == vista2.noticiasFragment.btnSiguiente.getId()) { // botón Siguiente
            i++;
            if (i == titulos.length) {
                i = 0;
            }
            vista2.noticiasFragment.txtTitulo.setText(titulos[i]);
        } else if (view.getId() == vista2.noticiasFragment.btnAnterior.getId()) { // botón Anterior
            i--;
            if (i == -1) {
                i = titulos.length - 1;
            }
            vista2.noticiasFragment.txtTitulo.setText(titulos[i]);
        } else if (view.getId() == vista2.noticiasFragment.btnAtras.getId()) { // botón Atras
            vista2.cambiarFragment(1); //Se vuelve a CategoriasFragment
        } else if (view.getId() == vista2.noticiasFragment.btnElegir.getId()) { // botón Elegir
            vista2.cambiarFragment(3); //Se pasa a DetallesFragment
            vista2.detallesFragment.txtTituloDetalle.setText(titulos[i]);
            vista2.detallesFragment.txtNoticia.setText(textos[i]);
        } else if (view.getId() == vista2.detallesFragment.btnAtrasDetalles.getId()) { // botón Atras
            vista2.cambiarFragment(2); //Se vuelve a CategoriasFragment
        }
    }


    @Override
    public void registrado(boolean blRegistrado, QBUser User) {
    }
    @Override
    public void logeado(boolean blLogeado, QBUser User) {
    }
    @Override
    public void idiomasDescargados(HashMap<Integer, String> idiomasDesc) {
    }
}