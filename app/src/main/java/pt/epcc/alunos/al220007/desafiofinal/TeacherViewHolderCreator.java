package pt.epcc.alunos.al220007.desafiofinal;

import android.view.View;

import pt.epcc.alunos.al220007.desafiofinal.humancore.HumanViewHolderCreator;

public class TeacherViewHolderCreator implements HumanViewHolderCreator<TeacherViewHolder> {
	@Override
	public TeacherViewHolder createViewHolder(View view) {
		return new TeacherViewHolder(view);
	}
}
