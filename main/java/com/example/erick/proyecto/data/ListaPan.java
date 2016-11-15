package com.example.erick.proyecto.data;

import android.provider.BaseColumns;

/**
 * Created by erick on 15/11/16.
 */

public class ListaPan {
    public static abstract class PanEntry implements BaseColumns{
        public static final String TABLE_NAME = "pan";

        public static final String ID = "id";
        public static final String NAME = "nombre";
        public static final String DESCR = "descripcion";
        public static final String PRECIO = "precio";
    }
}
