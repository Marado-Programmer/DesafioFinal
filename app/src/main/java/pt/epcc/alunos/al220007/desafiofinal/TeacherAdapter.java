package pt.epcc.alunos.al220007.desafiofinal;

import android.content.Context;

import java.util.List;

public class TeacherAdapter extends HumanAdapter<TeacherViewHolder> {

	public <E extends Human> TeacherAdapter(List<E> list, Context context) {
		super(list, context);
	}

	@Override
	protected HumanViewHolderCreator<TeacherViewHolder> createCreator() {
		return new TeacherViewHolderCreator();
	}

	@Override
	protected <E extends Human> void manage(TeacherViewHolder holder, E human) {
		Teacher teacher = (Teacher) human;
		holder.profilePic.setImageResource(teacher.getImage());
	}
}
