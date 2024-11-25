package com.hlc.dependencia_web.controlador;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class PruebaControlador {

	// Funcion
	private int suma(int a, int b) {
		return a + b;
	}

	@GetMapping("/funcion")
	public int funcion() {
		// Uso de funciones
		return suma(5, 3);
	}

	@GetMapping("/decision")
	public String decision(@RequestParam int number) {
		// Mecanismos de decision
		if (number < 10) {
			return "El número " + number + " es menor que 10";
		} else {
			return "El número " + number + " es mayor o igual a 10";
		}
	}

	@PostMapping("*formulario")
	public String formulario(
	@RequestParam String nombre,
	@RequestParam int edad,
	@RequestParam String color)
	{
		String mensaje = edad >= 18 ? "Mayor de edad" : "Menor de edad";
		
		//Construir la respuesta incluyendo el color seleccionado
		return String.format("<h1>Hola, %s. Tienes %d años, eres %s y seleccionaste el color %s.</h1>", nombre, edad, mensaje, color);
		
	}

}
