@echo off
setlocal

REM Definir la ubicación del cliente de MySQL (ajustar según sea necesario)
set MYSQL_HOME="C:\xampp\mysql\bin"

REM Definir las credenciales de MySQL
set MYSQL_USER=root


REM Obtener la ubicación actual del archivo por lotes
set SCRIPT_PATH=%~dp0

REM Definir el archivo SQL a ejecutar (bank.sql en este caso)
set SQL_FILE=%SCRIPT_PATH%src\Database\bank.sql

REM Definir el archivo PHP a copiar
set PHP_FILE=%SCRIPT_PATH%src\Database\contacto.php

REM Definir el destino del archivo PHP
set PHP_DEST="C:\xampp\htdocs\contacto.php"


echo Iniciando la configuración...

REM Verificar que el cliente de MySQL existe
if not exist "%MYSQL_HOME%\mysql.exe" (
    echo Error: No se encontró el cliente de MySQL en %MYSQL_HOME%.
    pause
    exit /b 1
)

REM Verificar que el archivo SQL existe
if not exist "%SQL_FILE%" (
    echo Error: No se encontró el archivo SQL en %SQL_FILE%.
    pause
    exit /b 1
)

REM Verificar que el archivo PHP existe
if not exist "%PHP_FILE%" (
    echo Error: No se encontró el archivo PHP en %PHP_FILE%.
    pause
    exit /b 1
)

REM Crear la base de datos y las tablas
echo Ejecutando el script SQL para crear la base de datos y las tablas...
"%MYSQL_HOME%\mysql" -u %MYSQL_USER% -p < "%SQL_FILE%"
if %errorlevel% neq 0 (
    echo Error: No se pudo ejecutar el script SQL.
    pause
    exit /b 1
)

echo Script SQL ejecutado correctamente.

REM Copiar el archivo PHP
echo Copiando el archivo PHP a %PHP_DEST%...
copy "%PHP_FILE%" %PHP_DEST%
if %errorlevel% neq 0 (
    echo Error: No se pudo copiar el archivo PHP.
    pause
    exit /b 1
)

echo Archivo PHP copiado correctamente.


echo Configuración completada.
pause
