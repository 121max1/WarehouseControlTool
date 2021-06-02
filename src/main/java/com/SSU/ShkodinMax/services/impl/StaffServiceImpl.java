package com.SSU.ShkodinMax.services.impl;

import com.SSU.ShkodinMax.dao.StaffRepository;
import com.SSU.ShkodinMax.dao.impl.StaffRepositoryImpl;
import com.SSU.ShkodinMax.model.Staff;
import com.SSU.ShkodinMax.services.StaffService;

import java.util.List;

public class StaffServiceImpl implements StaffService {

    private StaffRepository staffRepository;

    public StaffServiceImpl(){
        staffRepository = new StaffRepositoryImpl();
    }

    @Override
    public void addStaff(Staff staff) throws Exception {
        staffRepository.save(staff);
    }

    @Override
    public void updateStaff(Staff staff) throws Exception {
        staffRepository.update(staff);

    }

    @Override
    public void deleteStaff(Staff staff) throws Exception {
        staffRepository.delete(staff);
    }

    @Override
    public Staff getStaffById(int id) throws Exception {
        return  staffRepository.findById(id);
    }

    @Override
    public List<Staff> getAll() {
        return staffRepository.getAll();
    }
}
