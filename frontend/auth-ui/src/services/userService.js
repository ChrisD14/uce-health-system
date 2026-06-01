import axios from "axios";

const API_URL = "/api/users";

export const getAllProfiles = async () => {

  const response =
    await axios.get(API_URL);

  return response.data;
};

export const getProfileById = async (id) => {

  const response =
    await axios.get(
      `${API_URL}/${id}`
    );

  return response.data;
};

export const updateProfile =
  async (id, data) => {

    try {

      console.log(
        "Sending profile:",
        data
      );

      const response =
        await axios.put(
          `${API_URL}/${id}`,
          data
        );

      console.log(
        "Response:",
        response.data
      );

      return response.data;

    } catch (error) {

      console.error(
        "UPDATE ERROR:",
        error
      );

      console.error(
        "RESPONSE:",
        error.response
      );

      throw error;
    }
    
};

export const getProfileByEmail =
  async (email) => {

    const response =
      await axios.get(
        `${API_URL}/email/${email}`
      );

    return response.data;
};