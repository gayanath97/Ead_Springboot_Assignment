import axios from "axios";
import { useState } from "react";
import "../screens/registration.css"

function Register()
{
   const [username, setUsername] = useState("");
   const [password, setPassword] = useState("");
  

   async function handleSubmit(event)
    {
        event.preventDefault();
    try
        {
         await axios.post("http://localhost:8080/api/auth/signin", 
        {
            username:username,
            password:password
        }).then((res)=>console.log(res.data))
          alert("User Registation Successfully");
    
        
        }
    catch(err)
        {
          alert("User Registation Failed");
        }
   }
    return (
        <div className="register-container">
     
            <form className="register-form" onSubmit={handleSubmit}> 
            <br></br>      
            <h1>Sign in</h1>
            <p>Fill in the Information Below</p>

           

    <input type="text" 
            name="username" 
            placeholder="enter username"
            onChange={(event) =>
                {
                    setUsername(event.target.value);       
                }}           
            />
            <input type="text" 
            name="password" 
            placeholder="enter password"
            onChange={(event) =>
                {
                    setPassword(event.target.value);       
                }}           
            />

            <button type="submit">Register</button>

    
            </form>     

     
        </div>
    )
}

export default Register;