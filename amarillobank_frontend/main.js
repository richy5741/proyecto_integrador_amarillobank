const btn = document.getElementById("btnCrear");

btn.addEventListener("click", async () => {
  

  const cedulaInput = document.getElementById("cedula");
  const nombreInput = document.getElementById("nombre");

  if (cedulaInput.value.trim() === "" || nombreInput.value.trim() === "") {
    alert("Llena cedula y nombre");
    return;
  }

  const datos = {
    cedula: cedulaInput.value,
    nombre: nombreInput.value
  };

  console.log("Enviando al Handler:", datos);

  try {
  
    const res = await fetch("http://localhost:8080/api/clientes", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(datos)
    });

    if (res.ok) {
      alert("Cliente agragado AmarilloBank");
      
    } else {
      alert("Error del backend");
    }

  } catch (e) {
    console.error(e);
    alert("No conecta con el backend. ¿Corriste el Main en IntelliJ?");
  }
});