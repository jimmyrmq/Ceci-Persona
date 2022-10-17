package com.disoft.ceci.persona;

import com.disoft.ceci.persona.v1.util.BuscarDatosPersonaArchivo;
import com.disoft.ceci.persona.v1.util.db.ConexionDB;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PersonaApplicationTests {

	@Test
	void probarConexion() {
		ConexionDB conn = ConexionDB.getInstance();
		Assertions.assertEquals(true,conn.initConection()!=null);
	}

	@Test
	void buscarDatosFile(){
		BuscarDatosPersonaArchivo bda= new BuscarDatosPersonaArchivo();
		System.out.println(bda.getPersona(17310861));
	}
}
