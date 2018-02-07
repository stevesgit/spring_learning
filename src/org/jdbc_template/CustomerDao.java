package org.jdbc_template;

import org.bean.customer;

import java.util.List;

public interface CustomerDao {
    //add
    void save(customer u);

    //delete
    void delete(Integer id);

    //update
    void update(customer u);

    //find
    customer getById(Integer id);

    //
    int getTotalCount();

    //
    List<customer> getAll();
}
