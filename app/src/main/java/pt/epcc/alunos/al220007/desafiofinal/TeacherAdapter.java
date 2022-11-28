package pt.epcc.alunos.al220007.desafiofinal;

import android.content.Context;
import android.view.View;

import java.util.List;

import pt.epcc.alunos.al220007.desafiofinal.entities.Human;
import pt.epcc.alunos.al220007.desafiofinal.entities.Teacher;
import pt.epcc.alunos.al220007.desafiofinal.humancore.HumanAdapter;
import pt.epcc.alunos.al220007.desafiofinal.humancore.HumanViewHolderCreator;

public class TeacherAdapter extends HumanAdapter<TeacherViewHolder> {

	public <E extends Human> TeacherAdapter(List<E> list, Context context) {
		super(list, context);
	}

	@Override
	protected <E extends Human> void manage(TeacherViewHolder holder, E human) {
		Teacher teacher = (Teacher) human;
		holder.school.setText("School: " + teacher.getSchool());
	}

	@Override
	public TeacherViewHolder createViewHolder(View view) {
		return new TeacherViewHolder(view);
	}
}
