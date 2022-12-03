package pt.epcc.alunos.al220007.desafiofinal.humancore;

import android.view.View;

import androidx.annotation.NonNull;

import pt.epcc.alunos.al220007.desafiofinal.entities.Human;
import pt.epcc.alunos.al220007.desafiofinal.humancore.activities.DetailsActivity;
import pt.epcc.alunos.al220007.desafiofinal.humancore.activities.HumanActivity;

public interface ViewHolderCreator<E extends Human, T extends ViewHolder<E, S, ? extends DetailsActivity<E, S>>, S extends ExtraBuilder<E>> {
	@NonNull
	T createViewHolder(View view, HumanActivity<E, S, ? extends Adapter<E, T, S>> ctx);
}
