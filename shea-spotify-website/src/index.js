import React from "react";
import ReactDOM from "react-dom";
import "./index.css";
import App from "./App";
import { BrowserRouter as Router } from "react-router-dom";
import { Provider } from "react-redux";
//import 'semantic-ui-css/semantic.min.css'


import * as serviceWorker from "./serviceWorker";

// const composeEnhancers = window.__REDUX_DEVTOOLS_EXTENSION_COMPOSE__ || compose;

ReactDOM.render(
    <Router>
      <App />
    </Router>
  ,
  document.getElementById("root")
);

serviceWorker.unregister();