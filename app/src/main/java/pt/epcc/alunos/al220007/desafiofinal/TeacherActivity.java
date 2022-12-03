package pt.epcc.alunos.al220007.desafiofinal;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import pt.epcc.alunos.al220007.desafiofinal.entities.AcademicLevel;
import pt.epcc.alunos.al220007.desafiofinal.entities.SchoolYear;
import pt.epcc.alunos.al220007.desafiofinal.entities.Subject;
import pt.epcc.alunos.al220007.desafiofinal.entities.SubjectModule;
import pt.epcc.alunos.al220007.desafiofinal.entities.Teacher;
import pt.epcc.alunos.al220007.desafiofinal.humancore.activities.DetailsActivity;
import pt.epcc.alunos.al220007.desafiofinal.humancore.activities.HumanActivity;

public class TeacherActivity extends HumanActivity<Teacher, TeacherAdapter> {
	protected static List<Teacher> teachers;

	@Override
	protected LayoutManagerType choseLayoutManager() {
		return LayoutManagerType.GRID;
	}

	@Override
	public List<Teacher> generateList() {
		if (teachers != null) {
			return teachers;
		}

		teachers = new ArrayList<>();

		SubjectModule subject0 = SubjectModule.createOrGetInstance(
			10684,
			"Fernando Pessoa Ortónimo e Heterónimo",
			SchoolYear.THIRD,
			Subject.PORTUGUESE,
			40
		);
		subject0.addHours(40);
		SubjectModule subject1 = SubjectModule.createOrGetInstance(
			10685,
			"Poesia Contemporânea",
			SchoolYear.THIRD,
			Subject.PORTUGUESE,
			40
		);
		subject1.addHours(12);
		SubjectModule subject2 = SubjectModule.createOrGetInstance(
			10695,
			"O mundo do trabalho",
			SchoolYear.THIRD,
			Subject.ENGLISH,
			25
		);
		subject2.addHours(6);
		SubjectModule subject3 = SubjectModule.createOrGetInstance(
			10699,
			"A União Europeia",
			SchoolYear.FIRST,
			Subject.INTEGRATION_AREA,
			25
		);
		subject3.addHours(25);
		SubjectModule subject4 = SubjectModule.createOrGetInstance(
			10701,
			"A Globalização",
			SchoolYear.SECOND,
			Subject.INTEGRATION_AREA,
			25
		);
		subject4.addHours(25);
		SubjectModule subject5 = SubjectModule.createOrGetInstance(
			10723,
			"Funções de Crescimento",
			SchoolYear.THIRD,
			Subject.MATH,
			28
		);
		subject5.addHours(20);
		SubjectModule subject6 = SubjectModule.createOrGetInstance(
			10730,
			"Circuitos Elétricos",
			SchoolYear.FIRST,
			Subject.PHYSICS,
			18
		);
		subject6.addHours(18);
		SubjectModule subject7 = SubjectModule.createOrGetInstance(
			10738,
			"Compostos Orgânicos | Reações Químicas",
			SchoolYear.THIRD,
			Subject.CHEMISTRY,
			16
		);
		subject7.addMinutes(50);

		Teacher teacher0 = new Teacher(
			R.drawable.grid,
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
			R.drawable.linear,
			"Joao",
			"Snoopy",
			AcademicLevel.DOCTOR
		);
		teacher3.addSubjectModule(subject3);

		teachers.add(teacher0);
		teachers.add(teacher1);
		teachers.add(teacher2);
		teachers.add(teacher3);

		return teachers;
	}

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
	protected Class<? extends DetailsActivity<Teacher>> nextDetailsManager() {
		return TeacherDetailsActivity.class;
	}

	@NonNull
	@Override
	public TeacherAdapter createAdapter(HumanActivity<Teacher, TeacherAdapter> context) {
		return new TeacherAdapter(context);
	}
}
