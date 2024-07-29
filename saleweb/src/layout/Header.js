import { useEffect, useState } from "react";
import APIs, { endpoints } from "../configs/APIs";
import { Container, Nav, Navbar, NavDropdown } from "react-bootstrap";
import { Link } from "react-router-dom";

const Header = () => {
  const [categories, setCategories] = useState([]);

  const loadCate = async () => {
    let res = await APIs.get(endpoints["categories"]);
    setCategories(res.data);
  };

  useEffect(() => {
    loadCate();
  }, []);

  return (
    <>
      {/* <h1>HEADER</h1>
      {categories.map((c) => (
        <li key={c.is}>{c.name}</li>
      ))} */}

      <Navbar expand="lg" className="bg-body-tertiary">
        <Container>
          <Navbar.Brand href="#home">E-Commerce Website</Navbar.Brand>
          <Navbar.Toggle aria-controls="basic-navbar-nav" />
          <Navbar.Collapse id="basic-navbar-nav">
            <Nav className="me-auto">
              <Link to="/" className="nav-link">
                Trang chủ
              </Link>
              <NavDropdown title="Danh muc" id="basic-nav-dropdown">
                {categories.map((c) => {
                    const url = `/?cateId=${c.id}`;
                  return <Link className="dropdown-item" to={url} key={c.id} href="#action/3.1">
                    {c.name}
                  </Link>;
                })}
              </NavDropdown>
            </Nav>
          </Navbar.Collapse>
        </Container>
      </Navbar>
    </>
  );
};

export default Header;
