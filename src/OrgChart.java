import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class OrgChart {

    // A Graph based Adjacency List for maintaining reports. LinkedHashMap is to preserve order of insertion
    Map<String, List<Employee>> orgChart;

    // Employee record to manage additional future attributes of Employee and change display order or other characterestics
    Map<String, Employee> employees;

    public OrgChart() {
        orgChart = new LinkedHashMap<>();
        employees = new HashMap<>();
    }

    public void add(String id, String name, String managerId)
    {
        Employee employee = new Employee(id,name,managerId);
        if(!orgChart.containsKey(id)) {
            orgChart.put(id,new ArrayList<>());
            employees.put(id,employee);
        }
        // add to given manager or else update the employee record to have no manager
        if(orgChart.containsKey(managerId)) {
            orgChart.get(managerId).add(employee);
        } else {
            employee.managerId = null;
        }
    }

    public void print()
    {
        // perform a DFS sytled traversal and maintain a visited record to safeguard against infinite loop input
        Iterator<Map.Entry<String,List<Employee>>> iterator = orgChart.entrySet().iterator();
        Set<Employee> visited = new HashSet<>();
        while (iterator.hasNext()) {
            String employeeId = iterator.next().getKey();
            Employee employee = employees.get(employeeId);
            if(!visited.contains(employee)) {
                printEmployees(employee,0, visited);
            }
        }
    }

    private void printEmployees(Employee firstEmployee, int depth, Set<Employee> visited) {
        if(firstEmployee == null || visited.contains(firstEmployee)) {
            return;
        }

        for(int i = 0; i < depth; i++) {
            System.out.print("  ");
        }

        System.out.print(firstEmployee);
        System.out.println();
        visited.add(firstEmployee);
        for(Employee e : orgChart.get(firstEmployee.id)) {

            printEmployees(e, depth+1, visited);

        }
    }

    public void remove(String employeeId)
    {
        if(orgChart.containsKey(employeeId)) {
            // remove from employee db
            Employee employee = employees.remove(employeeId);
            //move to employee manager
            if(employee.hasManager()) {
                //move any reports of current employee
                if(orgChart.get(employeeId).size() > 0) {
                    orgChart.get(employee.managerId).addAll(orgChart.get(employeeId));
                }
                //remove from manager
                orgChart.get(employee.managerId).remove(employee);
            }
            orgChart.remove(employeeId);
        }
    }

    public void move(String employeeId, String newManagerId)
    {
        if(orgChart.containsKey(employeeId) && orgChart.containsKey(newManagerId)) {
            Employee currentEmployee = employees.get(employeeId);
            // if employee has manager, remove from old manager reports
            if(currentEmployee.hasManager()) {
                orgChart.get(currentEmployee.managerId).remove(currentEmployee);
            }
            // update employee to report under new manager and update employee record.
            orgChart.get(newManagerId).add(currentEmployee);
            currentEmployee.managerId = newManagerId;
        }
    }

    public int count(String employeeId)
    {
        int count = -1;
        if(orgChart.containsKey(employeeId)) {
            List<Employee> bfs = new ArrayList<>();
            bfs.add(employees.get(employeeId));

            while(bfs.size() > 0) {
                Employee e = bfs.remove(0);
                count++;
                bfs.addAll(orgChart.get(e.id));
            }
        }
        return count;
    }

    class Employee {
        String id;
        String name;
        String managerId;

        public Employee(String id, String name, String managerId) {
            this.id = id;
            this.name = name;
            this.managerId = managerId;
        }

        boolean hasManager() {
            return (managerId != null && !managerId.equals("-1"));
        }

        @Override
        public boolean equals(Object o) {
            return (o instanceof Employee)
                    && (((Employee) o).id.equals(this.id)
                    && ((Employee) o).name.equals(this.name)
                    && ((Employee) o).managerId.equals(this.managerId));
        }

        @Override
        public String toString() {
            return String.format("%s [%s]",name,id);
        }
    }
}
