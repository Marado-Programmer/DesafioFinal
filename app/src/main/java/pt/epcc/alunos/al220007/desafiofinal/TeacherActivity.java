package pt.epcc.alunos.al220007.desafiofinal;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import pt.epcc.alunos.al220007.desafiofinal.entities.AcademicLevel;
import pt.epcc.alunos.al220007.desafiofinal.entities.SchoolYear;
import pt.epcc.alunos.al220007.desafiofinal.entities.Subject;
import pt.epcc.alunos.al220007.desafiofinal.entities.SubjectModule;
import pt.epcc.alunos.al220007.desafiofinal.entities.Teacher;
import pt.epcc.alunos.al220007.desafiofinal.humancore.HumanActivity;

public class TeacherActivity extends HumanActivity<Teacher, TeacherAdapter> {
	@Override
	protected LayoutManagerType choseLayoutManager() {
		return LayoutManagerType.GRID;
	}

	@Override
	public List<Teacher> generateList() {
		ArrayList<Teacher> list = new ArrayList<>();


		SubjectModule subject0 = SubjectModule.createOrGetInstance(
			10684,
			"Fernando Pessoa Ortónimo e Heterónimo",
			SchoolYear.THIRD,
			Subject.PORTUGUESE,
			40
		);
		try {
			subject0.addHours(40);
		} catch (Exception e) {

		}
		SubjectModule subject1 = SubjectModule.createOrGetInstance(
			10685,
			"Poesia Contemporânea",
			SchoolYear.THIRD,
			Subject.PORTUGUESE,
			40
		);
		try {
			subject1.addHours(12);
		} catch (Exception e) {

		}
		SubjectModule subject2 = SubjectModule.createOrGetInstance(
			10695,
			"O mundo do trabalho",
			SchoolYear.THIRD,
			Subject.ENGLISH,
			25
		);
		try {
			subject2.addHours(6);
		} catch (Exception e) {

		}
		SubjectModule subject3 = SubjectModule.createOrGetInstance(
			10699,
			"A União Europeia",
			SchoolYear.FIRST,
			Subject.INTEGRATION_AREA,
			25
		);
		try {
			subject3.addHours(25);
		} catch (Exception e) {

		}
		SubjectModule subject4 = SubjectModule.createOrGetInstance(
			10701,
			"A Globalização",
			SchoolYear.SECOND,
			Subject.INTEGRATION_AREA,
			25
		);
		try {
			subject4.addHours(25);
		} catch (Exception e) {

		}
		SubjectModule subject5 = SubjectModule.createOrGetInstance(
			10723,
			"Funções de Crescimento",
			SchoolYear.THIRD,
			Subject.MATH,
			28
		);
		try {
			subject5.addHours(20);
		} catch (Exception e) {

		}
		SubjectModule subject6 = SubjectModule.createOrGetInstance(
			10730,
			"Circuitos Elétricos",
			SchoolYear.FIRST,
			Subject.PHYSICS,
			18
		);
		try {
			subject6.addHours(18);
		} catch (Exception e) {

		}
		SubjectModule subject7 = SubjectModule.createOrGetInstance(
			10738,
			"Compostos Orgânicos | Reações Químicas",
			SchoolYear.THIRD,
			Subject.CHEMISTRY,
			16
		);
		try {
			subject7.addMinutes(50);
		} catch (Exception e) {

		}

		Teacher teacher0 = new Teacher(
			R.drawable.ic_launcher_foreground,
			"Augusto",
			"Bambi",
			AcademicLevel.BACHELOR
		);
		teacher0.addSubjectModule(subject0);
		teacher0.addSubjectModule(subject4);
		Teacher teacher1 = new Teacher(
			R.drawable.ic_launcher_background,
			"Marado",
			"EBSANTONIO",
			AcademicLevel.LICENTIATE
		);
		teacher1.addSubjectModule(subject1);
		teacher1.addSubjectModule(subject6);
		teacher1.addSubjectModule(subject7);
		Teacher teacher2 = new Teacher(
			R.drawable.logo_epcc,
			"Torres",
			"EPCC",
			AcademicLevel.MASTER
		);
		teacher2.addSubjectModule(subject2);
		teacher2.addSubjectModule(subject5);
		Teacher teacher3 = new Teacher(
			R.drawable.ic_launcher_foreground,
			"Joao",
			"Snoopy",
			AcademicLevel.DOCTOR
		);
		teacher3.addSubjectModule(subject3);

		list.add(teacher0);
		list.add(teacher1);
		list.add(teacher2);
		list.add(teacher3);

		return list;
	}

	@NonNull
	@Override
	public TeacherAdapter createAdapter(HumanActivity<Teacher, TeacherAdapter> context) {
		return new TeacherAdapter(context);
	}
}
