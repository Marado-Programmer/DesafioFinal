package pt.epcc.alunos.al220007.desafiofinal;

import android.view.View;

public interface HumanViewHolderCreator<T extends HumanViewHolder> {
	T createViewHolder(View view);
}
