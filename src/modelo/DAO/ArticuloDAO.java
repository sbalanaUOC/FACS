package modelo.DAO;

import modelo.Articulo;


public interface ArticuloDAO extends CRUD<Articulo,String>{


    Articulo Read_id(String idarticulo);

}
