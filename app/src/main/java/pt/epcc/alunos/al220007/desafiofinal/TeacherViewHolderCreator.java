package pt.epcc.alunos.al220007.desafiofinal;

import android.view.View;

public class TeacherViewHolderCreator implements HumanViewHolderCreator<TeacherViewHolder> {
	@Override
	public TeacherViewHolder createViewHolder(View view) {
		return new TeacherViewHolder(view);
	}
}
