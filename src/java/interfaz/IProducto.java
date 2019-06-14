/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import java.util.ArrayList;
import transferObject.Producto;

/**
 *
 * @author USUARIOWIN10
 */
public interface IProducto {
    
    public abstract ArrayList<Producto> listarProductos();

    public abstract boolean insertarProducto(Producto cate);

    public abstract boolean actualizarProducto(Producto cate);

    public abstract boolean eliminarProducto(int idProducto);
}
