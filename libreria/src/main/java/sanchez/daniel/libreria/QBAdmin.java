package sanchez.daniel.libreria;

import android.os.Bundle;
import com.quickblox.core.QBEntityCallback;
import com.quickblox.core.exception.QBResponseException;
import com.quickblox.users.QBUsers;
import com.quickblox.users.model.QBUser;

/**
 * Created by daniel.rodriguez on 22/11/2016.
 */
public class QBAdmin {
    QBAdminListener listener;

    public QBAdmin(QBAdminListener listener) {
        this.listener = listener;
    }

    public void login (String suser, String password) {
        QBUser user = new QBUser("suser", "password");

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