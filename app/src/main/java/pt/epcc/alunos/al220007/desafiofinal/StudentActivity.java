package pt.epcc.alunos.al220007.desafiofinal;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import pt.epcc.alunos.al220007.desafiofinal.entities.Hobby;
import pt.epcc.alunos.al220007.desafiofinal.entities.Student;
import pt.epcc.alunos.al220007.desafiofinal.humancore.HumanActivity;

public class StudentActivity extends HumanActivity<Student, StudentAdapter> {
	protected List<Hobby> hobbies;

	@Override
	protected LayoutManagerType choseLayoutManager() {
		return LayoutManagerType.LINEAR;
	}

	@Override
	public List<Student> generateList() {
		hobbies = Arrays.stream(getResources().getStringArray(R.array.hobbies))
			.map(Hobby::new).collect(Collectors.toList());

		return new ArrayList<>(Arrays.asList(
			createHumanWithRandomHobbies(R.drawable.logo_epcc, "Zara G"),
			createHumanWithRandomHobbies(R.drawable.logo_epcc, "Gson"),
			createHumanWithRandomHobbies(R.drawable.logo_epcc, "Kroa"),
			createHumanWithRandomHobbies(R.drawable.logo_epcc, "Zizzy Jr")
			)
		);
	}

	@NonNull
	@Override
	public StudentAdapter createAdapter(HumanActivity<Student, StudentAdapter> context) {
		return new StudentAdapter(context);
	}

	protected Student createHumanWithRandomHobbies(int image, String name) {
		Random random = new Random();
		int numHobbies = random.nextInt(5);

		List<Hobby> hobbies = this.hobbies.subList(0, this.hobbies.size() -1);

		Student student = new Student(image, name);

		for (int i = 0; i < numHobbies; i++) {
			student.addHobby(hobbies.remove(random.nextInt(hobbies.size())));
		}

		return student;
	}
}
