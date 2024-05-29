<?php

header("Access-Control-Allow-Origin: *");
header("Access-Control-Allow-Methods: POST");
header("Access-Control-Allow-Headers: Content-Type");
header("Content-Type: application/json; charset=UTF-8");

$servername = "localhost";
$username = "user";
$password = "userbank";
$dbname = "bank";

// Crear conexión
$conn = new mysqli($servername, $username, $password, $dbname);

// Verificar conexión
if ($conn->connect_error) {
    http_response_code(500);
    echo json_encode(array("message" => "Conexión fallida: " . $conn->connect_error));
    exit();
}

// Obtener los datos del formulario
$correo_electronico = $_POST['correo_electronico'];
$mensaje = $_POST['mensaje'];

// Preparar y ejecutar la consulta SQL para insertar los datos en la tabla
$sql = "INSERT INTO contacto (correo_electronico, mensaje) VALUES (?, ?)";
$stmt = $conn->prepare($sql);
$stmt->bind_param("ss", $correo_electronico, $mensaje);

if ($stmt->execute()) {
    http_response_code(200);
    echo json_encode(array("message" => "Mensaje enviado correctamente."));
} else {
    http_response_code(500);
    echo json_encode(array("message" => "Error: " . $sql . "<br>" . $conn->error));
}

// Cerrar conexión
$stmt->close();
$conn->close();
?>
