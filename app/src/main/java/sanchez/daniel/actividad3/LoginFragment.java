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
public class LoginFragment extends Fragment {
    public MainActivity mainActivity;
    public Button btnIrRegistro;
    public Button btnEntrar;
    public EditText txtUsuario;
    public EditText txtPassword;

    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_login, container, false);
        btnIrRegistro = (Button) v.findViewById(R.id.btnIrRegistro); //Crear instancia, encuentra vista a partir de su id
        btnEntrar = (Button) v.findViewById(R.id.btnEntrar);

        mainActivity = (MainActivity)getActivity(); //Para referenciar el mainActivity en esta clase
        txtUsuario=(EditText)v.findViewById(R.id.txtUsuario);
        txtPassword=(EditText)v.findViewById(R.id.txtPassword);

        return v;
    }

    public void setController(MainActivityController controller){
        btnIrRegistro.setOnClickListener(controller);
        btnEntrar.setOnClickListener(controller);
    }
}