import axios from "axios";
import React, { useEffect, useState } from "react";

const ChefManagement = () => {
  const [chefs, setChefs] = useState([]);
  const [name, setName] = useState("");
  const [chefType, setChefType] = useState("");
  const [selectedChef, setSelectedChef] = useState(null); // 선택한 요리사 ID

  // 전체 Chef 조회
  const fetchChefs = async () => {
    try {
      const reponse = await axios.get("http://localhost:8080/chef");
      setChefs(reponse.data);
    } catch (error) {
      console.error("Error fetching chefs:", error);
    }
  };

  useEffect(() => {
    fetchChefs();
    console.log("useEffect@@@@" + chefs);
  }, []);

  // 요리사 추가
  const createChef = async () => {
    try {
      await axios.post("http://localhost:8080/chef", { name, chefType });
      // post 요청 후, 입력란 빈 문자열로 초기화
      setName("");
      setChefType("");
      // 추가 후, 다시 조회
      fetchChefs();
    } catch (error) {
      console.error("Error creating chef:", error);
    }
  };

  // Chef UPDATE
  const updateChef = async () => {
    try {
      await axios.put(`http://localhost:8080/chef/${selectedChef}`, {
        name,
        chefType,
      });
      setName("");
      setChefType("");
      setSelectedChef(null);
      fetchChefs();
    } catch (error) {
      console.error("Error updating chef:", error);
    }
  };

  // chef delete
  const deleteChef = async (id) => {
    try {
      await axios.delete(`http://localhost:8080/chef/${id}`);
      fetchChefs();
    } catch (error) {
      console.error("Error deleting chef:", error);
    }
  };

  return (
    <div>
      <h1>Chef Management</h1>

      <h2>Chef List</h2>
      <ul>
        {console.log("ul@@@@" + chefs)}
        {chefs.map((chef) => (
          <li key={chef.id}>
            {chef.name} - {chef.chefType} 요리사
            <button
              onClick={() => {
                setSelectedChef(chef.id);
                setName(chef.name); // 입력란에 이름을 세팅
                setChefType(chef.chefType); // 입력란에 타입을 세팅
              }}
            >
              Update
            </button>
            <button onClick={() => deleteChef(chef.id)}>Delete</button>
          </li>
        ))}
      </ul>

      <h2>{selectedChef ? "Update Chef" : "Add Chef"}</h2>
      <input
        type="text"
        placeholder="Name"
        value={name}
        onChange={(e) => setName(e.target.value)}
      />
      <input
        type="text"
        placeholder="Chef Type"
        value={chefType}
        onChange={(e) => setChefType(e.target.value)}
      />
      <button onClick={selectedChef ? updateChef : createChef}>
        {selectedChef ? "Update Chef" : "Add Chef"}
      </button>
    </div>
  );
};

export default ChefManagement;
