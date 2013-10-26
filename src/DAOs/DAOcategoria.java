package DAOs;

import java.util.ArrayList;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.tpbibliotecamovil.Entidades.Autor;
import com.example.tpbibliotecamovil.Entidades.Categoria;

public class DAOcategoria extends SQLiteOpenHelper{
	

	public DAOcategoria(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE Categorias (id INTEGER PRIMARY KEY AUTOINCREMENT, descripcion TEXT)");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}
	public void insertarDatos(Categoria categoria)
	{
		 SQLiteDatabase baseDatos = getWritableDatabase();
		 baseDatos.execSQL("INSERT INTO Categorias (descripcion) VALUES ('"+ categoria.getDescripcion()+"')");
		 baseDatos.close(); 
	}
	public ArrayList<Categoria> recuperarDatos()
	{
		 SQLiteDatabase baseDatos = getWritableDatabase(); 
		 String sql = "SELECT * FROM Categorias"; 
		 Cursor cursor = baseDatos.rawQuery(sql, null); 
		 ArrayList<Categoria>misCategorias=new ArrayList<Categoria>();  
		 while (cursor.moveToNext()) 
		 { 
			 Categoria oCategoria=new Categoria(); 
			 oCategoria.setId(cursor.getInt(0)); 
			 oCategoria.setDescripcion(cursor.getString(1));  
			 misCategorias.add(oCategoria);
		 }       
		 return misCategorias;
	}
	public void borrarCategoria(Categoria oCategoria) 
	{
		 SQLiteDatabase baseDatos = getWritableDatabase();
		 baseDatos.execSQL("DELETE FROM Categorias where id = ' "+ oCategoria.getId()+"'");
		 baseDatos.close(); 	
	}

	public void actualizarAutor(Autor unAutor)
	{
		 SQLiteDatabase baseDatos = getWritableDatabase();
		 baseDatos.execSQL("UPDATE Usuarios set nombre = '"+ unAutor.getNombre()+"'");
		 baseDatos.close(); 
	}
	

}
