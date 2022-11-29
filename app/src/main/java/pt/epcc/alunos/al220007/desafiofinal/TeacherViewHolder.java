package pt.epcc.alunos.al220007.desafiofinal;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import pt.epcc.alunos.al220007.desafiofinal.entities.Teacher;
import pt.epcc.alunos.al220007.desafiofinal.humancore.HumanActivity;
import pt.epcc.alunos.al220007.desafiofinal.humancore.HumanViewHolder;

public class TeacherViewHolder extends HumanViewHolder<Teacher> {

	protected TeacherViewHolder(@NonNull View itemView, HumanActivity context) {
		super(itemView, context);
	}


	@Override
	protected int extraID() {
		return R.layout.teacher_extra;
	}

	@Override
	protected void findViews(View view) {
		Log.i("FINDING", String.valueOf(view));
		TextView school = view.findViewById(R.id.teacherSchool);
		school.setText("School: " + human.getSchool());
		TextView academicLevel = view.findViewById(R.id.teacherAcademicLevel);
		academicLevel.setText("Academic level: " + human.getAcademicLevel());
	}
}
