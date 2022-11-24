package pt.epcc.alunos.al220007.desafiofinal;

import android.content.Context;

import java.util.List;

public class TeacherAdapterCreator implements HumanAdapterCreator<TeacherAdapter> {
	@Override
	public TeacherAdapter createAdapter(List<? extends Human> list, Context context) {
		return new TeacherAdapter(list, context);
	}
}
