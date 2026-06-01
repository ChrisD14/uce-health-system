import axios from "axios";

const API_URL =
  "http://localhost:8081/api/auth";

export const registerUser = async (data) => {

  const response =
    await axios.post(
      `${API_URL}/register`,
      data
    );

  return response.data;
};

export const loginUser = async (data) => {

  const response =
    await axios.post(
      `${API_URL}/login`,
      data
    );

  return response.data;
};

export const getCurrentUser = async () => {

  const token =
    localStorage.getItem(
      "accessToken"
    );

  const response =
    await axios.get(
      `${API_URL}/me`,
      {
        headers: {
          Authorization:
            `Bearer ${token}`
        }
      }
    );

  return response.data;
};