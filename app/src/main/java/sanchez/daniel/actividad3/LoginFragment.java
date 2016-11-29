package sanchez.daniel.actividad3;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment implements View.OnClickListener, View.OnFocusChangeListener {
    public MainActivity mainActivity;
    public Button btnRegistro;

    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_login, container, false);
        btnRegistro = (Button) v.findViewById(R.id.btnRegistro); //Crear instancia, encuentra vista a partir de su id
        btnRegistro.setOnClickListener(this);
        mainActivity = (MainActivity)getActivity(); //Para referenciar el mainActivity en esta clase

        return v;
    }

    public void onClick(View bntPulsado) {
        if (bntPulsado.getId() == R.id.btnRegistro){
            mainActivity.cambiarFragment(3); //Se va a vista Registro
        }
    }

    @Override
    public void onFocusChange(View view, boolean b) {
    }
}
