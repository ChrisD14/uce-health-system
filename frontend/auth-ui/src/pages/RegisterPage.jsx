import { useState } from "react";
import { registerUser } from "../services/authService";

function RegisterPage() {

  const [email, setEmail] =
    useState("");

  const [password, setPassword] =
    useState("");

  const handleSubmit = async (e) => {

    e.preventDefault();

    try {

      await registerUser({
        email,
        password
      });

      alert(
        "Account created successfully"
        );

        window.location.href =
        "/";

    } catch (error) {

    console.log(error);

    alert(
        error.response?.data?.message ||
        error.message
    );
    }
  };

  return (

    <div className="container mt-5">

      <div className="row justify-content-center">

        <div className="col-md-5">

          <div className="card shadow">

            <div className="card-body">

              <h2 className="text-center mb-4">
                Register User
              </h2>

              <form
                onSubmit={handleSubmit}
              >

                <input
                  className="form-control mb-3"
                  placeholder="Email"
                  value={email}
                  onChange={(e) =>
                    setEmail(
                      e.target.value
                    )
                  }
                />

                <input
                  type="password"
                  className="form-control mb-3"
                  placeholder="Password"
                  value={password}
                  onChange={(e) =>
                    setPassword(
                      e.target.value
                    )
                  }
                />

                <button
                  className="btn btn-success w-100"
                >
                  Register
                </button>

              </form>

            </div>

          </div>

        </div>

      </div>

      <h1>Register</h1>
      <a href="/">
        Back to Login
        </a>

    </div>
  );
}

export default RegisterPage;