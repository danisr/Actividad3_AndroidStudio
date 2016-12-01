package sanchez.daniel.actividad3;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.quickblox.core.model.QBBaseCustomObject;
import com.quickblox.users.model.QBUser;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import sanchez.daniel.libreria.QBAdminListener;

/**
 * A simple {@link Fragment} subclass.
 */
public class CreditosFragment extends Fragment implements QBAdminListener {
    TimerTask timerTask; //Sirve para pasar de imagen a imagen (habrán 3 imágenes)
    Timer timer; //Sirve para que funcionen todos los timerTask que hayan
    public ImageView img1;
    public ImageView img2;
    public ImageView img3;
    public MainActivity mainActivity;

    public CreditosFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_creditos, container, false);
        img1 = (ImageView) v.findViewById(R.id.img1);
        img2 = (ImageView) v.findViewById(R.id.img2);
        img3 = (ImageView) v.findViewById(R.id.img3);
        mainActivity = (MainActivity)getActivity(); //Para referenciar el mainActivity en esta clase

        timerTask = new TimerTask() {
            public void run() {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Log.v("CreditosFragment","ENTRE!!! ");
                        if (img1.getVisibility() == View.VISIBLE ) {
                            img1.setVisibility(View.INVISIBLE);
                            img2.setVisibility(View.VISIBLE);
                        } else if (img2.getVisibility() == View.VISIBLE) {
                            img2.setVisibility(View.INVISIBLE);
                            img3.setVisibility(View.VISIBLE);
                        } /*else if (img3.getVisibility() == View.VISIBLE) {
                            Se saca la implementación de este if() fuera del hilo principal (de vistas)
                        }*/
                    }
                });

                if (img3.getVisibility() == View.VISIBLE) {
                    timer.cancel(); //Termina el tiempo
                    mainActivity.cambiarFragment(2); //Se cambia a la vista de login
                }
            }
        };

        timer = new Timer();
        timer.schedule(timerTask, 5000, 5000); //(5000) Cuanto tiempo tarda la app en ejecutar la tarea. (10000) Cada cuánto tiempo está realizando la tarea

        return v;
    }

    @Override
    public void logeado(boolean blLogeado, QBUser user) {

    }

    @Override
    public void datosDescargados(ArrayList<QBBaseCustomObject> datos) {

    }
}