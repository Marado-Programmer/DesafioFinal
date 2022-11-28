package pt.epcc.alunos.al220007.desafiofinal;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import pt.epcc.alunos.al220007.desafiofinal.entities.Human;
import pt.epcc.alunos.al220007.desafiofinal.entities.Teacher;
import pt.epcc.alunos.al220007.desafiofinal.humancore.HumanActivity;
import pt.epcc.alunos.al220007.desafiofinal.humancore.HumanViewHolder;

public class TeacherViewHolder extends HumanViewHolder<Teacher> {
	public static String SCHOOL_KEY = "school";
	public static String ACADEMIC_LVL_KEY = "lvl";

	public TextView school, academicLevel;

	protected TeacherViewHolder(@NonNull View itemView, HumanActivity context) {
		super(itemView, context);
	}

	@Override
	protected int extraID() {
		return R.layout.teacher_extra;
	}

	@Override
	protected void findViews(View view) {
		this.school = view.findViewById(R.id.teacherSchool);
		this.academicLevel = view.findViewById(R.id.teacherAcademicLevel);
	}

	@NonNull
	@Override
	protected Bundle helperBundle() {
		Bundle bundle = new Bundle();

		bundle.putString(SCHOOL_KEY, human.getSchool());
		bundle.putString(ACADEMIC_LVL_KEY, String.valueOf(human.getAcademicLevel()));

		return bundle;
	}
}
