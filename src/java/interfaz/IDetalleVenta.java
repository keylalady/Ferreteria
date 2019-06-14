/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import java.util.ArrayList;
import transferObject.DetalleVenta;

/**
 *
 * @author USUARIOWIN10
 */
public interface IDetalleVenta {

    public abstract ArrayList<DetalleVenta> listarDetalles();

    public abstract boolean insertarDetalleVenta(DetalleVenta cate);

    public abstract boolean actualizarDetalleVenta(DetalleVenta cate);

    public abstract boolean eliminarDetalleVenta(int idDetalleVenta);
}
