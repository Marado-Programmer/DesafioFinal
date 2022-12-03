package pt.epcc.alunos.al220007.desafiofinal;

import android.view.View;

import androidx.annotation.NonNull;

import pt.epcc.alunos.al220007.desafiofinal.entities.Teacher;
import pt.epcc.alunos.al220007.desafiofinal.humancore.Adapter;
import pt.epcc.alunos.al220007.desafiofinal.humancore.ExtraBuilder;
import pt.epcc.alunos.al220007.desafiofinal.humancore.ViewHolder;
import pt.epcc.alunos.al220007.desafiofinal.humancore.activities.HumanActivity;

public class TeacherViewHolder extends ViewHolder<Teacher, TeacherExtraBuilder, TeacherDetailsActivity> {
	protected TeacherViewHolder(@NonNull View itemView, HumanActivity<Teacher, TeacherExtraBuilder, ? extends Adapter<Teacher, ? extends ViewHolder<Teacher, TeacherExtraBuilder, TeacherDetailsActivity>, ? extends ExtraBuilder<Teacher>>> ctx) {
		super(itemView, ctx);
	}

	@Override
	protected int extraID() {
		return R.layout.teacher_extra;
	}
}
