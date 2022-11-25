package pt.epcc.alunos.al220007.desafiofinal.humancore;

import android.content.Context;

import java.util.List;

import pt.epcc.alunos.al220007.desafiofinal.entities.Human;

public interface HumanAdapterCreator<T extends HumanAdapter<? extends HumanViewHolder>> {
	T createAdapter(List<? extends Human> list, Context context);
}
