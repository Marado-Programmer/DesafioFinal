package pt.epcc.alunos.al220007.desafiofinal.entities;

import android.os.Bundle;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Student extends Human {
	public static final String HOBBIES_KEY = "hobbies";

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

	@NonNull
	@Override
	public Bundle toBundle() {
		Bundle bundle = getBaseBundle();

		List<String> list = new ArrayList<>();
		for (Hobby hobby : hobbies) {
			String name = hobby.getName();
			list.add(name);
		}

		bundle.putStringArrayList(HOBBIES_KEY, (ArrayList<String>) list);

		return bundle;
	}
}
