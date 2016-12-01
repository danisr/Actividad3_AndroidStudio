package sanchez.daniel.libreria;

import com.quickblox.core.model.QBBaseCustomObject;
import com.quickblox.users.model.QBUser;
import java.util.ArrayList;

/**
 * Created by daniel.rodriguez on 29/11/2016.
 */
public interface QBAdminListener {
    public void registrado (boolean blRegistrado, QBUser User);
    public void logeado(boolean blLogeado, QBUser User); //Se llama al método
    public void datosDescargados(ArrayList<QBBaseCustomObject> datos);
}