package com.reaper.projetomonstro.api.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "tb_treino")
public class Treino {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	@OneToMany(mappedBy = "treino")
	private List<ExercicioTreino> exercicioTreino;
	
	@JsonBackReference
	@ManyToMany(mappedBy = "treinos")
	private List<Composicao> composicoes;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<ExercicioTreino> getExercicioTreino() {
		return exercicioTreino;
	}
	public void setExercicioTreino(List<ExercicioTreino> exercicioTreino) {
		this.exercicioTreino = exercicioTreino;
	}

	public List<Composicao> getComposicoes() {
		return composicoes;
	}
	public void setComposicoes(List<Composicao> composicoes) {
		this.composicoes = composicoes;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Treino other = (Treino) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
