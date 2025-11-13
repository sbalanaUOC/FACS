package DAO;

import modelo.Articulo;
import modelo.Cliente;


public interface ArticuloDAO extends CRUD<Articulo,String>{


    Articulo Read_id(String idarticulo);

}
