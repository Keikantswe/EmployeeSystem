import React from 'react'

function Employees({employee , deleteEmployee}) {
  return (
    <tr key={employee.id}>
                        <td className=' text-left px-6 py-4 whitespace-nowrap'>
                            <div className='text-gray-500'>{employee.firstName}</div>
                        </td>
                        <td className=' text-left px-6 py-4 whitespace-nowrap'>
                            <div className='text-gray-500'>{employee.lastName}</div>
                        </td>
                        <td className=' text-left px-6 py-4 whitespace-nowrap'>
                            <div className='text-gray-500'>{employee.emailId}</div>
                        </td>
                        <td className=' text-right px-6 py-4 whitespace-nowrap font-medium text-small'>
                            <a href='' className='text-green-500 hover:text-green-800' >Edit</a>
                            <a 
                            onClick={(e , id) => deleteEmployee(e, employee.id)}
                            className='text-red-500 hover:text-red-800 hover:cursor-pointer'> Delete</a>
                        </td>
                    </tr>
  )
}

export default Employees