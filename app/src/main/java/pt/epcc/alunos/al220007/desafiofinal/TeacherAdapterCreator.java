package pt.epcc.alunos.al220007.desafiofinal;

import android.content.Context;

import java.util.List;

import pt.epcc.alunos.al220007.desafiofinal.entities.Human;
import pt.epcc.alunos.al220007.desafiofinal.humancore.HumanAdapterCreator;

public class TeacherAdapterCreator implements HumanAdapterCreator<TeacherAdapter> {
	@Override
	public TeacherAdapter createAdapter(List<? extends Human> list, Context context) {
		return new TeacherAdapter(list, context);
	}
}
