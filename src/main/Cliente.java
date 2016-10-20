package main;


public class Cliente {
	private int id, age;
	private String  rg, cpf, name, address, login;
	
	public Cliente(int id, int age, String rg, String cpf, String name, String address, String login) {
		this.id = id;
		this.age = age;
		this.rg = rg;
		this.cpf = cpf;
		this.name = name;
		this.address = address;
		this.login = login;
	}
	public int getId() {
		return id;
	}
	public int getAge() {
		return age;
	}
	public String getRg() {
		return rg;
	}
	public String getCpf() {
		return cpf;
	}
	public String getName() {
		return name;
	}
	public String getAddress() {
		return address;
	}
	public String getLogin() {
		return login;
	}
}