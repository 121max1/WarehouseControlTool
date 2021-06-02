package com.SSU.ShkodinMax.dao;

import com.SSU.ShkodinMax.model.Staff;

import java.util.List;

public interface StaffRepository {
    Staff findById(int id) throws Exception;

    void save(Staff staff);

    void update(Staff staff);

    void delete(Staff staff);

    List<Staff> getAll();
}
