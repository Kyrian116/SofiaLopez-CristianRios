// Manejador del botón de login/logout
function toggleLogin() {
  const loginBtn = document.querySelector("#loginBtn");

  // Verificar si el usuario está autenticado
  const token = localStorage.getItem("token");
  if (token) {
    // Si el usuario está autenticado, cambiar el botón a "Logout"
    loginBtn.textContent = "Logout";
    loginBtn.onclick = logout;
  } else {
    // Si el usuario no está autenticado, cambiar el botón a "Login"
    loginBtn.textContent = "Login";
    loginBtn.onclick = login;
  }
}

// Función para hacer login
function login() {
  const username = document.querySelector("#usernameInput").value;
  const password = document.querySelector("#passwordInput").value;

  // Hacer petición POST al backend para autenticar al usuario
  fetch("/login", {
    method: "POST",
    body: JSON.stringify({ username, password }),
    headers: { "Content-Type": "application/json" }
  })
  .then(response => response.json())
  .then(data => {
    // Almacenar el token de autenticación en el almacenamiento local
    localStorage.setItem("token", data.token);

    // Cambiar el botón a "Logout"
    toggleLogin();
  })
  .catch(error => console.error(error));
}

// Función para hacer logout
function logout() {
  // Invalidar el token de autenticación
  localStorage.removeItem("token");

  // Redirigir al usuario a la página de inicio
  window.location.href = "/";
}
