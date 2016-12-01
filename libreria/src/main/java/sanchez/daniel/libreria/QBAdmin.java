package sanchez.daniel.libreria;

import android.app.Activity;
import android.os.Bundle;
import com.quickblox.core.QBEntityCallback;
import com.quickblox.core.QBSettings;
import com.quickblox.core.exception.QBResponseException;
import com.quickblox.users.QBUsers;
import com.quickblox.users.model.QBUser;

/**
 * Created by daniel.rodriguez on 22/11/2016.
 */
public class QBAdmin {
    QBAdminListener listener;

    public QBAdmin(QBAdminListener listener, Activity activity) {
        this.listener = listener;

        //Conexion con Quickblox
        String APP_ID = "50447";
        String AUTH_KEY = "45yEfcY9ShBwDhR";
        String AUTH_SECRET = "dAZTza9qBVsk5mD";
        String ACCOUNT_KEY = "49742";

        QBSettings.getInstance().init(activity, APP_ID, AUTH_KEY, AUTH_SECRET);
        QBSettings.getInstance().setAccountKey(ACCOUNT_KEY);
    }

    // LOGIN DE USUARIO
    public void login (String usuario, String password) {
        QBUser user = new QBUser("usuario", "password");

        QBUsers.signIn(user, new QBEntityCallback<QBUser>() {
            @Override
            public void onSuccess(QBUser user, Bundle params) {
                listener.logeado(true, user);
            }

            @Override
            public void onError(QBResponseException errors) {
                listener.logeado(false, null);
            }
        });
    }

    public void selectDeTabla() {

    }
}