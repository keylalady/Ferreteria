/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conection.Conexion;
import interfaz.IProducto;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import transferObject.Producto;

/**
 *
 * @author USUARIOWIN10
 */
public class ProductoDao implements IProducto {

    @Override
    public ArrayList<Producto> listarProductos() {
        ArrayList<Producto> listapro = new ArrayList<>();

        Conexion db = new Conexion();
        Connection cn = db.getConnection();
        String procedimientoalmacenado = "{CALL sp_listarproductos}";
        if (cn != null) {
            try {
                CallableStatement cs = cn.prepareCall(procedimientoalmacenado);
                ResultSet rs = cs.executeQuery();
                while (rs.next()) {
                    Producto pro = new Producto();

                    pro.setIdProducto(rs.getInt("idProducto"));
                    pro.setNombre(rs.getString("nombre"));
                    pro.setPrecio(rs.getDouble("precio"));
                    pro.setMarca(rs.getString("marca"));
                    pro.setStock(rs.getInt("stock"));
                    listapro.add(pro);
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
        return listapro;
    }

    @Override
    public boolean insertarProducto(Producto cate) {
        boolean insert = false;
        //proceso
        return insert;
    }

    @Override
    public boolean actualizarProducto(Producto cate) {
        boolean update = false;
        //proceso
        return update;
    }

    @Override
    public boolean eliminarProducto(int idProducto) {
        boolean delete = false;
        //proceso
        return delete;
    }

}
