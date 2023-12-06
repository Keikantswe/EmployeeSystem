import axios from "axios"

const EMPLOYEE_API_URL = "http://localhost:8082/api/v1/employees"

class EmployeeService{

    saveEmployee(employee){
        return axios.post(EMPLOYEE_API_URL, employee)
    }

    fetchEmployees(){
        return axios.get(EMPLOYEE_API_URL)
    }

    deleteEmployee(id){
        return axios.delete(EMPLOYEE_API_URL + "/" + id)
    }

}

export default new EmployeeService