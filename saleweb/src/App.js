import { BrowserRouter, Route, Routes } from "react-router-dom";
import Header from "./layout/Header";
import Home from "./components/Home";

import "bootstrap/dist/css/bootstrap.min.css";
import { Container } from "react-bootstrap";

const App = () => {
  return (
    <BrowserRouter>
      <Header />
      <Container>
        <Routes>
          <Route path="/" element={<Home />} />
        </Routes>
      </Container>
    </BrowserRouter>
  );
};

export default App;
