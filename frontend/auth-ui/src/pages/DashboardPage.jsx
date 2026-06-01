import { useEffect, useState } from "react";
import { getCurrentUser } from "../services/authService";

function DashboardPage() {

  const [user, setUser] = useState("");

  useEffect(() => {
    loadUser();
  }, []);

  const loadUser = async () => {

    try {

      const response =
        await getCurrentUser();

      setUser(response);

    } catch (error) {

      console.error(error);

      localStorage.clear();

      window.location.href = "/";
    }
  };

  const logout = () => {

    localStorage.clear();

    window.location.href = "/";
  };

  return (

    <div className="container mt-5">

      <div className="card shadow-lg">

        <div className="card-header bg-primary text-white">

          <h2>
            UCE Health System
          </h2>

        </div>

        <div className="card-body">

          <h4>
            Dashboard
          </h4>

          <hr />

          <p>

            <strong>
              Email:
            </strong>

            {" "}
            {user}

          </p>

          <p>

            <strong>
              Role:
            </strong>

            {" "}
            {localStorage.getItem("role")}

          </p>

          <p>

            <strong>
              Status:
            </strong>

            {" "}
            Authenticated
          </p>

          <p>

            <strong>
              Environment:
            </strong>

            {" "}
            LOCAL
          </p>

          <button
            className="btn btn-danger"
            onClick={logout}
          >
            Logout
          </button>

        </div>

      </div>

    </div>
  );
}

export default DashboardPage;