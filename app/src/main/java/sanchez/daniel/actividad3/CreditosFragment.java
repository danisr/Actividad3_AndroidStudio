package sanchez.daniel.actividad3;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.Timer;
import java.util.TimerTask;

/**
 * A simple {@link Fragment} subclass.
 */
public class CreditosFragment extends Fragment {
    TimerTask timerTask; //Sirve para pasar de imagen a imagen (habrán 3 imágenes)
    Timer timer;

    public CreditosFragment() {
        // Required empty public constructor

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_creditos, container, false);
        v.findViewById(R.id.img1);

        timerTask = new TimerTask() {
            public void run() {
                Log.v("TimerTask", "HEY!!!");
                //Cuando llegue la última imagen
                timer.cancel();
            }
        };

        timer = new Timer();
        timer.schedule(timerTask, 5000, 10000); //Timer va ejecutando la tarea repetidamente

        return v;
    }
}
