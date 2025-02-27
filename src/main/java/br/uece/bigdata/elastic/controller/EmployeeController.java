package br.uece.bigdata.elastic.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.uece.bigdata.elastic.model.Employee;
import br.uece.bigdata.elastic.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService service;
	
	@PostMapping
    public Employee create(@RequestBody Employee employee) {
        return service.create(employee);
    }
	
    @GetMapping("/{id}")
    public Optional<Employee> findById(@PathVariable String id) {
        return service.findById(id);
    }
    
    @GetMapping("/by-name/{name}")
    public List<Employee> findByName(@PathVariable String name) {
        return service.findByName(name);
    }

    @GetMapping
    public Iterable<Employee> findAll() {
        return service.findAll();
    }

    @PutMapping("/{id}")
    public Employee update(@PathVariable String id, @RequestBody Employee employee) {
        return service.update(id, employee);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
    	service.delete(id);
    }
    
    @DeleteMapping("/by-name/{name}")
    public void deleteByName(@PathVariable String name) {
    	service.deleteByName(name);
    }
}
