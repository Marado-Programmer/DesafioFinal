package pt.epcc.alunos.al220007.desafiofinal;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import pt.epcc.alunos.al220007.desafiofinal.entities.Human;
import pt.epcc.alunos.al220007.desafiofinal.entities.Student;
import pt.epcc.alunos.al220007.desafiofinal.humancore.HumanAdapter;
import pt.epcc.alunos.al220007.desafiofinal.humancore.HumanViewHolder;
import pt.epcc.alunos.al220007.desafiofinal.humancore.HumanViewHolderCreator;

public class StudentAdapter extends HumanAdapter<StudentViewHolder> {

	public <E extends Human> StudentAdapter(List<E> list, Context context) {
		super(list, context);
	}

	@Override
	protected HumanViewHolderCreator<StudentViewHolder> createCreator() {
		return new StudentViewHolderCreator();
	}

	@Override
	protected <E extends Human> void manage(StudentViewHolder holder, E human) {

	}
}
