package pt.epcc.alunos.al220007.desafiofinal;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import pt.epcc.alunos.al220007.desafiofinal.entities.Student;
import pt.epcc.alunos.al220007.desafiofinal.humancore.HumanActivity;
import pt.epcc.alunos.al220007.desafiofinal.humancore.HumanAdapterCreator;

public class StudentActivity extends HumanActivity<Student, StudentAdapter> {
	@Override
	protected RecyclerView.LayoutManager choseLayoutManager() {
		return new LinearLayoutManager(this);
	}

	@Override
	protected HumanAdapterCreator<StudentAdapter> generateAdapterCreator() {
		return new StudentAdapterCreator();
	}

	@Override
	protected List<Student> generateList() {
		return new ArrayList<>(Arrays.asList(
			new Student(R.drawable.logo_epcc, "Zara G"),
			new Student(R.drawable.logo_epcc, "Gson"),
			new Student(R.drawable.logo_epcc, "Kroa"),
			new Student(R.drawable.logo_epcc, "Zizzy Jr")
		));
	}
}
