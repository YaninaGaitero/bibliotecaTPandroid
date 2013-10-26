package DAOs;

import java.util.ArrayList;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.tpbibliotecamovil.Entidades.Autor;

public class DAOautor extends SQLiteOpenHelper{

	public DAOautor(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE autores (nombre TEXT , id INTEGER PRIMARY KEY AUTOINCREMENT)");
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}
	public void insertarDatos(Autor oAutor)
	{
		 SQLiteDatabase baseDatos = getWritableDatabase();
		 baseDatos.execSQL("INSERT INTO autores (nombre) VALUES ('"+oAutor.getNombre()+"')");
		 baseDatos.close(); 
	}
	public ArrayList<Autor> recuperarDatos()
	{
		 SQLiteDatabase baseDatos = getWritableDatabase(); 
		 String sql = "SELECT * FROM autores"; 
		 Cursor cursor = baseDatos.rawQuery(sql, null); 
		 ArrayList<Autor >autores=new ArrayList<Autor>();  
		 while (cursor.moveToNext()) 
		 { 
			 Autor unAutor=new Autor(); 
			 unAutor.setId(cursor.getInt(0)); 
			 unAutor.setNombre(cursor.getString(1)); 
		     autores.add(unAutor);            
		 }       
		 return autores;
	}
	public void borrarAutor(Autor unAutor) 
	{
		 SQLiteDatabase baseDatos = getWritableDatabase();
		 baseDatos.execSQL("DELETE FROM Usuarios where nombre = ' "+ unAutor.getNombre()+"'");
		 baseDatos.close(); 	
	}

	public void actualizarAutor(Autor unAutor)
	{
		 SQLiteDatabase baseDatos = getWritableDatabase();
		 baseDatos.execSQL("UPDATE Usuarios set nombre = '"+ unAutor.getNombre()+"'");
		 baseDatos.close(); 
	}
	
}
	