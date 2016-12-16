package sanchez.daniel.libreria;

import com.quickblox.users.model.QBUser;
import java.util.HashMap;

/**
 * Created by daniel.rodriguez on 29/11/2016.
 */
public interface QBAdminListener { //Interface, sirve de plantilla para modificaciones futuras. Métodos implementados en QBAdmin
    public void registrado (boolean blRegistrado, QBUser User); //Se llama al método
    public void logeado(boolean blLogeado, QBUser User);
    public void idiomasDescargados(HashMap<Integer,String> idiomasDesc);
}