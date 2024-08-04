import axios from "axios";
import cookie from "react-cookies";

const BASE_URL = "http://localhost:8080/SpringSaleApp/api/";

export const endpoints = {
    "categories": "/categories",
    "products": "/products",
    "login": "/login",
    "current-user": "/current-user"
}

export const authAPIs = () => {
    return axios.create({
        baseURL: BASE_URL,
        headers: {
            'Authorization': cookie.load('token')
        }
    });
}

export default axios.create({
    baseURL: BASE_URL
})