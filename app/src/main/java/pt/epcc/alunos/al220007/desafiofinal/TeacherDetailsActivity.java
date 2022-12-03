package pt.epcc.alunos.al220007.desafiofinal;

import android.os.Bundle;
import android.view.ViewStub;

import androidx.annotation.NonNull;

import pt.epcc.alunos.al220007.desafiofinal.entities.Teacher;
import pt.epcc.alunos.al220007.desafiofinal.humancore.Adapter;
import pt.epcc.alunos.al220007.desafiofinal.humancore.ExtraBuilder;
import pt.epcc.alunos.al220007.desafiofinal.humancore.ViewHolder;
import pt.epcc.alunos.al220007.desafiofinal.humancore.activities.DetailsActivity;
import pt.epcc.alunos.al220007.desafiofinal.humancore.activities.HumanActivity;

public class TeacherDetailsActivity extends DetailsActivity<Teacher, TeacherExtraBuilder> {
	@Override
	public void createDetails(TeacherExtraBuilder builder) {
		builder.start();
		builder.setSchool().setAcademicLvl().setModules();
	}

	@Override
	public TeacherExtraBuilder createBuilder(@NonNull ViewStub view, Bundle human) {
		return new TeacherExtraBuilder(view, human);
	}

	@NonNull
	@Override
	public Class<? extends HumanActivity<Teacher, TeacherExtraBuilder, ? extends Adapter<Teacher, ? extends ViewHolder<Teacher, TeacherExtraBuilder, ? extends DetailsActivity<Teacher, TeacherExtraBuilder>>, ? extends ExtraBuilder<Teacher>>>> nextDetailsManager() {
		return TeacherActivity.class;
	}
}