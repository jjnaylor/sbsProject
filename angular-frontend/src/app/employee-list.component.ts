import {Component, Input, OnInit } from '@angular/core';
import {EmployeeService} from './employee.service';
import {Employee} from './employee';
import {NgForm} from '@angular/forms';

@Component({
  selector: 'employee-list',
  templateUrl: './employee-list.component.html'
})

export class EmployeeListComponent implements OnInit {
  employees: Employee[];
  newEmployee: Employee = new Employee();
  editing: boolean = false;
  editingEmployee: Employee = new Employee();

  constructor(
    private employeeService: EmployeeService,
  ) {}

  ngOnInit(): void {
    this.getEmployees();
  }

  getEmployees(): void {
    this.employeeService.getEmployees()
      .then(employees => this.employees = employees);
  }

  createEmployee(employeeForm: NgForm): void {
    this.employeeService.createEmployee(this.newEmployee)
      .then(createEmployee => {
        employeeForm.reset();
        this.newEmployee = new Employee();
        this.employees.unshift(createEmployee)
      });
  }

  deleteEmployee(id: string): void {
    this.employeeService.deleteEmployee(id)
      .then(() => {
        this.employees = this.employees.filter(employee => employee.id != id);
      });
  }

  updateEmployee(employeeData: Employee): void {
    console.log(employeeData);
    this.employeeService.updateEmployee(employeeData)
      .then(updatedEmployee => {
        let existingEmployee = this.employees.find(employee => employee.id === updatedEmployee.id);
        Object.assign(existingEmployee, updatedEmployee);
        this.clearEditing();
      });
  }

  editEmployee(employeeData: Employee): void {
    this.editing = true;
    Object.assign(this.editingEmployee, employeeData);
  }

  clearEditing(): void {
    this.editingEmployee = new Employee();
    this.editing = false;
  }
}
