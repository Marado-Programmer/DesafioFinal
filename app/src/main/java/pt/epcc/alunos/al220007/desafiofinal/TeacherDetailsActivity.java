package pt.epcc.alunos.al220007.desafiofinal;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import pt.epcc.alunos.al220007.desafiofinal.entities.Student;
import pt.epcc.alunos.al220007.desafiofinal.entities.Teacher;
import pt.epcc.alunos.al220007.desafiofinal.humancore.HumanDetailsActivity;

public class TeacherDetailsActivity extends HumanDetailsActivity<Teacher> {
	@Override
	public void createDetails(View view, Bundle bundle) {
		TextView school = view.findViewById(R.id.teacherSchool);
		school.setText("School: " + bundle.getString(Teacher.SCHOOL_KEY));
		TextView academicLevel = view.findViewById(R.id.teacherAcademicLevel);
		academicLevel.setText("Academic level: " + bundle.getString(Teacher.ACADEMIC_LEVEL_KEY));
	}
}
