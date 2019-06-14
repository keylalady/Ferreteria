/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conection.Conexion;
import interfaz.IDetalleVenta;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import transferObject.DetalleVenta;

/**
 *
 * @author USUARIOWIN10
 */
public class DetalleVentaDao implements IDetalleVenta {

    @Override
    public ArrayList<DetalleVenta> listarDetalles() {
        ArrayList<DetalleVenta> listadeta = new ArrayList<>();

        Conexion db = new Conexion();
        Connection cn = db.getConnection();
        String procedimientoalmacenado = "{CALL sp_listadetalleventas}";
        if (cn != null) {
            try {
                CallableStatement cs = cn.prepareCall(procedimientoalmacenado);
                ResultSet rs = cs.executeQuery();
                while (rs.next()) {
                    DetalleVenta deta = new DetalleVenta();

                     deta.setIdDetalleVenta(rs.getInt("idDetalleVenta"));
                    deta.setCantidad(rs.getInt("cantidad"));
                    deta.setSubtotal(rs.getDouble("subtotal"));
                    listadeta.add(deta);
                }

            } catch (SQLException e) {

            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {

                }
            }
        }

        //proceso
        return listadeta;
    }

    @Override
    public boolean insertarDetalleVenta(DetalleVenta cate) {
        boolean insert = false;
        //proceso
        return insert;
    }

    @Override
    public boolean actualizarDetalleVenta(DetalleVenta cate) {
        boolean update = false;
        //proceso
        return update;
    }

    @Override
    public boolean eliminarDetalleVenta(int idDetalleVenta) {
        boolean delete = false;
        //proceso
        return delete;
    }
}
