package pt.epcc.alunos.al220007.desafiofinal;

import android.view.View;

import androidx.annotation.NonNull;

import pt.epcc.alunos.al220007.desafiofinal.entities.Teacher;
import pt.epcc.alunos.al220007.desafiofinal.humancore.Adapter;
import pt.epcc.alunos.al220007.desafiofinal.humancore.activities.HumanActivity;

public class TeacherAdapter extends Adapter<Teacher, TeacherViewHolder, TeacherExtraBuilder> {
	public TeacherAdapter(HumanActivity<Teacher, TeacherExtraBuilder, ? extends Adapter<Teacher, TeacherViewHolder, TeacherExtraBuilder>> ctx) {
		super(ctx);
	}

	@Override
	protected void createExtraDetails(TeacherExtraBuilder builder) {
		builder.start();
		builder.setSchool();
	}

	@Override
	protected LayoutManagerType defaultLayout() {
		return LayoutManagerType.GRID;
	}

	@NonNull
	@Override
	public TeacherViewHolder createViewHolder(View view, HumanActivity<Teacher, TeacherExtraBuilder, ? extends Adapter<Teacher, TeacherViewHolder, TeacherExtraBuilder>> ctx) {
		return new TeacherViewHolder(view, ctx);
	}
}
