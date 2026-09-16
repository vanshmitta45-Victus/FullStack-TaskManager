import React, { useState, useEffect } from 'react';
import axios from 'axios';
import './App.css';

const API_URL = "http://localhost:8080/api/tasks";

function App() {
  const [tasks, setTasks] = useState([]); // State to store our list of tasks
  const [title, setTitle] = useState('');   // State for the input field
  const [description, setDescription] = useState('');

  // 1. Fetch all tasks from Backend when the page loads
  useEffect(() => {
    fetchTasks();
  }, []);

  const fetchTasks = async () => {
    try {
      const response = await axios.get(API_URL);
      setTasks(response.data);
    } catch (error) {
      console.error("Error fetching tasks:", error);
    }
  };

  // 2. Send a new task to the Backend
  const addTask = async (e) => {
  e.preventDefault();
  try {
    const newTask = { title, description, status: 'TODO', priority: 'MEDIUM' };
    await axios.post(API_URL, newTask); // 1. Send to backend
    
    setTitle('');
    setDescription('');
    
    // IMPORTANT: This line tells React to go back to the server 
    // and get the updated list so the UI refreshes!
    await fetchTasks(); 
    
  } catch (error) {
    console.error("Error adding task:", error);
  }
 };
  // 3. Delete a task
  const deleteTask = async (id) => {
    try {
      await axios.delete(`${API_URL}/${id}`);
      fetchTasks(); // Refresh the list
    } catch (error) {
      console.error("Error deleting task:", error);
    }
  };

  return (
    <div className="app-container">
      <h1>Task Manager</h1>
      
      <form onSubmit={addTask} className="task-form">
        <input 
          value={title} 
          onChange={(e) => setTitle(e.target.value)} 
          placeholder="Task Title" required 
        />
        <input 
          value={description} 
          onChange={(e) => setDescription(e.target.value)} 
          placeholder="Description" 
        />
        <button type="submit">Add Task</button>
      </form>

      <div className="task-list">
        {tasks.map(task => (
          <div key={task.id} className="task-card">
            <h3>{task.title}</h3>
            <p>{task.description}</p>
            <span className="status-badge">{task.status}</span>
            <button onClick={() => deleteTask(task.id)} className="delete-btn">Delete</button>
          </div>
        ))}
      </div>
    </div>
  );
}

export default App;
