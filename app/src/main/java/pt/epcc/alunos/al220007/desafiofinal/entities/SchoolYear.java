package pt.epcc.alunos.al220007.desafiofinal.entities;

import androidx.annotation.NonNull;

public enum SchoolYear {
	FIRST(1), SECOND(2), THIRD(3);

	private final int year;

	SchoolYear(int i) {
		year = i;
	}

	@NonNull
	@Override
	public String toString() {
		return String.valueOf(year);
	}
}
