package com.basics.design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Employee{
	String name;
	int id;
	int reportingId;
	List<Employee> subordinates;
	
	public Employee(String name, int id, int reportinId){
		this.name = name;
		this.id = id;
		this.reportingId = reportinId;
	}
}

class EmpNode{
	Map<Integer, Employee> employees = new HashMap<>();
	Employee root;
	
	public void createEmpData(String name, int id, int reportinId){
		Employee emp = new Employee(name, id, reportinId);
		employees.put(id, emp);
		if(reportinId == 0){
			root = emp;
		}
	}
	
	public void buildHierarchy(Employee root){
		List<Employee> subordinates = getSubordinates(root.id);
		root.subordinates = subordinates;
		if(subordinates.size() == 0){
			return;
		}
		for(Employee e : subordinates){
			buildHierarchy(e);
		}
	}
	
	List<Employee> getSubordinates(int id){
		List<Employee> subordinates = new ArrayList<Employee>();
		
		for(Employee emp : employees.values()){
			if(emp.reportingId == id){
				subordinates.add(emp);
			}
		}
		return subordinates;
	}
	
	
	public void showHierarchy(Employee root, int level){
		
		for(int i=0; i<level; i++){
			System.out.print("\t");
		}
		
		System.out.println(root.name);
		
		System.out.print(" ");
		
		List<Employee> subordinates = root.subordinates;
		for(Employee e : subordinates){
			showHierarchy(e, level+1);
		}
		
	}
	
}



public class EmployeeHierarchyStructure {
	public static void main(String[] args) {
		EmpNode emp = new EmpNode();
		emp.createEmpData("marcus", 1, 0);
		emp.createEmpData("nick", 2, 1);
		emp.createEmpData("vishal", 3, 1);
		emp.createEmpData("prathap", 4, 1);
		emp.createEmpData("sourav", 5, 3);
		emp.createEmpData("tanay", 6, 3);
		emp.createEmpData("abhishek", 7, 2);
		emp.createEmpData("salman", 8, 2);
		emp.createEmpData("yoga", 9, 4);
		emp.createEmpData("ramesh", 10, 4);
		emp.createEmpData("manju", 11, 9);
		emp.createEmpData("pratyush", 12, 10);
		
		emp.buildHierarchy(emp.root);
		emp.showHierarchy(emp.root, 0);
		
	}
}
