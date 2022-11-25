package pt.epcc.alunos.al220007.desafiofinal.humancore;

import android.view.View;

import pt.epcc.alunos.al220007.desafiofinal.humancore.HumanViewHolder;

public interface HumanViewHolderCreator<T extends HumanViewHolder> {
	T createViewHolder(View view);
}
