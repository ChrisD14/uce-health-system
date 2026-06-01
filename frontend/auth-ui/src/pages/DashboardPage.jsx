import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";

import { getCurrentUser } from "../services/authService";

function DashboardPage() {

  const [user, setUser] = useState(null);

  const navigate = useNavigate();

  useEffect(() => {

    const loadUser = async () => {

      try {

        const data =
          await getCurrentUser();

        setUser(data);

      } catch (error) {

        console.error(error);

        localStorage.removeItem(
          "accessToken"
        );

        navigate("/");
      }
    };

    loadUser();

  }, [navigate]);

  const handleLogout = () => {

    localStorage.removeItem(
      "accessToken"
    );

    navigate("/");
  };

  if (!user) {

    return (

      <div
        className="
          d-flex
          justify-content-center
          align-items-center
          vh-100
        "
      >
        Loading...
      </div>

    );
  }

  return (

    <div
      className="
        d-flex
        justify-content-center
        align-items-center
        vh-100
      "
      style={{
        background:
          "linear-gradient(135deg,#2563eb,#3b82f6)"
      }}
    >

      <div
        className="card shadow p-4"
        style={{
          width: "700px"
        }}
      >

        <h2
          className="text-center mb-4"
        >
          UCE Dashboard
        </h2>

        <hr />

        <div className="text-center">

          <h5>
            Authenticated User
          </h5>

          <p>
            <strong>Email:</strong>{" "}
            {user}
          </p>

        </div>

        <div
          className="
            d-flex
            justify-content-center
            gap-3
            mt-4
          "
        >

          <button
            className="
              btn
              btn-success
            "
            onClick={() =>
              navigate("/profile")
            }
          >
            My Profile
          </button>

          <button
            className="
              btn
              btn-danger
            "
            onClick={
              handleLogout
            }
          >
            Logout
          </button>

        </div>

      </div>

    </div>

  );
}

export default DashboardPage;