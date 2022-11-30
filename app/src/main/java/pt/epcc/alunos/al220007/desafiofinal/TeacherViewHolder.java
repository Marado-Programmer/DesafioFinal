package pt.epcc.alunos.al220007.desafiofinal;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import pt.epcc.alunos.al220007.desafiofinal.entities.Teacher;
import pt.epcc.alunos.al220007.desafiofinal.humancore.HumanActivity;
import pt.epcc.alunos.al220007.desafiofinal.humancore.HumanViewHolder;

public class TeacherViewHolder extends HumanViewHolder<Teacher, TeacherDetailsActivity> {

	protected TeacherViewHolder(@NonNull View itemView, HumanActivity context) {
		super(itemView, context);
	}

	@Override
	protected int extraID() {
		return R.layout.teacher_extra;
	}

	@Override
	protected Class<TeacherDetailsActivity> aClass() {
		return TeacherDetailsActivity.class;
	}

	@Override
	public void createDetails(View view, Bundle bundle) {
		TextView school = view.findViewById(R.id.teacherSchool);
		school.setText("School: " + human.getSchool());
		TextView academicLevel = view.findViewById(R.id.teacherAcademicLevel);
		academicLevel.setText("Academic level: " + human.getAcademicLevel());
	}
}
