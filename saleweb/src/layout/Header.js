import { useContext, useEffect, useState } from "react";
import APIs, { endpoints } from "../configs/APIs";
import {
  Button,
  Container,
  Form,
  Image,
  Nav,
  Navbar,
  NavDropdown,
} from "react-bootstrap";
import { Link, useNavigate } from "react-router-dom";
import { MyDispatchContext, MyUserContext } from "../App";

const Header = () => {
  const [categories, setCategories] = useState([]);
  const [q, setQ] = useState("");
  const nav = useNavigate();

  const user = useContext(MyUserContext);
  const dispatch = useContext(MyDispatchContext);

  const loadCate = async () => {
    let res = await APIs.get(endpoints["categories"]);
    setCategories(res.data);
  };

  useEffect(() => {
    loadCate();
  }, []);

  const search = (e) => {
    e.preventDefault();
    nav(`/?kw=${q}`);
  };

  return (
    <>
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
                  return (
                    <Link
                      className="dropdown-item"
                      to={url}
                      key={c.id}
                      href="#action/3.1"
                    >
                      {c.name}
                    </Link>
                  );
                })}
              </NavDropdown>
              {user === null ? (
                <>
                  <Link className="nav-link text-success" to="/login">
                    &#129489; Đăng nhập
                  </Link>
                  <Link className="nav-link text-success" to="/register">
                    &#129489; Đăng ký
                  </Link>
                </>
              ) : (
                <>
                  <Link className="nav-link text-success" to="/login">
                    {/* <Image src={user.avatar} width="25" roundedCircle /> */}
                    Chào{user.username}
                  </Link>
                  <Button
                    variant="danger"
                    onClick={() => dispatch({ type: "logout" })}
                  >
                    Đăng xuất
                  </Button>
                </>
              )}
            </Nav>
            <Form onSubmit={search} className="d-flex">
              <Form.Control
                type="search"
                placeholder="Tìm sản phẩm"
                className="me-2"
                aria-label="Search"
                value={q}
                onChange={(e) => setQ(e.target.value)}
              />
              <Button type="submit" variant="outline-success">
                Tìm
              </Button>
            </Form>
          </Navbar.Collapse>
        </Container>
      </Navbar>
    </>
  );
};

export default Header;
