// main.js - en la raiz de amarillobank_frontend
const API_URL = "http://localhost:8080/api/clientes";

const btn = document.getElementById("btnCrear");

if (btn) {
  btn.addEventListener("click", async () => {
    const datos = {
      cedula: document.getElementById("cedula").value,
      nombre: document.getElementById("nombre").value
    };

    console.log("Enviando a backend:", datos);

    try {
      const res = await fetch(API_URL, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(datos)
      });

      const respuesta = await res.json();
      console.log("Backend respondió:", respuesta);
      alert("¡Cuenta creada! Ya está en MySQL");
      window.location.href = "login.html";

    } catch (error) {
      console.error(error);
      alert("No se pudo conectar al backend. ¿Dejaste IntelliJ corriendo?");
    }
  });
}