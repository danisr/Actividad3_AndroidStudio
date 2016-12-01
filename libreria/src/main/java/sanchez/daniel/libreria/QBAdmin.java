package sanchez.daniel.libreria;

import android.app.Activity;
import android.os.Bundle;

import com.quickblox.auth.QBAuth;
import com.quickblox.auth.model.QBSession;
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
        String ACCOUNT_KEY = "KkCSxKFcudnVhujyT5fu";

        QBSettings.getInstance().init(activity, APP_ID, AUTH_KEY, AUTH_SECRET);
        QBSettings.getInstance().setAccountKey(ACCOUNT_KEY);

        // Para conectarse con quickblox
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
                listener.registrado(true, user);
            }

            @Override
            public void onError(QBResponseException error) {
                listener.registrado(false, null);
            }
        });
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