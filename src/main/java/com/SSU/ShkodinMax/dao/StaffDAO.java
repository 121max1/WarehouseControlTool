package com.SSU.ShkodinMax.dao;

import com.SSU.ShkodinMax.model.Staff;

public interface StaffDAO {
    Staff findById(int id);

    void save(Staff staff);

    void update(Staff staff);

    void delete(Staff staff);
}
