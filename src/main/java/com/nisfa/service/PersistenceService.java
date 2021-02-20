package com.nisfa.service;

import com.nisfa.entity.Employee;
import com.nisfa.service.dto.EmployeeDTO;
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
public class PersistenceService {

    @Inject
    EntityManager entityManager;

    @Inject
    private Logger LOG_PERSIST;

    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {

        try {
            Employee employee = new Employee();
            employee.setName(employeeDTO.getName());

            entityManager.persist(employee);

            employeeDTO.setId(employee.getId());
        } catch (Exception ex) {
            LOG_PERSIST.log(Level.SEVERE, "Exception on createEmployee", ex);
        }
        return employeeDTO;
    }

    public EmployeeDTO updateEmployee(EmployeeDTO employeeDTO) {

        try {
            Employee employee = new Employee();
            employee.setName(employeeDTO.getName());

            entityManager.merge(employee);

        } catch (Exception ex) {
            LOG_PERSIST.log(Level.SEVERE, "Exception on updateEmployee", ex);
        }
        return employeeDTO;
    }

}
