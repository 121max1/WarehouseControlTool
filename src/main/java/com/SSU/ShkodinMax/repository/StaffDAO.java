package com.SSU.ShkodinMax.repository;

import com.SSU.ShkodinMax.model.Product;
import com.SSU.ShkodinMax.model.Staff;

import java.util.List;

public interface StaffDAO {
    Staff findById(int id) throws Exception;

    void save(Staff staff);

    void update(Staff staff);

    void delete(Staff staff);

    List<Staff> getAll();
}
