package io.github.cepr0.demo;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class Model {
	
	@Id
	@SequenceGenerator(name="model_id_seq",sequenceName="model_id_seq", allocationSize=20)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="model_id_seq")
	private Long id;
	private String name;
	
	public Model(String name) {
		this.name = name;
	}
}
