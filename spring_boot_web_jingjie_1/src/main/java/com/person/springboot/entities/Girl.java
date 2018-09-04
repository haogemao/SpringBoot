package com.person.springboot.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Girl {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@NotBlank(message="资格字段必传")
	private String cupSize;
	
	@Min(value = 18, message="未成年少女禁止入内")
	private Integer age;
	
	@NotNull(message="金额必传")
	private Double money;

	public Girl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Girl(@NotBlank(message = "资格字段必传") String cupSize, @Min(value = 18, message = "未成年少女禁止入内") Integer age) {
		super();
		this.cupSize = cupSize;
		this.age = age;
	}

	public Girl(@NotBlank(message = "资格字段必传") String cupSize, @Min(value = 18, message = "未成年少女禁止入内") Integer age,
			@NotNull(message = "金额必传") Double money) {
		super();
		this.cupSize = cupSize;
		this.age = age;
		this.money = money;
	}

	public Girl(Integer id, @NotBlank(message = "资格字段必传") String cupSize,
			@Min(value = 18, message = "未成年少女禁止入内") Integer age, @NotNull(message = "金额必传") Double money) {
		super();
		this.id = id;
		this.cupSize = cupSize;
		this.age = age;
		this.money = money;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCupSize() {
		return cupSize;
	}

	public void setCupSize(String cupSize) {
		this.cupSize = cupSize;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}
}
