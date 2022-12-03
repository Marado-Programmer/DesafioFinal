package pt.epcc.alunos.al220007.desafiofinal;

import android.view.View;

import androidx.annotation.NonNull;

import pt.epcc.alunos.al220007.desafiofinal.entities.Student;
import pt.epcc.alunos.al220007.desafiofinal.humancore.Adapter;
import pt.epcc.alunos.al220007.desafiofinal.humancore.ViewHolder;
import pt.epcc.alunos.al220007.desafiofinal.humancore.activities.HumanActivity;

public class StudentViewHolder extends ViewHolder<Student, StudentExtraBuilder, StudentDetailsActivity> {
	protected StudentViewHolder(@NonNull View itemView, HumanActivity<Student, StudentExtraBuilder, ? extends Adapter<Student, ? extends ViewHolder<Student, StudentExtraBuilder, StudentDetailsActivity>, StudentExtraBuilder>> ctx) {
		super(itemView, ctx);
	}

	@Override
	protected int extraID() {
		return R.layout.student_extra;
	}
}
