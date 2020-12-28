package data;

import model.CustomerType;

import java.util.List;

public interface ICustomerTypeDAO {
    public List<CustomerType> selectAllCustomerType();

    public CustomerType selectTypeNote(int id);
}
