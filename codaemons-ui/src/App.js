import React from 'react';
import './App.css';
import SignUp from './Components/SignUp';
import Login from './Components/Login';
import Home from './Components/Home';
import AppPaths from './AppPaths';
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";

function App() {
  return (
    <Router>
      <div>
        <Switch>
          <Route path={AppPaths.HOME} component={Home} exact={true} />
          <Route path={AppPaths.LOGIN} component={Login} exact={true} />
          <Route path={AppPaths.SIGN_UP} component={SignUp} exact={true} />
        </Switch>
      </div>
    </Router>
  );
}

export default App;