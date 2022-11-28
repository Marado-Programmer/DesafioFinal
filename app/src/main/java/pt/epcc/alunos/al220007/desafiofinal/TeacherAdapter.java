package pt.epcc.alunos.al220007.desafiofinal;

import android.view.View;

import androidx.annotation.NonNull;

import pt.epcc.alunos.al220007.desafiofinal.entities.Teacher;
import pt.epcc.alunos.al220007.desafiofinal.humancore.HumanActivity;
import pt.epcc.alunos.al220007.desafiofinal.humancore.HumanAdapter;

public class TeacherAdapter extends HumanAdapter<Teacher, TeacherViewHolder> {
	public TeacherAdapter(HumanActivity<Teacher, HumanAdapter<Teacher, TeacherViewHolder>> context) {
		super(context);
	}

	@Override
	protected LayoutManagerType getDefaultLayout() {
		return LayoutManagerType.GRID;
	}

	@NonNull
	@Override
	public TeacherViewHolder createViewHolder(View view, HumanActivity context) {
		return new TeacherViewHolder(view, context);
	}
}
