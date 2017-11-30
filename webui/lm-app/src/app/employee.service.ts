import { Employee } from './employee';

import { Observable } from 'rxjs/Rx';
import 'rxjs/add/operator/toPromise';

import { Http } from '@angular/http';
import { Injectable } from '@angular/core';


@Injectable()
export class EmployeeService {
    constructor(private http: Http) {
    }

    getEmployees(): Promise<Employee[]> {
        console.log('getEmployees called on employee.service');
        return this.http.get('/ftp08/api/employees')
        .toPromise()
        .then(response => response.json() as Employee[])
        .catch(this.handleError);
    }

    private handleError(error: any): Promise<any> {
        console.error('An error occurred', error); // for demo purposes only
        return Promise.reject(error.message || error);
    }
}
