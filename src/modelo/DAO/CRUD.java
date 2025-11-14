package modelo.DAO;

import java.util.ArrayList;


public interface CRUD<T,K> {

       void Create(T k) ;
       T Read();
       void Update(T k);
       void Delete(T k);
       ArrayList<T> Read_all();
       int CreateWithIndex(T K);

}
