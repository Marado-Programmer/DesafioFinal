package pt.epcc.alunos.al220007.desafiofinal.entities;

abstract public class Human {
	private int image;
	private String name;

	public Human(int image, String name) {
		this.image = image;
		this.name = name;
	}

	public int getImage() {
		return this.image;
	}

	public String getName() {
		return this.name;
	}
}
