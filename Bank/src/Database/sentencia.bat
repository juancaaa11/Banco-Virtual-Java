@echo off
setlocal

REM Definir la ubicación del cliente de MySQL
set MYSQL_HOME="C:\xampp\mysql\bin"

REM Obtener la ubicación actual del archivo por lotes
set SCRIPT_PATH=%~dp0

REM Definir el archivo SQL a ejecutar (banl.sql en este caso)
set SQL_FILE=%SCRIPT_PATH%bank.sql

REM Definir las credenciales de MySQL
set MYSQL_USER=root

REM Definir el archivo PHP a copiar
set PHP_FILE=%SCRIPT_PATH%contacto.php
set DEST_PATH="C:\xampp\htdocs"

REM Ejecutar el script SQL para crear la base de datos y las tablas
echo Ejecutando el script SQL...
%MYSQL_HOME%\mysql -u %MYSQL_USER% -p < %SQL_FILE%

REM Verificar si ocurrieron errores durante la ejecución del script SQL
if %errorlevel% neq 0 (
    echo Error: No se pudo ejecutar el script SQL.
    exit /b %errorlevel%
) else (
    echo El script SQL se ejecutó correctamente.
)

REM Copiar el archivo PHP a la carpeta de destino
echo Copiando el archivo PHP a %DEST_PATH%...
copy %PHP_FILE% %DEST_PATH%

REM Verificar si ocurrió un error durante la copia del archivo PHP
if %errorlevel% neq 0 (
    echo Error: No se pudo copiar el archivo PHP.
    exit /b %errorlevel%
) else (
    echo El archivo PHP se copió correctamente.
)

pause
