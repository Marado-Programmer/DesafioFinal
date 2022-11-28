package pt.epcc.alunos.al220007.desafiofinal;

import android.content.Context;
import android.view.View;

import java.util.List;

import pt.epcc.alunos.al220007.desafiofinal.entities.Teacher;
import pt.epcc.alunos.al220007.desafiofinal.humancore.HumanAdapter;

public class TeacherAdapter extends HumanAdapter<Teacher, TeacherViewHolder> {

	public TeacherAdapter(List<Teacher> list, Context context) {
		super(list, context);
	}

	@Override
	protected LayoutManagerType getDefaultLayout() {
		return LayoutManagerType.GRID;
	}

	@Override
	public TeacherViewHolder createViewHolder(View view, Context context) {
		return new TeacherViewHolder(view, context);
	}
}
