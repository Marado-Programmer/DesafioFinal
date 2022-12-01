package pt.epcc.alunos.al220007.desafiofinal;

import android.view.View;

import androidx.annotation.NonNull;

import pt.epcc.alunos.al220007.desafiofinal.entities.Student;
import pt.epcc.alunos.al220007.desafiofinal.humancore.HumanActivity;
import pt.epcc.alunos.al220007.desafiofinal.humancore.HumanAdapter;

public class StudentAdapter extends HumanAdapter<Student, StudentViewHolder, StudentAdapter> {
	public StudentAdapter(HumanActivity<Student, StudentAdapter> context) {
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
	public StudentViewHolder createViewHolder(View view, HumanActivity context) {
		return new StudentViewHolder(view, context);
	}
}
