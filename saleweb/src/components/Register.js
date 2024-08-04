import { useRef, useState } from "react";
import { Alert, Button, Form } from "react-bootstrap";
import APIs, { endpoints } from "../configs/APIs";
import { useNavigate } from "react-router";

const Register = () => {
    const [user, setUser] = useState({});
    const [err, setErr] = useState();
    const avatar = useRef();
    const nav = useNavigate();
    
    const loadRegister = async (e) => {
        e.preventDefault();
        if (user.password !== user.confirm)
            setErr("Mật khẩu không khớp!");
        else {
            let form = new FormData();
            for (let key in user) {
                form.append(key, user[key]);

            }
            if (avatar.current.files.length > 0)
                form.append("avatar", avatar.current.files[0]);

            let res = await APIs.post(endpoints["register"], form, {
                headers: {
                    "Content-Type": "multipart/form-data"
                }
            });
    
            if (res.status === 201)
                nav("/login");
        }

        
    }

    const change = (e, field) => {
        setUser({...user, [field]: e.target.value});
    }

    return (
        <>
            <h1 className="text-center text-info mt-1">ĐĂNG KÝ NGƯỜI DÙNG</h1>
            {err && <Alert variant="danger">{err}</Alert>}
            <Form onSubmit={loadRegister} method="post">
                <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
                    <Form.Label>Họ và chữ lót: </Form.Label>
                    <Form.Control
                        type="text"
                        placeholder="Họ và chữ lót..."
                        value={user.firstName}
                        onChange={(e) => change(e, "firstName")}
                    />
                </Form.Group>
                <Form.Group className="mb-3" controlId="exampleForm.ControlInput2">
                    <Form.Label>Tên: </Form.Label>
                    <Form.Control
                        type="text"
                        placeholder="Tên..."
                        value={user.lastName}
                        onChange={(e) => change(e, "lastName")}
                    />
                </Form.Group>
                <Form.Group className="mb-3" controlId="exampleForm.ControlInput3">
                    <Form.Label>Tên đăng nhập: </Form.Label>
                    <Form.Control
                        type="text"
                        placeholder="Tên đăng nhập..."
                        value={user.username}
                        onChange={(e) => change(e, "username")}
                    />
                </Form.Group>
                <Form.Group className="mb-3" controlId="exampleForm.ControlInput6">
                    <Form.Label>Mật khẩu: </Form.Label>
                    <Form.Control
                        type="password"
                        placeholder="Mật khẩu..."
                        value={user.password}
                        onChange={(e) => change(e, "password")}
                    />
                </Form.Group>
                <Form.Group className="mb-3" controlId="exampleForm.ControlInput4">
                    <Form.Label>Email: </Form.Label>
                    <Form.Control
                        type="email"
                        placeholder="Email..."
                        value={user.email}
                        onChange={(e) => change(e, "email")}
                    />
                </Form.Group>
                <Form.Group className="mb-3" controlId="exampleForm.ControlInput5">
                    <Form.Label>Số điện thoại: </Form.Label>
                    <Form.Control
                        type="tel"
                        placeholder="Số điện thoại..."
                        value={user.phone}
                        onChange={(e) => change(e, "phone")}
                    />
                </Form.Group>
                
                <Form.Group className="mb-3" controlId="exampleForm.ControlInput7">
                    <Form.Label>Xác nhận mật khẩu: </Form.Label>
                    <Form.Control
                        type="password"
                        placeholder="Mật khẩu..."
                        value={user.confirm}
                        onChange={(e) => change(e, "confirm")}
                    />
                </Form.Group>
                <Form.Group className="mb-3" controlId="exampleForm.ControlInput8">
                    <Form.Label>Ảnh đại diện: </Form.Label>
                    <Form.Control
                        type="file"
                        acept=".png/.jpg"
                        ref={avatar}
                    />
                </Form.Group>

                <Form.Group className="mb-3" controlId="exampleForm.ControlInput9">
                <Button variant="info" type="submit">
                    Đăng nhập
                </Button>
                </Form.Group>
      </Form>

        </>
    );
}

export default Register;