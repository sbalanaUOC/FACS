package DAO;

import java.util.List;

public interface CRUD<T,K> {

       void Create(T k);
       T Read();
       void Update(T k);
       void Delete(T k);
       List <T> Read_all();

}
