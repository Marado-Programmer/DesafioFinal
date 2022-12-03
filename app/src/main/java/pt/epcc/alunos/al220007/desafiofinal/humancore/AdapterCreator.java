package pt.epcc.alunos.al220007.desafiofinal.humancore;

import androidx.annotation.NonNull;

import pt.epcc.alunos.al220007.desafiofinal.entities.Human;
import pt.epcc.alunos.al220007.desafiofinal.humancore.activities.DetailsActivity;
import pt.epcc.alunos.al220007.desafiofinal.humancore.activities.HumanActivity;

public interface AdapterCreator<
	E extends Human,
	T extends ExtraBuilder<E>,
	S extends Adapter<E, ? extends ViewHolder<E, T, ? extends DetailsActivity<E, T>>, ? extends ExtraBuilder<E>>
	> {
	@NonNull
	S createAdapter(HumanActivity<E, T, S> context);
}
