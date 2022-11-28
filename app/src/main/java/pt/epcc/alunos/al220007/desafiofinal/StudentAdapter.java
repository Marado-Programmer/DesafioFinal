package pt.epcc.alunos.al220007.desafiofinal;

import android.content.Context;
import android.view.View;


import java.util.List;

import pt.epcc.alunos.al220007.desafiofinal.entities.Human;
import pt.epcc.alunos.al220007.desafiofinal.humancore.HumanAdapter;

public class StudentAdapter extends HumanAdapter<StudentViewHolder> {

	public <E extends Human> StudentAdapter(List<E> list, Context context) {
		super(list, context);
	}

	@Override
	protected <E extends Human> void manage(StudentViewHolder holder, E human) {

	}

	@Override
	public StudentViewHolder createViewHolder(View view) {
		return new StudentViewHolder(view);
	}
}
