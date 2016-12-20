package sanchez.daniel.examen1;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by daniel.rodriguez on 20/12/2016.
 */
public class NoticiasFragment extends Fragment {
    public MainActivity2 mainActivity2;
    public EditText txtNoticias;
    public EditText txtTitulo;
    public Button btnAnterior;
    public Button btnSiguiente;
    public Button btnAtras;
    public Button btnElegir;

    public NoticiasFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View v = inflater.inflate(R.layout.fragment_noticias, container, false);
        txtNoticias = (EditText) v.findViewById(R.id.txtNoticias); //Crear instancia, encuentra vista a partir de su id
        txtTitulo = (EditText) v.findViewById(R.id.txtTitulo1);
        btnAnterior = (Button) v.findViewById(R.id.btnAnterior);
        btnSiguiente = (Button) v.findViewById(R.id.btnSiguiente);
        btnAtras = (Button) v.findViewById(R.id.btnAtras);
        btnElegir = (Button) v.findViewById(R.id.btnElegir);

        mainActivity2 = (MainActivity2)getActivity(); //Para referenciar el mainActivity en esta clase

        return v;
    }

    public void setController(MainActivityController2 controller2){
        btnAnterior.setOnClickListener(controller2);
        btnSiguiente.setOnClickListener(controller2);
        btnAtras.setOnClickListener(controller2);
        btnElegir.setOnClickListener(controller2);
    }
}