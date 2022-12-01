package pt.epcc.alunos.al220007.desafiofinal.entities;

import androidx.annotation.NonNull;

public enum SchoolYear {
	FIRST, SECOND, THIRD;

	public int toInt() {
		switch (this) {
			case FIRST: return 1;
			case SECOND: return 2;
			case THIRD: return 3;
		}

		return 0;
	}

	@NonNull
	@Override
	public String toString() {
		return String.valueOf(toInt());
	}
}
