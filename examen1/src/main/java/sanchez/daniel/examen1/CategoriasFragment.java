package sanchez.daniel.examen1;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by daniel.rodriguez on 20/12/2016.
 */
public class CategoriasFragment extends Fragment {
    public MainActivity2 mainActivity2;
    public Button btnCat1;
    public Button btnCat2;
    public Button btnCat3;
    public Button btnCat4;
    public Button btnCat5;
    public Button btnCat6;

    public CategoriasFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_categorias, container, false);
        btnCat1 = (Button) v.findViewById(R.id.btnCat1); //Crear instancia, encuentra vista a partir de su id
        btnCat2 = (Button) v.findViewById(R.id.btnCat2);
        btnCat3 = (Button) v.findViewById(R.id.btnCat3);
        btnCat4 = (Button) v.findViewById(R.id.btnCat4);
        btnCat5 = (Button) v.findViewById(R.id.btnCat5);
        btnCat6 = (Button) v.findViewById(R.id.btnCat6);

        mainActivity2 = (MainActivity2)getActivity(); //Para referenciar el mainActivity en esta clase

        return v;
    }

    public void setController(MainActivityController2 controller2){
        btnCat1.setOnClickListener(controller2);
        btnCat2.setOnClickListener(controller2);
        btnCat3.setOnClickListener(controller2);
        btnCat4.setOnClickListener(controller2);
        btnCat5.setOnClickListener(controller2);
        btnCat6.setOnClickListener(controller2);
    }
}