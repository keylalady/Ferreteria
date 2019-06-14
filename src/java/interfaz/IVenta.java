/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import java.util.ArrayList;
import transferObject.Venta;

/**
 *
 * @author USUARIOWIN10
 */
public interface IVenta {

    public abstract ArrayList<Venta> listarVenta();

    public abstract boolean insertarVenta(Venta cate);

    public abstract boolean actualizarVenta(Venta cate);

    public abstract boolean eliminarVenta(int idVenta);
}
