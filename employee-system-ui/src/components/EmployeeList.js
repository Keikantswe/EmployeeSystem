import React , { useState , useEffect } from 'react'
import { useNavigate } from 'react-router-dom'
import EmployeeService from '../services/EmployeeService';
import Employees from './Employees';

const EmployeeList = () => {

    const navigate = useNavigate();

    const [loading, setLoading] = useState(true)
    const [employees, setEmployees] = useState(null)

    useEffect(() => {

        const fetchData = async () =>{
            setLoading(true) 
            try {

                const response = await EmployeeService.fetchEmployees();
                setEmployees(response.data);
            } catch (error) {
                console.log(error)
            }

            setLoading(false)
        };

        fetchData();
    
    }, [])

    const deleteEmployee = (e, id) =>{
        e.preventDefault();
        EmployeeService.deleteEmployee(id).then((response) => {
           if(employees){
            setEmployees((prevElement) =>{
                return prevElement.filter((employee) => employee.id !== id)
            })
           }
        })
    };
    
  return(
    <>
      <div className=' container mx-auto my-10 '>
        <div className='h-12 '>
            <button
            onClick={ () => navigate("/AddEmployee")}
            className=' rounded bg-slate-600 text-white py-2 px-6 font-semibold'>Employee List</button>
        </div>
        <div className='flex shadow border-b'>
            <table className='min-w-full'>
                <thead className='bg-gray-50'>
                   <tr>
                    <th className='text-left font-medium text-gray-500 uppercase tracking-wider py-3 px-6'> First Name</th>
                    <th className='text-left font-medium text-gray-500 uppercase tracking-wider py-3 px-6'> Last Name</th>
                    <th className='text-left font-medium text-gray-500 uppercase tracking-wider py-3 px-6'> Email Address</th>
                    <th className='text-right font-medium text-gray-500 uppercase tracking-wider py-3 px-6'> Actions</th>
                   </tr>
                </thead>
                {!loading &&(
                <tbody className='bg-white '>
                    {employees.map((employee) => (
                        <Employees 
                        employee={employee}
                        deleteEmployee={deleteEmployee}
                        key={employee.id}>
                        </Employees>
                    ))}
                </tbody>
                )}
            </table>
        </div>
     </div>
    </>
   
  )
}

export default EmployeeList