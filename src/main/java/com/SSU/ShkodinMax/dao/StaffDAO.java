package com.SSU.ShkodinMax.dao;

import com.SSU.ShkodinMax.model.Staff;

public interface StaffDAO {
    Staff findById(int id) throws Exception;

    void save(Staff staff) throws Exception;

    void update(Staff staff) throws Exception;

    void delete(Staff staff) throws Exception;
}
