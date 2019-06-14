/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conection.Conexion;
import interfaz.ICategoria;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import transferObject.Categoria;

/**
 *
 * @author USUARIOWIN10
 */
public class CategoriaDao implements ICategoria {

    @Override
    public ArrayList<Categoria> listarCategorias() {
        ArrayList<Categoria> listaCate = new ArrayList<>();//Almacenar los valores a la db

        Conexion db = new Conexion();
        Connection cn = db.getConnection();
        String procedimientoalmacenado = "{CALL sp_listarcategorias}";
        if (cn != null) {
            try {
                CallableStatement cs = cn.prepareCall(procedimientoalmacenado);
                ResultSet rs = cs.executeQuery();
                while (rs.next()) {
                    Categoria cate = new Categoria();

                    cate.setIdCategoria(rs.getInt("idCategoria"));
                    cate.setDescripcion(rs.getString("descripcion"));
                    cate.setEstado(rs.getString("estado").charAt(0));
                    listaCate.add(cate);
            
    }

            } catch (SQLException e) {
                System.out.println("error" + e);

            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                    System.out.println("error" + e);

                }
            }
        }

        //proceso
        return listaCate;
    }
    @Override
    public boolean insertarCategoria(Categoria cate) {
        boolean insert = false;
        int res;
        Conexion conn = new Conexion(); //conectandonos
        Connection cn = conn.getConnection();

        if (cn != null) {
            try {
                //Setear los parametros del procedimiento
                CallableStatement cs = cn.prepareCall("CALL sp_insertarcategoria(?,?,?)");
                cs.setInt(1, cate.getIdCategoria());
                cs.setString(2, cate.getDescripcion());
                cs.setString(3, String.valueOf(cate.getEstado()));
                res = cs.executeUpdate();
                if (res == 1) {
                    insert = true;
                }
            } catch (SQLException ex) {
                //Agregar codigo deseado
                
            } finally {
                try {
                    cn.close();
                } catch (SQLException ex) {
                    //Agregar codigo deseado
                }
            }
        }
        //proceso
        return insert;
    }

    @Override
    public boolean actualizarCategoria(Categoria cate) {
        int res;
        boolean update = false;
        Conexion conn = new Conexion();
        Connection cn = conn.getConnection();
        //proceso
        //preguntar si se ha llegado a conectar
        if (cn != null) {

        
        try {
            //se ha conectado exitosamente
            CallableStatement cs = cn.prepareCall("CALL sp_actualizarcategoria(?,?,?)");
            cs.setString(1, cate.getDescripcion());
            cs.setString(2, String.valueOf(cate.getEstado()));
            cs.setInt(3, cate.getIdCategoria());
            res = cs.executeUpdate();
            //Preguntamos si se actualizado correctamente
            if (res == 1) {
                update = true;
            }
        } catch (SQLException ex) {
            
        }
        }
        return update;
    }

    @Override
    public boolean eliminarCategoria(int idCategoria) {
        int res;
        boolean delete = false;
        Conexion conn = new Conexion();
        Connection cn = conn.getConnection();

        if (cn != null) {
            try {
                CallableStatement cs = cn.prepareCall("CALL sp_eliminarcategoria(?)");
                cs.setInt(1, idCategoria);
                res = cs.executeUpdate();

                if (res == 1) {
                    delete = true;
                }
            } catch (SQLException ex) {
                System.out.println("error"+ex);
                
            }

        }

        //proceso
        return delete;
    }

}
