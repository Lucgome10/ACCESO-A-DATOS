package practicaEv1;

import java.io.File;
import java.io.IOException;

public class ObjetoDestino {
	
	private File ruta;
	private File clientes;
	private File empleados;
	private File productos;
	private File proveedores;
	private File sucursales;
	private File registro;
	
	
	public ObjetoDestino(String rutaDestino) throws IOException {
		this.ruta = new File(rutaDestino);
		ruta.mkdir();
		this.clientes = new File(rutaDestino + "\\Clientes");
		clientes.mkdir();
		this.empleados = new File(rutaDestino + "\\Empleados");
		empleados.mkdir();
		this.productos = new File(rutaDestino + "\\Productos");
		productos.mkdir();
		this.proveedores = new File(rutaDestino + "\\Proveedores");
		proveedores.mkdir();
		this.sucursales = new File(rutaDestino + "\\Sucursales");
		sucursales.mkdir();
		this.registro = new File(rutaDestino + "\\registro.txt");
		registro.createNewFile();
	}

	
	public File getRuta() {
		return ruta;
	}

	public void setRuta(File ruta) {
		this.ruta = ruta;
	}

	public File getClientes() {
		return clientes;
	}

	public void setClientes(File clientes) {
		this.clientes = clientes;
	}

	public File getEmpleados() {
		return empleados;
	}

	public void setEmpleados(File empleados) {
		this.empleados = empleados;
	}

	public File getProductos() {
		return productos;
	}

	public void setProductos(File productos) {
		this.productos = productos;
	}

	public File getProveedores() {
		return proveedores;
	}

	public void setProveedores(File proveedores) {
		this.proveedores = proveedores;
	}

	public File getSucursales() {
		return sucursales;
	}

	public void setSucursales(File sucursales) {
		this.sucursales = sucursales;
	}

	public File getRegistro() {
		return registro;
	}

	public void setRegistro(File registro) {
		this.registro = registro;
	}
	
	
	
	
	
	
	

}
