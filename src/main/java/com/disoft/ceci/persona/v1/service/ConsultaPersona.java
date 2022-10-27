package com.disoft.ceci.persona.v1.service;

import com.disoft.ceci.persona.v1.model.Persona;
import com.disoft.ceci.persona.v1.util.BuscarDatosPersonaArchivo;
import com.disoft.ceci.persona.v1.util.IPersonaConsulta;
import com.disoft.ceci.persona.v1.util.db.ConexionDB;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
//import java.util.Date;


@Service
public class ConsultaPersona implements IPersonaConsulta {

    private Connection conn;
    private static Logger LOG = LoggerFactory.getLogger(ConsultaPersona.class);

    @Override
    public Persona obtener(Integer nroDoc) {
        Persona persona = null;

        ConexionDB cbd = ConexionDB.getInstance();
        Connection conn  = cbd.initConection();
        if(conn!=null) {
            try {
                PreparedStatement pstmt = conn.prepareStatement("select ID, IDTipoDocumento, NumeroDocumento, NumeroFiscal, Nombre1, Nombre2, Apellido1, Apellido2, Sexo, FechaNacimiento, Direccion1, Direccion2, Telefono1, Telefono2, EdoCivil, Correo, URL, URIFoto from persona where NumeroDocumento=?;", 1003, 1007);
                try {
                    pstmt.setInt(1, nroDoc);
                    ResultSet rs = pstmt.executeQuery();

                    if (rs.next()) {
                        persona = new Persona();
                        persona.setID(rs.getInt(1));
                        persona.setIdTipoDocumento(rs.getInt(2));
                        persona.setNumeroDocumento(rs.getInt(3));
                        persona.setNumeroFiscal(rs.getInt(4));
                        persona.setPrimerNombre(rs.getString(5));
                        persona.setSegundoNombre(rs.getString(6));
                        persona.setPrimerApellido(rs.getString(7));
                        persona.setSegundoApellido(rs.getString(8));
                        persona.setSexo(rs.getString(9));
                        persona.setDataOrigin("DB");

                        Date input = rs.getDate(10);
                        if (input != null) {
                            //LocalDate date = input.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                            persona.setFechaNacimiento(input.toLocalDate());
                        }

                        persona.setDireccion1(rs.getString(11));
                        persona.setDireccion2(rs.getString(12));
                        persona.setTelefono1(rs.getString(13));
                        persona.setTelefono2(rs.getString(14));
                        persona.setEdoCivil(rs.getString(15));
                        persona.setCorreo(rs.getString(16));
                        persona.setUrl(rs.getString(17));
                        persona.setUriFoto(rs.getString(18));
                    }else {
                        BuscarDatosPersonaArchivo bdpa = new BuscarDatosPersonaArchivo();
                        persona = bdpa.getPersona(nroDoc);
                    }

                    conn.close();

                } catch (SQLException exc) {
                    String msg = "Error ResultData get():" + exc;
                    LOG.error(msg);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        return persona;
    }

    @Override
    public List<Persona> listar() {
        return null;
    }
}
