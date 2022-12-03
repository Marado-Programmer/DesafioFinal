package pt.epcc.alunos.al220007.desafiofinal;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import pt.epcc.alunos.al220007.desafiofinal.entities.Teacher;
import pt.epcc.alunos.al220007.desafiofinal.humancore.Adapter;
import pt.epcc.alunos.al220007.desafiofinal.humancore.activities.HumanActivity;

public class TeacherAdapter extends Adapter<Teacher, TeacherViewHolder> {
	public TeacherAdapter(HumanActivity<Teacher, ? extends Adapter<Teacher, TeacherViewHolder>> context) {
		super(context);
	}

	@Override
	protected void manageTinyExtra(View view, Teacher human) {
		TextView school = view.findViewById(R.id.teacherSchool);
		school.setText(String.format("School: %s", human.getSchool()));
	}

	@Override
	protected LayoutManagerType getDefaultLayout() {
		return LayoutManagerType.GRID;
	}

	@NonNull
	@Override
	public TeacherViewHolder createViewHolder(View view, HumanActivity<Teacher, ? extends Adapter<Teacher, TeacherViewHolder>> context) {
		return new TeacherViewHolder(view, context);
	}
}
