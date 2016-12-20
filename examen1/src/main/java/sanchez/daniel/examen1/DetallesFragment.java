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
public class DetallesFragment extends Fragment {
    public MainActivity2 mainActivity2;
    public EditText txtDetalle;
    public EditText txtTituloDetalle;
    public EditText txtNoticia;
    public Button btnAtrasDetalles;

    public DetallesFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_detalles, container, false);
        txtDetalle = (EditText) v.findViewById(R.id.txtDetalle); //Crear instancia, encuentra vista a partir de su id
        txtTituloDetalle = (EditText) v.findViewById(R.id.txtTituloDetalle);
        txtNoticia = (EditText) v.findViewById(R.id.txtNoticia);
        btnAtrasDetalles = (Button) v.findViewById(R.id.btnAtrasDetalles);

        mainActivity2 = (MainActivity2)getActivity(); //Para referenciar el mainActivity en esta clase

        return v;
    }

    public void setController(MainActivityController2 controller2){
        btnAtrasDetalles.setOnClickListener(controller2);
    }
}
