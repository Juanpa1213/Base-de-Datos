package cuarentena;
import java.sql.SQLException;
import java.util.ArrayList;
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Conector instancia = Conector.getInstancia();
		
		//Mostrar Nombre de Paciente
		try {
			ArrayList <String> listNombres = instancia.getPacientes();
			System.out.println("\n-----------------------");
			System.out.println("-Nombre Paciente-");
			for(String nombres :listNombres)
				System.out.println(nombres);
			System.out.println("-----------------------");
		}catch (SQLException e){
			e.printStackTrace();
		}
		//Mostrar Nombres y Consultorios de los medicos
		
		try {
			ArrayList <String> listaConsultorioNombres = instancia.getConsultorioDoctores();
			System.out.println("\n-------------------------------");
			System.out.println("\nConsultorio |  Nombres");
			int i = 0 ;
			 for (  ; i<listaConsultorioNombres.size()-1 ; i= i+2 ) {
				 
				 System.out.print(listaConsultorioNombres.get(i)+"           " +listaConsultorioNombres.get(i+1));
				 System.out.println();
				 
				 
			 }
			 
			System.out.println("\n------------------------------");
		}catch (SQLException e){
			e.printStackTrace();
		}
		
		
	}

}
