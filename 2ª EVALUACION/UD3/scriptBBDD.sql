CREATE DATABASE empresaDesarrolloSoftware;

SELECT * FROM proyecto;
DELETE FROM proyecto;

SELECT * FROM empleado;
DELETE FROM empleado;


DROP TABLE IF EXISTS empresaDesarrolloSoftware.proyecto CASCADE;
CREATE TABLE empresaDesarrolloSoftware.proyecto (

	nombreProyecto VARCHAR(60),
	duracion INT NOT NULL,
	fechaInicio DATE NOT NULL,
	fechaFin DATE,
	
	PRIMARY KEY (nombreProyecto)
);

DROP TABLE IF EXISTS empresaDesarrolloSoftware.empleado CASCADE;
CREATE TABLE empresaDesarrolloSoftware.empleado (

	dni VARCHAR(9),
	nombre VARCHAR(40) NOT NULL,
	apellidos VARCHAR(90) NOT NULL,
	telefono VARCHAR(9) NOT NULL,
	
	PRIMARY KEY (dni)
);

DROP TABLE IF EXISTS empresaDesarrolloSoftware.asignacionEmpleadoProyecto CASCADE;
CREATE TABLE empresaDesarrolloSoftware.asignacionProyecto (

	nombreProyecto VARCHAR(60),
	dni VARCHAR(9),

	PRIMARY KEY (nombreProyecto, dni),
	
	CONSTRAINT FK_asignacionEmpleadoProyecto_proyecto FOREIGN KEY (nombreProyecto) REFERENCES empresaDesarrolloSoftware.proyecto(nombreProyecto),
    CONSTRAINT FK_asignacionEmpleadoProyecto_empleado FOREIGN KEY (dni) REFERENCES empresaDesarrolloSoftware.empleado(dni)
);

DROP TABLE IF EXISTS empresaDesarrolloSoftware.tarea CASCADE;
CREATE TABLE empresaDesarrolloSoftware.tarea (

	nombreTarea VARCHAR(50),
	nombreProyecto VARCHAR(50),
	horasEstimadas INT NOT NULL,
	estado VARCHAR(50) NOT NULL,
	
	PRIMARY KEY (nombreTarea , nombreProyecto),
	
	CONSTRAINT FK_tarea_proyecto FOREIGN KEY (nombreProyecto) REFERENCES empresaDesarrolloSoftware.proyecto(nombreProyecto)
 );
 
DROP TABLE IF EXISTS empresaDesarrolloSoftware.asignacionEmpleadoTarea CASCADE;
CREATE TABLE empresaDesarrolloSoftware.asignacionTarea (

	nombreTarea VARCHAR(50),
   	nombreProyecto VARCHAR(50),
	dni VARCHAR(9),

	PRIMARY KEY (nombreTarea, dni, nombreProyecto),

	CONSTRAINT FK_asignacionEmpleadoTarea_empleado FOREIGN KEY (dni) REFERENCES empresaDesarrolloSoftware.empleado(dni),
    CONSTRAINT FK_asignacionEmpleadoTarea_proyecto_tarea FOREIGN KEY (nombreTarea, nombreProyecto) REFERENCES empresaDesarrolloSoftware.tarea(nombreTarea, nombreProyecto)
	
 );
 