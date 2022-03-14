package net.javaguides.springboot.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.type.StringNVarcharType;

@Entity
@Table(name = "departments")
public class Departments {
	
	@Id
	@Column(name = "dep_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "dep_name")
	private String depName;



	@OneToMany(mappedBy = "department")
    private List <Employee> employees;
	
	public Departments() {
		
	}
	
	public Departments(String depName, String empName,List <Employee> employees) {
		super();
		this.depName = depName;

		this.employees = employees;

	}
	public long getId() { 
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDepName() {
		return depName;
	}
	public void setDepName(String depName) {
		this.depName = depName;
	}
	
	
	public List< String> getEmployename() {
		List <String> names =new ArrayList<String>();
		for (Employee emp : employees)   
		{  
		//prints the elements of the List  
		 names.add(emp.getFirstName());
		}  

		return names;
	}
	public void setEmployees(List <Employee> employees) {
		this.employees = employees;
	}
	

}
