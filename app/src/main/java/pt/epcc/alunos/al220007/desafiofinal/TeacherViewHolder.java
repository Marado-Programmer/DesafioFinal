package pt.epcc.alunos.al220007.desafiofinal;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import pt.epcc.alunos.al220007.desafiofinal.entities.Teacher;
import pt.epcc.alunos.al220007.desafiofinal.humancore.Adapter;
import pt.epcc.alunos.al220007.desafiofinal.humancore.ViewHolder;
import pt.epcc.alunos.al220007.desafiofinal.humancore.activities.HumanActivity;

public class TeacherViewHolder extends ViewHolder<Teacher, TeacherDetailsActivity> {
	protected TeacherViewHolder(@NonNull View itemView, HumanActivity<Teacher, ? extends Adapter<Teacher, ? extends ViewHolder<Teacher, TeacherDetailsActivity>>> ctx) {
		super(itemView, ctx);
	}

	@Override
	protected int extraID() {
		return R.layout.teacher_extra;
	}

	@Override
	protected int miniExtraID() {
		return R.layout.teacher_extra_tiny;
	}

	@Override
	protected Class<TeacherDetailsActivity> aClass() {
		return TeacherDetailsActivity.class;
	}

	@Override
	public void createDetails(View view, Bundle bundle) {
		TextView school = view.findViewById(R.id.teacherSchool);
		school.setText(String.format("School: %s", human.getSchool()));
		TextView academicLevel = view.findViewById(R.id.teacherAcademicLevel);
		academicLevel.setText(String.format("Academic level: %s", human.getAcademicLevel()));

		RecyclerView modulesList = view.findViewById(R.id.teacherModules);
		modulesList.setLayoutManager(new LinearLayoutManager(context));
		modulesList.setAdapter(
			new ModulesAdapter(bundle.getIntegerArrayList(Teacher.MODULES_KEYS_KEY))
		);
	}
}
