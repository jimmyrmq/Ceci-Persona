package com.disoft.ceci.persona.v1.service;

import com.disoft.ceci.persona.common.resultdata.ResultOperation;
import com.disoft.ceci.persona.common.resultdata.Severidad;
import com.disoft.ceci.persona.v1.model.Persona;
import com.disoft.ceci.persona.v1.util.IPersonaAdministracion;
import com.disoft.ceci.persona.v1.util.db.ConexionDB;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.File;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

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
                PreparedStatement pstmt;
                Integer id = persona.getID();
                boolean isNewPeople = id==null;

                String query = "insert into persona (IDTipoDocumento, NumeroDocumento, NumeroFiscal, Nombre1, Nombre2, Apellido1, Apellido2, Sexo, FechaNacimiento, Direccion1, Direccion2, Telefono1, Telefono2, EdoCivil, Correo, URL, URIFoto) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ;";

                if(isNewPeople){
                    pstmt = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
                }
                else {
                    query = "update persona set IDTipoDocumento=?, NumeroDocumento=?, NumeroFiscal=?, Nombre1=?, Nombre2=?, Apellido1=?, Apellido2=?, Sexo=?, FechaNacimiento=?, Direccion1=?, Direccion2=?, Telefono1=?, Telefono2=?, EdoCivil=?, Correo=?, URL=?, URIFoto=? where id = ?;";
                    pstmt = conn.prepareStatement(query, 1003, 1007);
                    pstmt.setInt(18,id);
                }
                //pstmt.setInt(1,id);
                pstmt.setInt(1,persona.getIdTipoDocumento());
                pstmt.setInt(2,persona.getNumeroDocumento());

                if(persona.getNumeroFiscal()!=null)
                    pstmt.setInt(3,persona.getNumeroFiscal());
                else
                    pstmt.setNull(3, Types.INTEGER);

                pstmt.setString(4,persona.getPrimerNombre());

                if(persona.getSegundoNombre()!=null)
                    pstmt.setString(5,persona.getSegundoNombre());
                else
                    pstmt.setNull(5, Types.VARCHAR);

                pstmt.setString(6,persona.getPrimerApellido());

                if(persona.getPrimerApellido()!=null)
                    pstmt.setString(7,persona.getSegundoApellido());
                else
                    pstmt.setNull(7, Types.VARCHAR);

                pstmt.setString(8,persona.getSexo());

                if(persona.getFechaNacimiento()!=null)
                    pstmt.setDate(9, Date.valueOf(persona.getFechaNacimiento()));
                else
                    pstmt.setNull(9, Types.DATE);

                if(persona.getDireccion1()!=null)
                    pstmt.setString(10,persona.getDireccion1());
                else
                    pstmt.setNull(10, Types.VARCHAR);

                if(persona.getDireccion2()!=null)
                    pstmt.setString(11,persona.getDireccion2());
                else
                    pstmt.setNull(11, Types.VARCHAR);

                if(persona.getTelefono1()!=null)
                    pstmt.setString(12,persona.getTelefono1());
                else
                    pstmt.setNull(12, Types.VARCHAR);

                if(persona.getTelefono2()!=null)
                    pstmt.setString(13, persona.getTelefono2());
                else
                    pstmt.setNull(13, Types.VARCHAR);

                if(persona.getEdoCivil()!=null)
                    pstmt.setString(14,persona.getEdoCivil());
                else
                    pstmt.setNull(14, Types.VARCHAR);

                if(persona.getCorreo()!=null)
                    pstmt.setString(15,persona.getCorreo());
                else
                    pstmt.setNull(15, Types.VARCHAR);

                if(persona.getCorreo()!=null)
                    pstmt.setString(16,persona.getUrl());
                else
                    pstmt.setNull(16, Types.VARCHAR);

                if(persona.getUriFoto()!=null)
                    pstmt.setString(17,persona.getUriFoto());
                else
                    pstmt.setNull(17, Types.VARCHAR);

                int val = pstmt.executeUpdate();

                boolean rtn = val >= 0;
                String msg;
                Severidad sev;
                if(rtn) {
                    if(isNewPeople){
                        ResultSet rs = pstmt.getGeneratedKeys();
                        if (rs.next()) {
                            id = rs.getInt(1);
                        }
                        msg = persona.getPrimerNombre() + "," + persona.getPrimerApellido() + ", ID:"+id+" fue guardado con exito.";
                    }else
                        msg = "Los datos de "+persona.getPrimerApellido() + "," + persona.getPrimerNombre() + " fue actualizado con exito.";
                    sev = Severidad.OK;
                }else{
                    msg = "No hubo guardado de cliente. ";
                    sev = Severidad.WARNING;
                }

                resultOperation.setResult(sev, msg);

                conn.close();

            } catch (SQLException exc) {
                String msg = "Error AdministracionPersona guardar(Persona):" + exc;
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
