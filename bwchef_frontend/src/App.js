import React from 'react';
import { BrowserRouter as Router, Route,Link, Routes } from 'react-router-dom';
import ChefManagement from './pages/ChefManagement';

function App() {
  
    return (
      <Router>
        <div>
          <h1>Main Page</h1>
          <Link to="/chef">
            <button>Go to Chef Management</button>
          </Link>


          <Routes>
            <Route path='/chef' element={<ChefManagement />} />
          </Routes>
        </div>
      </Router>
    );
}

export default App;
