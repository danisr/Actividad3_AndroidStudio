package sanchez.daniel.actividad3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by daniel.rodriguez on 01/12/2016.
 */
public class MainActivity2 extends AppCompatActivity {
    public Button btnSpanish;
    public Button btnEnglish;
    public EditText idp1;
    public EditText idp2;
    MainActivityController2 mainActivityController2; //Comunicarse con el controller

    @Override
    protected void onCreate(Bundle savedInstanceState) { //Main
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2); //Se conectan controlador con vista
        mainActivityController2 = new MainActivityController2(this);

        btnSpanish = (Button) this.findViewById(R.id.btnSpanish); //Crear instancia, encuentra vista a partir de su id
        btnSpanish.setOnClickListener(mainActivityController2);
        btnEnglish = (Button) this.findViewById(R.id.btnEnglish);
        btnEnglish.setOnClickListener(mainActivityController2);

        idp1=(EditText)this.findViewById(R.id.idp1);
        idp2=(EditText)this.findViewById(R.id.idp2);
    }
}

