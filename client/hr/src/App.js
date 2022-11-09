
import './App.css';
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Login from './components/screens/Login';
import EmployeeHome from './components/screens/EmployeeHome';

import 'bootstrap/dist/css/bootstrap.min.css';



function App() {
  return (
  
    <div >
    <BrowserRouter>
    <Routes>
      <Route path="/" element={<Login/>}/>
      <Route path="/employee" element={<EmployeeHome/>}>

       
      </Route>
    </Routes>
  </BrowserRouter>
    </div>

   
  );
}

export default App;
