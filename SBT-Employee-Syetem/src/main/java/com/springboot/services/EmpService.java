package com.springboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.springboot.entity.Employee;
import com.springboot.repository.EmployeeRepository;



@Service
public class EmpService {

    @Autowired
    private EmployeeRepository employeeRepository;
    private Employee e;

    
    public void addEmp(Employee e) {
        employeeRepository.save(e);
    }


    public List<Employee> getAllEmp() {
        return employeeRepository.findAll();
    }

    public Employee getEMpById(int id) {
		e = employeeRepository.getById(id);
		return e;
	}


    
	public void deleteEMp(int id) {
        employeeRepository.deleteById(null);
    }

    public Page <Employee> getEMpByPaginate(int currentPage, int size) {
		Pageable p = PageRequest.of(currentPage, size);
		return employeeRepository.findAll(p);
	}


}
