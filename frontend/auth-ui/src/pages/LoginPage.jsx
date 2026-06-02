import { useState } from "react";
import { loginUser } from "../services/authService";

function LoginPage() {

  const [email, setEmail] =
    useState("");

  const [password, setPassword] =
    useState("");

  const handleSubmit = async (e) => {

    e.preventDefault();

    try {

      const response =
        await loginUser({
          email,
          password
        });

      localStorage.setItem(
        "accessToken",
        response.accessToken
      );

      console.log(
        "TOKEN",
        response.accessToken
        );

        console.log(
        "EMAIL",
        response.email
        );

        console.log(
        "ROLE",
        response.role
        );

      localStorage.setItem(
        "email",
        response.email
      );

      localStorage.setItem(
        "role",
        response.role
      );

      window.location.href = "/dashboard";

    } catch (error) {

    console.log(error);

    alert(
        error.response?.data?.message ||
        error.message
    );
    }
  };

  return (

    <div className="auth-container">

    <div className="card auth-card">

    <div className="auth-header">

    <h1>UCE Health</h1>

    <p>
    University Medical Appointment System
    </p>

    </div>

    <div className="auth-body">

    <form onSubmit={handleSubmit}>

    <input
    className="form-control mb-3"
    placeholder="Email"
    value={email}
    onChange={(e)=>
    setEmail(e.target.value)}
    />

    <input
    type="password"
    className="form-control mb-3"
    placeholder="Password"
    value={password}
    onChange={(e)=>
    setPassword(e.target.value)}
    />

    <button
    className="btn btn-primary btn-auth"
    >
    Login
    </button>

    </form>

    <div className="auth-link">

    <a href="/register">
    Create Account
    </a>

    </div>

    </div>

    </div>

    </div>

    );
}

export default LoginPage;