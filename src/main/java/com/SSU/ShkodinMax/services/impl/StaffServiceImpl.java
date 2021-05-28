package com.SSU.ShkodinMax.services.impl;

import com.SSU.ShkodinMax.repository.StaffDAO;
import com.SSU.ShkodinMax.repository.impl.StaffDAOImpl;
import com.SSU.ShkodinMax.model.Staff;
import com.SSU.ShkodinMax.services.StaffService;

import java.util.List;

public class StaffServiceImpl implements StaffService {

    private StaffDAO staffDAO;

    public StaffServiceImpl(){
        staffDAO = new StaffDAOImpl();
    }

    @Override
    public void addStaff(Staff staff) throws Exception {
        staffDAO.save(staff);
    }

    @Override
    public void updateStaff(Staff staff) throws Exception {
        staffDAO.update(staff);

    }

    @Override
    public void deleteStaff(Staff staff) throws Exception {
        staffDAO.delete(staff);
    }

    @Override
    public Staff getStaffById(int id) throws Exception {
        return  staffDAO.findById(id);
    }

    @Override
    public List<Staff> getAll() {
        return staffDAO.getAll();
    }
}
