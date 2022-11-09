import { React, useState, useEffect } from "react";
import { Link } from "react-router-dom";
import "./list.css";
import axios from "axios";


const BUTTON_STATUS = {
  EDIT: 0,
  SAVE: 1,
};
const  ComplaintsTable = ()=> {
  const [post, setPosts] = useState([]);
  const [buttonStatus, setButtonStatus] = useState(BUTTON_STATUS.EDIT);
  const [editingTab, setEditingTab] = useState(null);
  const [reply, setReply] = useState("");
  const [status, setStatus] = useState("");


  useEffect(() => {
    console.log("called");
    getComplaintsDetails();
  }, []);


  

  const getComplaintsDetails = async() => {
    console.log("test1");
    await axios
      .get("http://localhost:8080/employee/")
      .then((res) => {
        console.log(res.data.payload[0]);
        setPosts(res.data.payload[0])
        console.log(post);


      })
      .catch((err) => {
        console.log(err);
      });
  };

  const filterItem = (curcat) => {
    let temoProduct = post.slice().filter((newVal) => {
      return newVal.Status === curcat;
    });
    setPosts(temoProduct);
  };

  const filterCategory = (curcat) => {
    let temoProduct = post.slice().filter((newVal) => {
      return newVal.category === curcat;
    });
    setPosts(temoProduct);
  };

  const filterAll = (curcat) => {
    getComplaintsDetails();
  };

  return (
    <>

      <div id="head">Complaints Management</div>

   
        <table id="complaints">
          <thead>
            <th>Employee ID</th>
            <th>First name</th>
            <th>Last name</th>
            <th>Phone number</th>
            <th>Email</th>
            <th>Action Button</th>
          </thead>
          <tbody>
          {
            post.map((e)=>(
<>
<tr>
<td>{e.id}</td>
<td>{e.firstName}</td>
<td>{e.lastName}</td>
<td>{e.email}</td>
</tr>
</>
              
          
                
            ))
          }
          </tbody>
        </table>
    
    </>
  );
}
export default ComplaintsTable;