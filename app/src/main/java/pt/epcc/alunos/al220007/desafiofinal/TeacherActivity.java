package pt.epcc.alunos.al220007.desafiofinal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import pt.epcc.alunos.al220007.desafiofinal.entities.AcademicLevel;
import pt.epcc.alunos.al220007.desafiofinal.entities.Teacher;
import pt.epcc.alunos.al220007.desafiofinal.humancore.HumanActivity;
import pt.epcc.alunos.al220007.desafiofinal.humancore.HumanAdapterCreator;

public class TeacherActivity extends HumanActivity<Teacher, TeacherAdapter> {

	@Override
	public HumanAdapterCreator<TeacherAdapter> generateAdapterCreator() {
		return new TeacherAdapterCreator();
	}

	@Override
	public List<Teacher> generateList() {
		return new ArrayList<>(Arrays.asList(
			new Teacher(R.drawable.ic_launcher_foreground, "Augusto", "Bambi", AcademicLevel.BACHELOR),
			new Teacher(R.drawable.ic_launcher_background, "Marado", "EBSANTONIO", AcademicLevel.LICENTIATE),
			new Teacher(R.drawable.logo_epcc, "Torres", "EPCC", AcademicLevel.MASTER),
			new Teacher(R.drawable.ic_launcher_foreground, "Joao", "sim", AcademicLevel.DOCTOR)
		));
	}

	@Override
	protected LayoutManagerType choseLayoutManager() {
		return LayoutManagerType.GRID;
	}
}
