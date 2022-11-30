package pt.epcc.alunos.al220007.desafiofinal.entities;

import android.os.Bundle;

import androidx.annotation.NonNull;

public final class Hobby implements Bundable {
	public static final String NAME_KEY = "name";

	protected String name;

	public Hobby(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@NonNull
	@Override
	public Bundle toBundle() {
		Bundle bundle = new Bundle();

		bundle.putString(NAME_KEY, name);

		return bundle;
	}
}
