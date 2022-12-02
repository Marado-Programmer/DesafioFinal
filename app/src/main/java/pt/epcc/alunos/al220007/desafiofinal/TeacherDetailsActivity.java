package pt.epcc.alunos.al220007.desafiofinal;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import pt.epcc.alunos.al220007.desafiofinal.entities.Teacher;
import pt.epcc.alunos.al220007.desafiofinal.humancore.ViewHolder;
import pt.epcc.alunos.al220007.desafiofinal.humancore.activities.HumanActivity;
import pt.epcc.alunos.al220007.desafiofinal.humancore.Adapter;
import pt.epcc.alunos.al220007.desafiofinal.humancore.activities.DetailsActivity;

public class TeacherDetailsActivity extends DetailsActivity<Teacher> {
	@Override
	public void createDetails(View view, Bundle bundle) {
		TextView school = view.findViewById(R.id.teacherSchool);
		school.setText(String.format("School: %s", bundle.getString(Teacher.SCHOOL_KEY)));
		TextView academicLevel = view.findViewById(R.id.teacherAcademicLevel);
		academicLevel.setText(String.format("Academic level: %s", bundle.getString(Teacher.ACADEMIC_LEVEL_KEY)));

		RecyclerView modulesList = view.findViewById(R.id.teacherModules);
		modulesList.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
		modulesList.setAdapter(
			new ModulesAdapter(bundle.getIntegerArrayList(Teacher.MODULES_KEYS_KEY))
		);
	}

	@NonNull
	@Override
	protected Class<? extends HumanActivity<Teacher, ? extends Adapter<Teacher, ? extends ViewHolder<Teacher, ? extends DetailsActivity<Teacher>>>>> nextDetailsManager() {
		return TeacherActivity.class;
	}
}