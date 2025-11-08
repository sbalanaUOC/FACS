package DAO;


import modelo.Cliente;

import java.util.ArrayList;

public interface ClienteDAO extends CRUD<Cliente,String>{

    ArrayList<Cliente> Read_STD();
    ArrayList<Cliente> Read_PRM();


}
