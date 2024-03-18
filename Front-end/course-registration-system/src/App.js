import './App.css';
import * as React from 'react';
import Dashboard from './components/dashboard/Dashboard';
import SignIn from './components/login/SignIn';

function App() {

  const [logedIn, setLogedIn] = React.useState(false);

  const redirect = (value) => {
    setLogedIn(value);
  }
 
  return (
    <div className="App">
      <header className="App-header">
        
        {!logedIn ? (
          <SignIn redirect={redirect} />
        ) : (
          <Dashboard redirect={redirect} />
        )}

      </header>
    </div>
  );
}

export default App;
