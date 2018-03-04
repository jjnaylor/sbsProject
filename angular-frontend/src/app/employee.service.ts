import {Injectable} from '@angular/core';
import {Employee} from './employee';
import {Headers, Http} from '@angular/http';
import 'rxjs/add/operator/toPromise';

@Injectable()
export class EmployeeService {
  private baseUrl = 'http://localhost:8080';

  constructor(private http: Http) {}

  getEmployees(): Promise<Employee[]>{
    return this.http.get(this.baseUrl + '/api/employees/')
      .toPromise()
      .then(response => response.json() as Employee[])
      .catch(this.handleError);
  }

  createEmployee(employeeData: Employee): Promise<Employee> {
    return this.http.post(this.baseUrl + '/api/employees/', employeeData)
      .toPromise().then(response => response.json() as Employee)
      .catch(this.handleError);
  }

  updateEmployee(employeeData: Employee): Promise<Employee>{
    return this.http.put(this.baseUrl + '/api/employees/' + employeeData.id, employeeData)
      .toPromise()
      .then(response => response.json() as Employee)
      .catch(this.handleError);
  }

  deleteEmployee(id: string): Promise<any> {
    return this.http.delete(this.baseUrl + '/api/employees/' + id)
      .toPromise()
      .catch(this.handleError);
  }

  private handleError(error:any): Promise<any> {
    console.error('Some error occurred', error);
    return Promise.reject(error.message || error);
  }
}
