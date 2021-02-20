package com.nisfa.service;

import com.nisfa.entity.Employee;
import com.nisfa.service.dto.EmployeeDTO;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author NisfaYasam
 */
@Stateless
public class QueryService {

    @Inject
    EntityManager entityManager;

    @Inject
    Logger LOG_QUERY;

    public EmployeeDTO getEmployeeById(Long id) {
        EmployeeDTO employeeDTO = null;
        try {
            Employee employee = entityManager.find(Employee.class, id);

            employeeDTO = new EmployeeDTO();
            employeeDTO.setId(employee.getId());
            employeeDTO.setName(employee.getName());
        } catch (Exception ex) {
            LOG_QUERY.log(Level.SEVERE, "Exception on retrieve Employee", ex);
        }
        return employeeDTO;
    }

    public List<EmployeeDTO> getEmployees() {
        List<EmployeeDTO> employeeDTOs = null;
        try {
            List<Employee> employees = entityManager.
                    createQuery("select e from Employee as e").getResultList();
            employeeDTOs = new ArrayList<>();
            EmployeeDTO employeeDTO = null;

            for (Employee employee : employees) {

                employeeDTO = new EmployeeDTO();
                employeeDTO.setId(employee.getId());
                employeeDTO.setName(employee.getName());
                employeeDTOs.add(employeeDTO);
            }
        } catch (Exception ex) {
            LOG_QUERY.log(Level.SEVERE, "Exception on retrieve Employee", ex);
        }
        return employeeDTOs;
    }

}
