package com.example.kafkaDocker.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "kafkaRequest")
public class KafkaRequest {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String data;

	private Integer coun;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Integer getCoun() {
		return coun;
	}

	public void setCoun(Integer coun) {
		this.coun = coun;
	}

	@Override
	public String toString() {
		return "KafkaRequest [id=" + id + ", data=" + data + ", coun=" + coun + "]";
	}
	
	
}
