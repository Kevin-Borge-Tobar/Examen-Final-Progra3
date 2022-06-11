package com.progra3.petstore.entities;

import com.progra3.petstore.dtos.PetDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pets")
public class Pet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pet")
	private Integer idPet;
	private String name;
	private Double price;
	@Column(name = "birth_day")
	@Temporal(TemporalType.DATE)
	private Date birthDay;
	//Se eliminaron los getters y setter porque se manejan por medio de la dependecia de Lombok

	public Boolean validPet(){
		Boolean isValid = true;
		if(this.name == null || this.name.isEmpty())
			isValid =false;
		if(this.price == null)
			isValid = false;
		if(this.birthDay == null)
			isValid = false;

			return isValid;
	}
}
