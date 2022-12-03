package pt.epcc.alunos.al220007.desafiofinal;

import android.view.View;

import androidx.annotation.NonNull;

import pt.epcc.alunos.al220007.desafiofinal.entities.Student;
import pt.epcc.alunos.al220007.desafiofinal.humancore.Adapter;
import pt.epcc.alunos.al220007.desafiofinal.humancore.activities.HumanActivity;

public class StudentAdapter extends Adapter<Student, StudentViewHolder, StudentExtraBuilder> {
	public StudentAdapter(HumanActivity<Student, StudentExtraBuilder, ? extends Adapter<Student, StudentViewHolder, StudentExtraBuilder>> ctx) {
		super(ctx);
	}

	@Override
	protected void createExtraDetails(StudentExtraBuilder builder) {
	}

	@Override
	protected LayoutManagerType defaultLayout() {
		return LayoutManagerType.LINEAR;
	}

	@NonNull
	@Override
	public StudentViewHolder createViewHolder(View view, HumanActivity<Student, StudentExtraBuilder, ? extends Adapter<Student, StudentViewHolder, StudentExtraBuilder>> ctx) {
		return new StudentViewHolder(view, ctx);
	}
}
