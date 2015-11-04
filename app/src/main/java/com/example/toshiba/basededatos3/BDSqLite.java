package com.example.toshiba.basededatos3;
import static android.provider.BaseColumns._ID;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.toshiba.basededatos3.modelo.clases.java.Producto;
import com.example.toshiba.basededatos3.modelo.clases.java.Productos;


public class BDSqLite extends SQLiteOpenHelper {
    private static int version = 1;
    private static String nombre = "MiBaseDatos";
    private static SQLiteDatabase.CursorFactory factory = null;

    public BDSqLite(Context context) {
        super(context, nombre, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE Materias (" + _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + "Nombre TEXT NOT NULL, " +
                "Costo INTEGER NOT NULL, Descripcion TEXT NOT NULL, Tarea INTEGER NOT NULL," +
                " Proyecto INTEGER NOT NULL, Examen INTEGER NOT NULL, Asistencia INTEGER NOT NULL);";

        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void InsertarMaterias(String Nombre, int Costo, String Descripcion, int Tarea, int Proyecto, int Examen, int Asistencia) {
        SQLiteDatabase db = getWritableDatabase();

        if (db != null) {

            ContentValues valores = new ContentValues();
            valores.put("Nombre", Nombre);
            valores.put("Costo", Costo);
            valores.put("Descripcion", Descripcion);
            valores.put("Tarea", Tarea);
            valores.put("Proyecto", Proyecto);
            valores.put("Examen", Examen);
            valores.put("Asistencia", Asistencia);

            db.insert("Materias", null, valores);
            db.close();


        }

    }

    public void ModificarMaterias(int id, String Nombre, int Costo, String Descripcion, int Tarea, int Proyecto, int Examen, int Asistencia) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put("Nombre", Nombre);
        valores.put("Costo", Costo);
        valores.put("Descripcion",Descripcion );
        valores.put("Tarea", Tarea);
        valores.put("Proyecto", Proyecto);
        valores.put("Examen", Examen);
        valores.put("Asistencia", Asistencia);
        db.update("Materias", valores, "_ID=" + id, null);
        db.close();
    }

    public void EliminarMaterias(int id) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete("Materias", "_ID=" + id, null);
        db.close();
    }

    public Productos[] ConsultarMaterias() {
        SQLiteDatabase db = getReadableDatabase();
        String sql = "SELECT * FROM Materias";
        Productos[] listaProductos = null;

        Cursor c = db.rawQuery(sql, null);

        listaProductos = new Productos[c.getCount()];
        int i = 0;

        if (c.moveToFirst()) {

            do {
                Productos oProductos = new Productos();
                oProductos.setId(c.getInt(0));
                oProductos.setNombre(c.getString(1));
                oProductos.setCosto(c.getInt(2));
                oProductos.setDescripcion(c.getString(3));
                oProductos.setTarea(c.getInt(4));
                oProductos.setProyecto(c.getInt(5));
                oProductos.setExamen(c.getInt(6));
                oProductos.setAsistencia(c.getInt(7));

                listaProductos[i] = oProductos;
                i++;


            } while (c.moveToNext());

        }
        c.close();
        db.close();

        return listaProductos;


    }


    public  void InsertarAlumnos(String Nombre, String ApellidoP, String ApellidoM, String Correo){

        SQLiteDatabase db=getWritableDatabase();

        if(db!=null){
            ContentValues valores=new ContentValues();

            valores.put("Nombre", Nombre);
            valores.put("ApellidoM", ApellidoP);
            valores.put("ApellidoP", ApellidoM);
            valores.put("Correo",Correo);

            db.insert("Alumnos", null, valores);

            db.close();

        }

    }


    public void ModificarAlumnos(int id,String Nombre, String ApellidoP, String ApellidoM, String Correo){

        SQLiteDatabase db=getWritableDatabase();

        ContentValues valores=new ContentValues();
        valores.put("Nombre", Nombre);
        valores.put("ApellidoM", ApellidoP);
        valores.put("ApellidoP", ApellidoM);
        valores.put("Correo",Correo);


        db.update("Alumnos",valores, "_ID="+id, null);
        db.close();
    }


    public void EliminarAlumnos(int id){
        SQLiteDatabase db=getWritableDatabase();
        db.delete("Alumnos", "_ID="+id, null);
        db.close();
    }


    public Producto[] ConsultarAlumnos(){
        SQLiteDatabase db=getReadableDatabase();
        String sql="SELECT * FROM Alumnos";
        Producto[] listaProductos=null;

        Cursor c=db.rawQuery(sql, null);

        listaProductos=new Producto[c.getCount()];
        int i=0;

        if(c.moveToFirst()){

            do{
                Producto oProductos=new Producto();
                oProductos.setId(c.getInt(0));
                oProductos.setNombre(c.getString(1));
                oProductos.setApellidoP(c.getString(2));
                oProductos.setApellidoM(c.getString(3));
                oProductos.setCorreo(c.getString(4));

                listaProductos[i]=oProductos;
                i++;


            }while(c.moveToNext());

        }
        c.close();
        db.close();

        return listaProductos;


    }


}




