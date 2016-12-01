package sanchez.daniel.actividad3;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegistroFragment extends Fragment {
    public MainActivity mainActivity;
    public Button btnIrLogin;
    public Button btnRegistrarse;
    public EditText txtUsuarioR;
    public EditText txtEmailR;
    public EditText txtPasswordR;
    public EditText txtPassword2R;

    public RegistroFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_registro, container, false);
        btnIrLogin = (Button) v.findViewById(R.id.btnIrLogin); //Crear instancia, encuentra vista a partir de su id
        btnRegistrarse = (Button) v.findViewById(R.id.btnRegistrarse);

        mainActivity = (MainActivity)getActivity(); //Para referenciar el mainActivity en esta clase
        txtUsuarioR=(EditText)v.findViewById(R.id.txtUsuarioR);
        txtEmailR=(EditText)v.findViewById(R.id.txtEmailR);
        txtPasswordR=(EditText)v.findViewById(R.id.txtPasswordR);
        txtPassword2R=(EditText)v.findViewById(R.id.txtPassword2R);

        return v;
    }

    public void setController(MainActivityController controller){
        btnIrLogin.setOnClickListener(controller);
        btnRegistrarse.setOnClickListener(controller);
    }
}