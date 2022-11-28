package pt.epcc.alunos.al220007.desafiofinal;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import pt.epcc.alunos.al220007.desafiofinal.humancore.HumanViewHolder;

public class TeacherViewHolder extends HumanViewHolder {
	public TextView school, academicLevel;

	protected TeacherViewHolder(@NonNull View itemView) {
		super(itemView);
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
		return new Bundle();
	}
}
