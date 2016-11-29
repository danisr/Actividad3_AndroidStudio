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
public class RegistroFragment extends Fragment implements View.OnClickListener, View.OnFocusChangeListener {
    public MainActivity mainActivity;
    public Button btnIrLogin;

    public RegistroFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_registro, container, false);
        btnIrLogin = (Button) v.findViewById(R.id.btnIrLogin); //Crear instancia, encuentra vista a partir de su id
        btnIrLogin.setOnClickListener(this);
        mainActivity = (MainActivity)getActivity(); //Para referenciar el mainActivity en esta clase

        return v;
    }

    @Override
    public void onClick(View bntPulsado) {
        if (bntPulsado.getId() == R.id.btnIrLogin){
            mainActivity.cambiarFragment(2); // Se va a vista Login
        }
    }

    @Override
    public void onFocusChange(View view, boolean b) {
    }
}