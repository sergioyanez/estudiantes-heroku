 "use strict";
 document.addEventListener("DOMContentLoaded",function(){

//Inscribir  un estudiante a una carrera

let btnMatricular = document.querySelector("#btnMatricular");
btnMatricular.addEventListener("click",matricularEstudianteEnCarrera);

function matricularEstudianteEnCarrera(){
	// let url = "http://localhost:9000/estudiante/carrera/";
	let url = "https://demo-estudiantes-spring.herokuapp.com/estudiante/carrera/";
	let estudiante = document.getElementById("idEstudiante").value;
	let carrera = document.getElementById("idCarrera").value;
		let estudCarr = {
	      "fk_estudiante": estudiante,
		  "fk_carrera": carrera
	};
	matricularEstudiante(estudCarr,url);
}

async function matricularEstudiante(estudCarr,url){
	let contenedor = document.getElementById("estudCarrera");

	let nuevo = JSON.stringify(estudCarr);
	let r = await fetch(url+estudCarr.fk_estudiante+"/"+estudCarr.fk_carrera, {
								  method: "POST",
							      headers: { "Content-Type": "application/json" },
							      body: nuevo,
								});
	if(r.ok){
		let json = await r.text();
		contenedor.innerHTML = "Se matriculó el estudiante  en la carrera ";
	
	}
	else{
		 contenedor.innerHTML =  contenedor.innerHTML = "No se pudo matricular el estudiante en la carrera. Revise los datos e ingrese nuevamente";
		
	}
}

//Dar de alta un estudiante nuevo
let btnAlta =document.querySelector("#btnAltaEst");
btnAlta.addEventListener("click",agregarEstudiante);

function agregarEstudiante(){
	// let url = "http://localhost:9000/estudiantes/alta";
	let url = "https://demo-estudiantes-spring.herokuapp.com/estudiantes/alta";
	let dni = document.getElementById("dni").value;
	let nombre = document.getElementById("nombre").value;
	let apellido = document.getElementById("apellido").value;
	let edad = document.getElementById("edad").value;
	let genero = document.getElementById("generoE").value;
	let ciudad = document.getElementById("ciudadE").value;
	let lu = document.getElementById("lu").value;
			let estudiante = {
	      "dni": dni,
		  "nombre": nombre,
		  "apellido": apellido,
		  "edad": edad,
	      "genero": genero,
		  "ciudad": ciudad,
		  "lu": lu,
	};
	altaEstudiante(estudiante,url);
}

 async function altaEstudiante(estudiante,url){
	
	let contenedor = document.getElementById("contenedorInsert");

	let nuevo = JSON.stringify(estudiante);
	console.log(nuevo);
	let r = await fetch(url, {
								  method: "POST",
							      headers: { "Content-Type": "application/json" },
							      body: nuevo,
								});
	if(r.ok){
		let json = await r.text();
		 contenedor.innerHTML = "Se ha dado de alta al estudiante con exito";
	
	}
	else{
		 contenedor.innerHTML = "No se ha podido dar de alta al estudiante, revise los datos ingresados e intente nuevamente";
		
	}
	
}
//Obtiene un estudiante por LU elegida
let btnLuEstudiante =document.querySelector("#btnLuEstudiante");
btnLuEstudiante.addEventListener("click",traerEstudiantePorLU);

function traerEstudiantePorLU() {
	let lu = document.getElementById("LU").value;
	// let url = "http://localhost:9000/estudiantes/lu/";
	let url = "https://demo-estudiantes-spring.herokuapp.com/estudiantes/lu/";
	estudiantePorLU(lu,url);
}

	 async function estudiantePorLU(lu, url) {
		 let contenedor = document.getElementById("resultadoLU");
		 try {
			 let r = await fetch(url + lu, {
				 method: "GET",
				 mode: 'cors'
			 })
			 if (r.ok) {
				 let json = await r.json();
				  contenedor.innerHTML = JSON.stringify(json, undefined, 2);				
			 }
			 else{
				contenedor.innerHTML = "No existe el estudiante con la LU = "+lu;
			}
			  
		 }
		 catch (e) {
			 contenedor.innerHTML = "No existe el estudiante con la LU = "+lu;

		 }
	 }
           


//Obtiene los estudiantes por el género elegido 
let btnGenero =document.querySelector("#btnGenero");
btnGenero.addEventListener("click",traerEstudiantePorGenero);

function traerEstudiantePorGenero(){
	let genero = document.getElementById("genero").value;
	// let url = "http://localhost:9000/estudiantes/por/genero/";
	let url = "https://demo-estudiantes-spring.herokuapp.com/estudiantes/por/genero/";
	estudiantePorGenero(genero,url);
}
 
async function estudiantePorGenero(genero,url){
	let contenedor = document.getElementById("resultadoGenero");
	try {
			 let r = await fetch(url + genero, {
				 method: "GET",
				 mode: 'cors'
			 })
			 if (r.ok) {
				 let json = await r.json();
				  contenedor.innerHTML = JSON.stringify(json, undefined, 2);				
			 }
			 else{
				contenedor.innerHTML = "No se han encontrado estudiantes con el genero " + genero;
			}
			  
		 }
		 catch (e) {
			 contenedor.innerHTML = "No se han encontrado estudiantes con el genero " + genero;

		 }
}




//Obtiene los estudiantes que vayan a una carrera seleccionada y esten en una ciudad seleccionada
let btnCarrCiu =document.querySelector("#btnCarCiu");
btnCarrCiu.addEventListener("click",traerEstudiantePorCarreraCiudad);

function traerEstudiantePorCarreraCiudad(){
		let carrera = document.getElementById("carrera").value;
	let ciudad = document.getElementById("ciudad").value;
	// let url = "http://localhost:9000/estudiantes/carrera/ciudad/";
	let url = "https://demo-estudiantes-spring.herokuapp.com/estudiantes/carrera/ciudad/";
	estudiantePorCarreraPorCiudad(carrera,ciudad,url);
	
}
 
async function estudiantePorCarreraPorCiudad(carrera,ciudad,url){
	let contenedor = document.getElementById("carreraCiudad");
	try {
			 let r = await fetch(url + carrera + "/" + ciudad, {
				 method: "GET",
				 mode: 'cors'
			 })
			 if (r.ok) {
				 let json = await r.json();
				  contenedor.innerHTML = JSON.stringify(json, undefined, 2);				
			 }
			 else{
				contenedor.innerHTML = "No existen estudiantes de la carrera " + carrera + " de la ciudad " + ciudad;
			}
			  
		 }
		 catch (e) {
			 contenedor.innerHTML = "No existen estudiantes de la carrera  " + carrera + " de la ciudad " + ciudad;

		 }
}
})

