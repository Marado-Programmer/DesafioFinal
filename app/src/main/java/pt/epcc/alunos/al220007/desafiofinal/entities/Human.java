package pt.epcc.alunos.al220007.desafiofinal.entities;

import android.os.Bundle;

import androidx.annotation.NonNull;

abstract public class Human implements Bundable {
	public static final String IMAGE_KEY = "pp";
	public static final String NAME_KEY = "name";

	private int image;
	private String name;

	public Human(int image, String name) {
		this.image = image;
		this.name = name;
	}

	protected Bundle getBaseBundle() {
		Bundle bundle = new Bundle();

		bundle.putInt(IMAGE_KEY, image);
		bundle.putString(NAME_KEY, name);

		return bundle;
	}

	public int getImage() {
		return image;
	}

	public String getName() {
		return name;
	}
}
