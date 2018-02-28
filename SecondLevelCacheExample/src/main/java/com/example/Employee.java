package com.example;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="employee")
//@Cache(usage=CacheConcurrencyStrategy.READ_WRITE, region="employee")
public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;
	
	
	private Set<EmployeeMobile> mobiles;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
//	@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
	@OneToMany
	@JoinColumn(name="employee_id")
	public Set<EmployeeMobile> getMobiles() {
		return mobiles;
	}
	public void setMobiles(Set<EmployeeMobile> mobiles) {
		this.mobiles = mobiles;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", mobiles=" + mobiles + "]";
	}
	
	
	
}
