package sanchez.daniel.libreria;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import com.quickblox.auth.QBAuth;
import com.quickblox.auth.model.QBSession;
import com.quickblox.core.QBEntityCallback;
import com.quickblox.core.QBSettings;
import com.quickblox.core.exception.QBResponseException;
import com.quickblox.core.request.QBRequestGetBuilder;
import com.quickblox.customobjects.QBCustomObjects;
import com.quickblox.customobjects.model.QBCustomObject;
import com.quickblox.users.QBUsers;
import com.quickblox.users.model.QBUser;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by daniel.rodriguez on 22/11/2016.
 */
public class QBAdmin {
    QBAdminListener listener;
    public String APP_ID;
    public String AUTH_KEY;
    public String AUTH_SECRET;
    public String ACCOUNT_KEY;

    public QBAdmin(QBAdminListener listener, Activity activity) {
        this.listener = listener;

        //Conexion con Quickblox
        APP_ID = "50447";
        AUTH_KEY = "45yEfcY9ShBwDhR";
        AUTH_SECRET = "dAZTza9qBVsk5mD";
        ACCOUNT_KEY = "KkCSxKFcudnVhujyT5fu";

        QBSettings.getInstance().init(activity, APP_ID, AUTH_KEY, AUTH_SECRET);
        QBSettings.getInstance().setAccountKey(ACCOUNT_KEY);

        //Para conectarse con quickblox
        QBAuth.createSession(new QBEntityCallback<QBSession>() {
            @Override
            public void onSuccess(QBSession session, Bundle params) {
                // You have successfully created the session
                // Now you can use QuickBlox API!
            }
            @Override
            public void onError(QBResponseException errors) {
            }
        });
    }

    // REGISTRO DE USUARIO
    public void registro (String usuario, String email, String password) {
        QBUser user = new QBUser(usuario, password);
        user.setEmail(email);

        QBUsers.signUp(user, new QBEntityCallback<QBUser>() {
            @Override
            public void onSuccess(QBUser user, Bundle args) {
                //registrado
                listener.registrado(true, user);
            }

            @Override
            public void onError(QBResponseException error) {
                //no registrado
                listener.registrado(false, null);
            }
        });
    }

    // LOGIN DE USUARIO
    public void login (String usuario, String password) {
        QBUser user = new QBUser(usuario, password);

        QBUsers.signIn(user, new QBEntityCallback<QBUser>() {
            @Override
            public void onSuccess(QBUser user, Bundle params) {
                //logeado
                listener.logeado(true, user);
            }

            @Override
            public void onError(QBResponseException errors) {
                //no logeado
                listener.logeado(false, null);
            }
        });
    }

    //DESCARGAR DATOS DE TABLA IDIOMAS DE QUICKBLOX
    public void descargarDatosQuickblox(String idioma) {
        QBRequestGetBuilder requestBuilder = new QBRequestGetBuilder();

        requestBuilder.eq("idioma", idioma); //1ºparam: 'en' o 'es' de quickblox. 2ºparam: lo que viene por parámetro

        QBCustomObjects.getObjects("idiomas", requestBuilder, new QBEntityCallback<ArrayList<QBCustomObject>>() {
            @Override
            public void onSuccess(ArrayList<QBCustomObject> qbCustomObjects, Bundle bundle) {
                HashMap<Integer,String> hmPalabras=new HashMap<Integer, String>();

                for (int i = 0; i < qbCustomObjects.size(); i++) {
                    Log.v("QBAdmin", "Fila" + i + qbCustomObjects.get(i).getFields());

                    int iPal = (int) qbCustomObjects.get(i).getFields().get("idp");
                    String sValor = qbCustomObjects.get(i).getFields().get("valor").toString();
                    hmPalabras.put(iPal, sValor);
                }
                listener.idiomasDescargados(hmPalabras);
            }

            @Override
            public void onError(QBResponseException e) {
            }
        });
    }
}