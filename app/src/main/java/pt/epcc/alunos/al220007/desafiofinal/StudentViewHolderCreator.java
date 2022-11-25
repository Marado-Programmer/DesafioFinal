package pt.epcc.alunos.al220007.desafiofinal;

import android.view.View;

import pt.epcc.alunos.al220007.desafiofinal.humancore.HumanViewHolderCreator;

public class StudentViewHolderCreator implements HumanViewHolderCreator<StudentViewHolder> {
	@Override
	public StudentViewHolder createViewHolder(View view) {
		return new StudentViewHolder(view);
	}
}
