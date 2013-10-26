package DAOs;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.tpbibliotecamovil.Entidades.Libro;

public class DAOlibros extends SQLiteOpenHelper{

	public DAOlibros(Context contexto, String nombre, CursorFactory factory, int version){
		super(contexto, nombre, factory, version);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE Libros (id INTEGER PRIMARY KEY AUTOINCREMENT,descripcion TEXT, idAutor INTEGER , idCateogria INTEGER)");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}
	public void insertarDatos(Libro unLibro)
	{
		 SQLiteDatabase baseDatos = getWritableDatabase();
		 baseDatos.execSQL("INSERT INTO Libros (descripcion,idAutor,idCateogria) VALUES ('"+ unLibro.getDescripcion() +"','"+unLibro.getIdAutor()+"','"+ unLibro.getIdCategoria()+"')");
		 baseDatos.close(); 
	}
	public Libro recuperarDatosLibros(String descripcion)
	{
		 SQLiteDatabase baseDatos = getWritableDatabase(); 
		 String sql = "SELECT * FROM Libros where descripcion = '"+descripcion+"'"; 
		 Cursor cursor = baseDatos.rawQuery(sql, null); 
		 Libro unLibro=new Libro(); 
		 while (cursor.moveToNext()) 
		 { 
			 unLibro.setId(cursor.getInt(0)); 
			 unLibro.setDescripcion(cursor.getString(1));
			 unLibro.setIdAutor(cursor.getInt(2));
			 unLibro.setIdCategoria(cursor.getInt(3)); 
		 }    
		 cursor.close();    
		 return unLibro;
	}

	public void borrarLibro(Libro unLibro) 
	{
		 SQLiteDatabase baseDatos = getWritableDatabase();
		 baseDatos.execSQL("DELETE FROM Libros where id = ' "+unLibro.getId() +"'");
		 baseDatos.close(); 	
	}

	public void actualizarLibro(Libro unLibro)
	{
		 SQLiteDatabase baseDatos = getWritableDatabase();
		 baseDatos.execSQL("UPDATE Libros set descripcion = '"+unLibro.getDescripcion()+"', idAutor = '"+unLibro.getIdAutor()+"', idCategoria = "+ unLibro.getIdCategoria()+"'" );
		 baseDatos.close(); 
	}
	
	
}
