package be.ecam.a13375.mycapcalculator;

//import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainCapActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_cap);

        TextView jv = (TextView) findViewById(R.id.JetonsVerts);
        TextView jn = (TextView) findViewById(R.id.JetonsNoirs);
        TextView jr = (TextView) findViewById(R.id.JetonsRouges);
        TextView tk = (TextView) findViewById(R.id.Tickets);


        jv.setText("Valeur des jetons verts:");
        jn.setText("Valeur des jetons noirs:");
        jr.setText("Valeur des jetons rouges:");
        tk.setText("Valeur des tickets spéciaux:");
    }


    }
}
