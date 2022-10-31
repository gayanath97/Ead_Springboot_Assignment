import axios from "axios";
import { useEffect, useState } from "react";
import "../screens/registration.css"

function AdminHome()
{
   const [id, setId] = useState("");
   const [firstName, setFirstName] = useState("");
   const [lastName, setLastName] = useState("");
   const [phoneNumber, setPhoneNumber] = useState("");
   const [email, setEmail] = useState("");
   const [department ,setDepartment] = useState("");
const [token,setToken]=useState()

  
useEffect(() => {
    var token = localStorage.getItem("token");
    console.log(token);
    setToken(token);
}, [])

const config = {
    headers: { Authorization: `Bearer ${token}` }
};

   async function handleSubmit(event)
    {
        event.preventDefault();
    try
        {
         await axios.post("http://localhost:8080/employee/", config,
        {
           id:id,
           firstName:firstName,
           lastName:lastName,
           phoneNumber:phoneNumber,
           email:email,
           department:department
        }).then((res)=>console.log(res.data.email)
    

        
        )
      

          alert("User logged in Successfully");
    
        
        }
    catch(err)
        {
          alert("User Registation Failed");
          console.log(err);
        }
   }
    return (
        <div className="register-container">
     
            <form className="register-form" onSubmit={handleSubmit}> 
            <br></br>      
            <h1>Add employee</h1>
            <p>Fill in the Information Below</p>

           

    <input type="text" 
            name="id" 
            placeholder="enter id"
            onChange={(event) =>
                {
                    setId(event.target.value);       
                }}           
            />
            <input type="text" 
            name="firstName" 
            placeholder="enter first name"
            onChange={(event) =>
                {
                    setFirstName(event.target.value);       
                }}           
            />
            <input type="text" 
            name="lastName" 
            placeholder="enter last name"
            onChange={(event) =>
                {
                    setLastName(event.target.value);       
                }}           
            />
            <input type="text" 
            name="phoneNumber" 
            placeholder="enter phone nnumber"
            onChange={(event) =>
                {
                    setPhoneNumber(event.target.value);       
                }}           
            />
            <input type="text" 
            name="email" 
            placeholder="enter email"
            onChange={(event) =>
                {
                    setEmail(event.target.value);       
                }}           
            />
            <input type="text" 
            name="department" 
            placeholder="enter department"
            onChange={(event) =>
                {
                    setDepartment(event.target.value);       
                }}           
            />

            <button type="submit">Register</button>

    
            </form>     

     
        </div>
    )
}

export default AdminHome;