import { useEffect, useState } from "react";

import {
  getProfileByEmail,
  updateProfile
}
from "../services/userService";

function ProfilePage() {

  const [profileId, setProfileId] =
    useState(null);

  const [loading, setLoading] =
    useState(true);

  const [formData, setFormData] =
    useState({

      firstName: "",
      lastName: "",
      phone: "",
      faculty: "",
      career: "",
      gender: "",
      birthDate: "",
      photoUrl: ""

    });

  useEffect(() => {

    const loadProfile =
      async () => {

        try {

          const email =
            localStorage.getItem(
              "email"
            );

          const profile =
            await getProfileByEmail(
              email
            );

          setProfileId(
            profile.id
          );

          setFormData({

            firstName:
              profile.firstName || "",

            lastName:
              profile.lastName || "",

            phone:
              profile.phone || "",

            faculty:
              profile.faculty || "",

            career:
              profile.career || "",

            gender:
              profile.gender || "",

            birthDate:
              profile.birthDate || "",

            photoUrl:
              profile.photoUrl || ""

          });

        } catch (error) {

          console.error(
            "Error loading profile:",
            error
          );

          alert(
            "Could not load profile"
          );

        } finally {

          setLoading(false);
        }
      };

    loadProfile();

  }, []);

  const handleChange = (e) => {

    setFormData({

      ...formData,

      [e.target.name]:
        e.target.value

    });
  };

  const handleSubmit =
    async (e) => {

      e.preventDefault();

      try {

        await updateProfile(
          profileId,
          formData
        );

        alert(
          "Profile updated successfully"
        );

      } catch (error) {

        console.error(error);

        alert(
          "Error updating profile"
        );
      }
    };

  if (loading) {

    return (

      <div
        className="
          d-flex
          justify-content-center
          align-items-center
          vh-100
        "
      >
        Loading profile...
      </div>

    );
  }

  return (

    <div className="container mt-5">

      <div className="card p-4 shadow">

        <h2
          className="text-center mb-4"
        >
          My Profile
        </h2>

        <form
          onSubmit={
            handleSubmit
          }
        >

          <input
            className="form-control mb-2"
            placeholder="First Name"
            name="firstName"
            value={formData.firstName}
            onChange={handleChange}
          />

          <input
            className="form-control mb-2"
            placeholder="Last Name"
            name="lastName"
            value={formData.lastName}
            onChange={handleChange}
          />

          <input
            className="form-control mb-2"
            placeholder="Phone"
            name="phone"
            value={formData.phone}
            onChange={handleChange}
          />

          <input
            className="form-control mb-2"
            placeholder="Faculty"
            name="faculty"
            value={formData.faculty}
            onChange={handleChange}
          />

          <input
            className="form-control mb-2"
            placeholder="Career"
            name="career"
            value={formData.career}
            onChange={handleChange}
          />

          <input
            className="form-control mb-2"
            placeholder="Gender"
            name="gender"
            value={formData.gender}
            onChange={handleChange}
          />

          <input
            className="form-control mb-3"
            type="date"
            name="birthDate"
            value={formData.birthDate}
            onChange={handleChange}
          />

          <button
            className="
              btn
              btn-primary
              w-100
            "
          >
            Save Profile
          </button>

        </form>

      </div>

    </div>
  );
}

export default ProfilePage;