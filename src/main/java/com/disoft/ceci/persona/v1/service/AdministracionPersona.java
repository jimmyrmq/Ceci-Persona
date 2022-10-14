package com.disoft.ceci.persona.v1.service;

import com.disoft.ceci.persona.common.resultdata.ResultOperation;
import com.disoft.ceci.persona.common.resultdata.Severidad;
import com.disoft.ceci.persona.v1.model.Persona;
import com.disoft.ceci.persona.v1.util.IPersonaAdministracion;
import com.disoft.ceci.persona.v1.util.db.ConexionDB;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
@Service
public class AdministracionPersona implements IPersonaAdministracion {
    private static Logger LOG = LoggerFactory.getLogger(AdministracionPersona.class);
    @Override
    public ResultOperation guardar(Persona persona) {
        ResultOperation resultOperation = new ResultOperation();

        ConexionDB cbd = ConexionDB.getInstance();
        Connection conn  = cbd.initConection();
        if(conn!=null) {

            try {
                Integer id = persona.getID();
                String query = "insert into persona (IDTipoDocumento, NumeroDocumento, NumeroFiscal, Nombre, Apellido, Sexo, FechaNacimiento, Direccion1, Direccion2, Telefono1, Telefono2, EdoCivil, Correo, URL, URIFoto) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ;";
                PreparedStatement pstmt = conn.prepareStatement(query, 1003, 1007);

                pstmt.setInt(1,id);
                pstmt.setInt(2,persona.getIdTipoDocumento());
                pstmt.setInt(3,persona.getNumeroDocumento());
                pstmt.setInt(4,persona.getNumeroFiscal());
                pstmt.setString(5,persona.getNombre());
                pstmt.setString(6,persona.getApellido());
                pstmt.setString(7,persona.getSexo());
                pstmt.setDate(8, Date.valueOf(persona.getFechaNacimiento()));
                pstmt.setString(9,persona.getDireccion1());
                pstmt.setString(10,persona.getDireccion2());
                pstmt.setString(11,persona.getTelefono1());
                pstmt.setString(12, persona.getTelefono2());
                pstmt.setString(13,persona.getEdoCivil());
                pstmt.setString(14,persona.getCorreo());
                pstmt.setString(15,persona.getUrl());
                pstmt.setString(16,persona.getUriFoto());

                conn.close();

            } catch (SQLException exc) {
                String msg = "Error ResultData get():" + exc;
                LOG.error(msg);
                resultOperation.setResult(Severidad.ERROR,msg);
            }
        }

        return resultOperation;
    }

    @Override
    public ResultOperation eliminar(Integer id) {

        ResultOperation resultOperation = new ResultOperation("Sin Operacion",Severidad.NONE);

        return resultOperation;
    }
}
