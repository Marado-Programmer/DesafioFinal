package pt.epcc.alunos.al220007.desafiofinal.entities;

import java.util.ArrayList;
import java.util.List;

public class Student extends Human {
	private final List<Hobby> hobbies;

	public Student(int image, String name) {
		super(image, name);
		this.hobbies = new ArrayList<>();
	}

	public void addHobby(Hobby hobby) {
		this.hobbies.add(hobby);
	}

	public List<Hobby> getHobbies() {
		return this.hobbies;
	}
}
