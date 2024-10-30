package com.example.myapplication3;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class fragment1 extends Fragment {

    // Constantes para los nombres de los parámetros que se pasarán al fragmento
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // Variables para almacenar los parámetros que se pasan al fragmento
    private String mParam1;
    private String mParam2;

    public fragment1() {
    }

    // Método para crear una nueva instancia del fragmento
    public static fragment1 newInstance(String param1, String param2) {

        fragment1 fragment = new fragment1();
        Bundle args = new Bundle();
        // Guardamos los parámetros en el Bundle
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Si se han pasado argumentos, los recuperamos del Bundle
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment1, container, false);
    }
}
