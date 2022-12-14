package com.springboot.moridosSAdeCV.entity;

import javax.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="moridos")
public class Morido {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="apellidos")
	private String apellidos;
	
	@Column(name="edad")
	private int edad;
	
	@Column(name="fecha_moricion")
	private String fechaMoricion;
	
	@Column(name="hora_moricion")
	private String horaMoricion;
	
	@Column(name="lugar_moricion")
	private String lugarMoricion;
	
	@Column(name="causa_moricion")
	private String causaMoricion;
	
}
