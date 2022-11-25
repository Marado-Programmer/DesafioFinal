package pt.epcc.alunos.al220007.desafiofinal;

import android.content.Context;

import java.util.List;

import pt.epcc.alunos.al220007.desafiofinal.entities.Human;
import pt.epcc.alunos.al220007.desafiofinal.humancore.HumanAdapterCreator;

public class StudentAdapterCreator implements HumanAdapterCreator<StudentAdapter> {
	@Override
	public StudentAdapter createAdapter(List<? extends Human> list, Context context) {
		return new StudentAdapter(list, context);
	}
}
