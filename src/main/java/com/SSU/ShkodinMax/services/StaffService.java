package com.SSU.ShkodinMax.services;

import com.SSU.ShkodinMax.model.Client;
import com.SSU.ShkodinMax.model.Staff;

import java.util.List;

public interface StaffService {
    void addStaff(Staff staff) throws Exception;

    void updateStaff(Staff staff) throws Exception;

    void deleteStaff(Staff staff) throws Exception;

    Staff getStaffById(int id) throws Exception;

    List<Staff> getAll();
}
