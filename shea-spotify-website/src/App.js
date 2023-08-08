import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import HelloWorldComponent from './component/HelloWorldComponent';

function App() {
  return (
    <Router>
      <Routes>
        <Route path='/' element={<HelloWorldComponent />} />
      </Routes>
    </Router>
  );
}

export default App;