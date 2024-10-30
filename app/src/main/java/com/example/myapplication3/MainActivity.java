package com.example.myapplication3;

import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    // Declaramos un FrameLayout donde se cargarán los fragmentos
    private FrameLayout fragmentContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Inicializamos el contenedor del fragmento
        fragmentContainer = findViewById(R.id.fragment_container);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Verificamos la orientación actual del dispositivo
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            // Si está en modo horizontal, cambiamos el layout a 'activity_main_landscape.xml'
            setContentView(R.layout.activity_main_landscape);
            // Y cargamos ambos fragmentos en el layout horizontal
            loadFragmentForHorizontal();
        } else {
            // Si está en modo vertical, buscamos los botones en el layout
            Button buttonOne = findViewById(R.id.button);
            // Configuramos un Listener para que al hacer clic en el botón cargue el Fragment1
            buttonOne.setOnClickListener(v -> loadFragment(new fragment1()));

            Button buttonTwo = findViewById(R.id.button_two);
            // Configuramos un Listener para que al hacer clic en el segundo botón cargue el Fragment2
            buttonTwo.setOnClickListener(v -> loadFragment(new Fragment2()));
        }
    }

    // Método para cargar un fragmento
    private void loadFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();
    }

    // Método para cargar fragmentos en horizontal
    private void loadFragmentForHorizontal() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.left_fragment_container, new fragment1());
        fragmentTransaction.replace(R.id.right_fragment_container, new Fragment2());

        fragmentTransaction.commit();
    }
}
