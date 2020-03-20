package cuarentena;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Conector {
	/** 
	 * Atributos de clase 
	 */
	private static Connection con;
	private static Conector INSTANCE = null;
	
	/**
	 * Constructor
	 */
	private Conector(){ 
		
	}
	
	/**
	 * Crear instancia 
	 */
	
	private synchronized static void crearInstancia() {
		if(INSTANCE == null) {
			INSTANCE = new Conector();
			crearConexion();
		}
	}
	
	/**
	 * Obtener instancia
	 */
	
	public static Conector getInstancia() {
		if (INSTANCE == null ) {
			crearInstancia(); 
		}
		return INSTANCE;	
	}

	/** 
	 * Crear Conexion 
	 */
	private static void crearConexion() {
		String host = "127.0.0.1";
		String user = "JP";
		String password = "Password123";//Poner su password
		String dataBase = "cuarentena";
		try {
			// Importando la libreria de conexion de mysql
			Class.forName("com.mysql.jdbc.Driver");
			// Url de conexion
			String urlConexion = "jdbc:mysql://"+host+"/"+dataBase+"?user="+user+"&password="+password;
			con = DriverManager.getConnection(urlConexion);
			System.out.println("Lo lograste :') ");
			
		}catch (Exception e) {
			System.out.println("Error al conectar a la base de datos");
		}
	}
	
	public ArrayList<String> getPaciente() throws SQLException{
		ArrayList<String> listaPacientes=new ArrayList<String>();
		PreparedStatement ps =con.prepareStatement(
				"select persona.nombres from persona inner join paciente on paciente.personaID = persona.CI ;");
		ResultSet rs= ps.executeQuery();
		while(rs.next()){
			listaPacientes.add(rs.getString("nombres"));
		}
		rs.close();
		return listaPacientes;
	}
	
	public ArrayList<String> getPacientes() throws SQLException {
		ArrayList<String> listaPacientes = new ArrayList<String>();
		PreparedStatement ps = (PreparedStatement) 
				con.prepareStatement("select nombre from paciente inner "+
						"join persona on paciente.personaID=persona.CI;");
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			listaPacientes.add(rs.getString("nombre"));
		}
		rs.close();
		return listaPacientes;
	}
	
	
	public ArrayList<String> getConsultorioDoctores() throws SQLException {
		ArrayList<String> listaDoctores = new ArrayList<String>();
		PreparedStatement ps = (PreparedStatement) 
				con.prepareStatement("select nombre,numero from doctor " + 
						"inner join persona on doctor.personaID = persona.CI " + 
						"inner join consultorio on doctor.cosultorioID = consultorio.ID;");
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			listaDoctores.add(rs.getString("numero"));
			listaDoctores.add(rs.getString("nombre"));
		}
		rs.close();
		return listaDoctores;
	}
	
	

	 // 4) Mostrar el consultorio y nombre de los doctores
	 
}