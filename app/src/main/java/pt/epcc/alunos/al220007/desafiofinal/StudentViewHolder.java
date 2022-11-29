package pt.epcc.alunos.al220007.desafiofinal;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import pt.epcc.alunos.al220007.desafiofinal.entities.Student;
import pt.epcc.alunos.al220007.desafiofinal.humancore.HumanActivity;
import pt.epcc.alunos.al220007.desafiofinal.humancore.HumanViewHolder;

public class StudentViewHolder extends HumanViewHolder<Student, StudentDetailsActivity> {
	protected StudentViewHolder(@NonNull View itemView, HumanActivity context) {
		super(itemView, context);
	}

	@Override
	protected int extraID() {
		return R.layout.student_extra;
	}

	@Override
	protected Class<StudentDetailsActivity> aClass() {
		return StudentDetailsActivity.class;
	}

	@Override
	public void createDetails(View view, Bundle bundle) {

	}
}
