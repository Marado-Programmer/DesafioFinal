package pt.epcc.alunos.al220007.desafiofinal;

import android.view.View;

import androidx.annotation.NonNull;

import pt.epcc.alunos.al220007.desafiofinal.entities.Student;
import pt.epcc.alunos.al220007.desafiofinal.humancore.Adapter;
import pt.epcc.alunos.al220007.desafiofinal.humancore.activities.HumanActivity;

public class StudentAdapter extends Adapter<Student, StudentViewHolder> {
	public StudentAdapter(HumanActivity<Student, ? extends Adapter<Student, StudentViewHolder>> context) {
		super(context);
	}

	@Override
	protected void manageTinyExtra(View view, Student human) {

	}

	@Override
	protected LayoutManagerType getDefaultLayout() {
		return LayoutManagerType.LINEAR;
	}

	@NonNull
	@Override
	public StudentViewHolder createViewHolder(View view, HumanActivity<Student, ? extends Adapter<Student, StudentViewHolder>> context) {
		return new StudentViewHolder(view, context);
	}
}
