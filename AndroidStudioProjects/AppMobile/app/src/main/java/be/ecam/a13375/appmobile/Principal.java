package be.ecam.a13375.appmobile;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Principal extends AppCompatActivity {

    private TextView mDisplay ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.connexion);
       // mDisplay = ( TextView ) findViewById (R.id.editText );

        //Intent intent = getIntent();

    }
    @Override
    public void onClick(int index) {
        Context context = this;
        Class destinationClass = CalculActivity.class;
        Intent intent = new Intent(context, destinationClass);
        intent.putExtra(Intent.EXTRA_INDEX, index);
        startActivity(intent);
    }
}
