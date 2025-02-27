package br.uece.bigdata.elastic.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.uece.bigdata.elastic.model.Employee;
import br.uece.bigdata.elastic.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repository;
	
	public Employee create(Employee employee) {
        return repository.save(employee);
    }

	public Optional<Employee> findById(String id) {
        return repository.findById(id);
    }
	
	public List<Employee> findByName(String name) {
		return repository.findByName(name);
	}

    public Iterable<Employee> findAll() {
        return repository.findAll();
    }

    public Employee update(String id, Employee employee) {
        employee.setId(id);
        return repository.save(employee);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }
    
    public void deleteByName(String name) {
    	repository.deleteByName(name);
    }
}
