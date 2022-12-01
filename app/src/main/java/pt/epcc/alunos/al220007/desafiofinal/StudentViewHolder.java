package pt.epcc.alunos.al220007.desafiofinal;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;

import pt.epcc.alunos.al220007.desafiofinal.entities.Hobby;
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
	protected int miniExtraID() {
		return R.layout.student_extra_tiny;
	}

	@Override
	protected Class<StudentDetailsActivity> aClass() {
		return StudentDetailsActivity.class;
	}

	@Override
	public void createDetails(View view, Bundle bundle) {
		ListView hobbies = view.findViewById(R.id.studentHobbies);
		hobbies.setAdapter(
			new ArrayAdapter<>(context,
				R.layout.simple_list_item,
				human.getHobbies().stream().map(Hobby::getName).toArray()
			)
		);
	}
}
