package pt.epcc.alunos.al220007.desafiofinal;

import android.os.Bundle;
import android.view.ViewStub;

import androidx.annotation.NonNull;

import pt.epcc.alunos.al220007.desafiofinal.entities.Student;
import pt.epcc.alunos.al220007.desafiofinal.humancore.Adapter;
import pt.epcc.alunos.al220007.desafiofinal.humancore.ExtraBuilder;
import pt.epcc.alunos.al220007.desafiofinal.humancore.ViewHolder;
import pt.epcc.alunos.al220007.desafiofinal.humancore.activities.DetailsActivity;
import pt.epcc.alunos.al220007.desafiofinal.humancore.activities.HumanActivity;

public class StudentDetailsActivity extends DetailsActivity<Student, StudentExtraBuilder> {
	@Override
	public void createDetails(StudentExtraBuilder builder) {
		builder.start();
		builder.setHobbies();
	}

	@Override
	public StudentExtraBuilder createBuilder(@NonNull ViewStub view, Bundle human) {
		return new StudentExtraBuilder(view, human);
	}

	@NonNull
	@Override
	public Class<? extends HumanActivity<Student, StudentExtraBuilder, ? extends Adapter<Student, ? extends ViewHolder<Student, StudentExtraBuilder, ? extends DetailsActivity<Student, StudentExtraBuilder>>, ? extends ExtraBuilder<Student>>>> nextDetailsManager() {
		return StudentActivity.class;
	}
}
