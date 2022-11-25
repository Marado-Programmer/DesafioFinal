package pt.epcc.alunos.al220007.desafiofinal;

import android.view.View;

import androidx.annotation.NonNull;

import pt.epcc.alunos.al220007.desafiofinal.humancore.HumanViewHolder;

public class StudentViewHolder extends HumanViewHolder {
	protected StudentViewHolder(@NonNull View itemView) {
		super(itemView);
	}

	@Override
	protected int extraID() {
		return R.layout.student_extra;
	}

	@Override
	protected void findViews(View view) {

	}

	@Override
	public void onClick(View v) {

	}
}
