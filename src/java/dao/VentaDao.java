/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conection.Conexion;
import interfaz.IVenta;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import transferObject.Venta;

/**
 *
 * @author USUARIOWIN10
 */
public class VentaDao implements IVenta {

    @Override
    public ArrayList<Venta> listarVenta() {
        ArrayList<Venta> listaVen = new ArrayList<>();

        Conexion db = new Conexion();
        Connection cn = db.getConnection();
        String procedimientoalmacenado = "{CALL sp_listarventas}";
        if (cn != null) {
            try {
                CallableStatement cs = cn.prepareCall(procedimientoalmacenado);
                ResultSet rs = cs.executeQuery();
                while (rs.next()) {
                    Venta ven = new Venta();

                    ven.setIdVenta(rs.getInt("idVentas"));
                    ven.setTotal(rs.getDouble("total"));
                    ven.setDate(rs.getString("date"));
                    listaVen.add(ven);

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
        return listaVen;
    }

    @Override
    public boolean insertarVenta(Venta cate) {
        boolean insert = false;
        //proceso
        return insert;
    }

    @Override
    public boolean actualizarVenta(Venta cate) {
        boolean update = false;
        //proceso
        return update;
    }

    @Override
    public boolean eliminarVenta(int idVenta) {
        boolean delete = false;
        //proceso
        return delete;
    }

}
