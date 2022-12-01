package pt.epcc.alunos.al220007.desafiofinal;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import pt.epcc.alunos.al220007.desafiofinal.entities.Teacher;
import pt.epcc.alunos.al220007.desafiofinal.humancore.HumanActivity;
import pt.epcc.alunos.al220007.desafiofinal.humancore.HumanAdapter;

public class TeacherAdapter extends HumanAdapter<Teacher, TeacherViewHolder, TeacherAdapter> {
	public TeacherAdapter(HumanActivity<Teacher, TeacherAdapter> context) {
		super(context);
	}

	@Override
	protected void manageTinyExtra(View view, Teacher human) {
		TextView school = view.findViewById(R.id.teacherSchool);
		school.setText("School: " + human.getSchool());
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
