package pt.epcc.alunos.al220007.desafiofinal;

import android.os.Bundle;
import android.view.ViewStub;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import pt.epcc.alunos.al220007.desafiofinal.entities.Teacher;
import pt.epcc.alunos.al220007.desafiofinal.humancore.ExtraBuilder;

@SuppressWarnings("UnusedReturnValue")
public class TeacherExtraBuilder extends ExtraBuilder<Teacher> {
	private static final int SCHOOL_ID = R.id.teacherSchool;
	private static final int ACADEMIC_LVL_ID = R.id.teacherAcademicLevel;
	private static final int MODULES_ID = R.id.teacherModules;
	private static final int MODULES_TITLE_ID = R.id.teacherModulesTitle;
	private static final int MODULES_TITLE_STR = R.string.modules;
	private static final int MODULES_NAME_ID = R.id.teacherModulesName;
	private static final int MODULES_NAME_STR = R.string.name_txt;
	private static final int MODULES_YEAR_ID = R.id.teacherModulesYear;
	private static final int MODULES_YEAR_STR = R.string.year;
	private static final int MODULES_DURATION_ID = R.id.teacherModulesDuration;
	private static final int MODULES_DURATION_STR = R.string.duration;
	private static final int MODULES_CURRENT_ID = R.id.teacherModulesCurrent;
	private static final int MODULES_CURRENT_STR = R.string.current;

	public TeacherExtraBuilder(ViewStub view, Bundle human) {
		super(view, human);
	}

	@Override
	public ExtraBuilder<Teacher> start() {
		super.start();

		hide(SCHOOL_ID);
		hide(ACADEMIC_LVL_ID);
		hide(MODULES_ID);
		hide(MODULES_TITLE_ID);
		hide(MODULES_NAME_ID);
		hide(MODULES_YEAR_ID);
		hide(MODULES_DURATION_ID);
		hide(MODULES_CURRENT_ID);


		return this;
	}

	public TeacherExtraBuilder setSchool() {
		TextView v = show(SCHOOL_ID);
		v.setText(String.format("School:\t%s", human.getString(Teacher.SCHOOL_KEY)));

		return this;
	}

	public TeacherExtraBuilder setAcademicLvl() {
		TextView v = show(ACADEMIC_LVL_ID);
		v.setText(String.format(
			"Academic level:\t%s",
			human.getString(Teacher.ACADEMIC_LEVEL_KEY)
		));

		return this;
	}

	public TeacherExtraBuilder setModules() {
		RecyclerView v = show(MODULES_ID);

		show(MODULES_TITLE_ID);
		show(MODULES_NAME_ID);
		show(MODULES_YEAR_ID);
		show(MODULES_DURATION_ID);
		show(MODULES_CURRENT_ID);

		v.setLayoutManager(new LinearLayoutManager(ctx));
		v.setAdapter(
			new ModulesAdapter(human.getIntegerArrayList(Teacher.MODULES_KEYS_KEY))
		);

		TextView title = view(MODULES_TITLE_ID);
		title.setText(MODULES_TITLE_STR);
		TextView name = view(MODULES_NAME_ID);
		name.setText(MODULES_NAME_STR);
		TextView year = view(MODULES_YEAR_ID);
		year.setText(MODULES_YEAR_STR);
		TextView duration = view(MODULES_DURATION_ID);
		duration.setText(MODULES_DURATION_STR);
		TextView cur = view(MODULES_CURRENT_ID);
		cur.setText(MODULES_CURRENT_STR);

		return this;
	}
}
