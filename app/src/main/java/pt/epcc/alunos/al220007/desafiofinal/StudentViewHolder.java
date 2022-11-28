package pt.epcc.alunos.al220007.desafiofinal;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;

import pt.epcc.alunos.al220007.desafiofinal.humancore.HumanViewHolder;

public class StudentViewHolder extends HumanViewHolder {
	protected StudentViewHolder(@NonNull View itemView, Context context) {
		super(itemView, context);
	}

	@Override
	protected int extraID() {
		return R.layout.student_extra;
	}

	@Override
	protected void findViews(View view) {

	}

	@NonNull
	@Override
	protected Bundle helperBundle() {
		return new Bundle();
	}
}
