package br.uece.bigdata.elastic.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import br.uece.bigdata.elastic.model.Employee;

@Repository
public interface EmployeeRepository extends ElasticsearchRepository<Employee, String> {

    public List<Employee> findByName(String firstName);
    
    public void deleteByName(String firstName);
}
