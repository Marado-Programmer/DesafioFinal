package pt.epcc.alunos.al220007.desafiofinal;

import android.content.Context;

import java.util.List;

public interface HumanAdapterCreator<T extends HumanAdapter<? extends HumanViewHolder>> {
	T createAdapter(List<? extends Human> list, Context context);
}
