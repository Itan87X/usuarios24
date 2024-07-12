document.addEventListener("DOMContentLoaded", function() {
    const usuariosSection = document.getElementById("usuarios");
  
    function loadUsuariosList() {
      fetch("http://localhost:8080/usuarios24/users?action=getAll") 
        .then(response => response.json())
        .then(data => {
          data.forEach(usuario => {
            usuariosSection.innerHTML += `
              <tr>
                <td>${usuario.id}</td>
                <td>${usuario.nombre}</td>
                <td>${usuario.email}</td>
              </tr>
            `;
          });
        });
    }
    loadUsuariosList();
  });
  